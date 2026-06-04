package BankManage.DataService;

import BankManage.AccountModels.EmployeeModel;
import BankManage.AppService.Encryption;
import java.sql.*;

public class EmployeeDataService {
    
    Encryption en = new Encryption();
    
    public boolean save(EmployeeModel employee) {
        String sql = "INSERT INTO employees (first_name, last_name, password, date_of_birth, position, access_code, employee_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, 'TEMP')";

        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, employee.getEmployeeFName());
            stmt.setString(2, employee.getEmployeeLName());
            stmt.setString(3, employee.getEmployeeSecPin());
            stmt.setString(4, employee.getEmployeeDOfBirth());
            stmt.setString(5, employee.getEmployeePosition());
            stmt.setString(6, employee.getAccessCode());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                return false;
            }

        // grab auto_increment from sql
        try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int generatedId = generatedKeys.getInt(1);

                // display id gen
                int year = java.time.LocalDate.now().getYear();
                String seq = String.format("%05d", generatedId);
                String initials = (en.decrypt(employee.getEmployeeFName().substring(0, 1)).toUpperCase() +
                                   en.decrypt(employee.getEmployeeLName().substring(0, 1)).toUpperCase());

                String customEmployeeId = "AU" + year + "-" + seq + "-" + initials;
                employee.setEmployeeId(customEmployeeId);

                // custom id updation on specified na value " ? "
                String updateSql = "UPDATE employees SET employee_id = ? WHERE e_id = ?";
                try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                    updateStmt.setString(1, customEmployeeId);
                    updateStmt.setInt(2, generatedId);
                    updateStmt.executeUpdate();
                }
            }
        }
        return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public int getMaxSequenceForCurrentYear() {
        int currentYear = java.time.LocalDate.now().getYear();
        String sql = "SELECT MAX(CAST(SUBSTRING_INDEX(employee_id, '-', 2) AS UNSIGNED)) " +
                     "FROM employees WHERE employee_id LIKE 'AU" + currentYear + "-%'";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                return rs.getInt(1); // return ung highest
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; // no records
    }
    
    public EmployeeModel findByCredentials(String staffID) {
        String sql = "SELECT * FROM employees WHERE employee_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, staffID);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                EmployeeModel e = new EmployeeModel();
                e.setEmployeeId(rs.getString("employee_id"));
                e.setEmployeeFName(rs.getString("first_name"));
                e.setEmployeeLName(rs.getString("last_name"));
                e.setEmployeeSecPin(rs.getString("password"));
                e.setEmployeeDOfBirth(rs.getString("date_of_birth"));
                e.setEmployeePosition(rs.getString("position"));
                e.setAccessCode(rs.getString("access_code"));
                return e;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}