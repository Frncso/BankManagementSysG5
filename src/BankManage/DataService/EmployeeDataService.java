package BankManage.DataService;

import BankManage.AccountModels.EmployeeModel;
import java.sql.*;

public class EmployeeDataService {

    public boolean save(EmployeeModel employee) {
        String sql = "INSERT INTO employees (employee_id, first_name, last_name, password, date_of_birth, position, access_code) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, employee.getEmployeeId());
            stmt.setString(2, employee.getEmployeeFName());
            stmt.setString(3, employee.getEmployeeLName());
            stmt.setString(4, employee.getEmployeeSecPin());
            stmt.setString(5, employee.getEmployeeDOfBirth());
            stmt.setString(6, employee.getEmployeePosition());
            stmt.setString(7, employee.getAccessCode());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
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
    
    public int getMaxSequenceForCurrentYear() {
    int currentYear = java.time.LocalDate.now().getYear();
    String sql = "SELECT MAX(CAST(SUBSTRING_INDEX(customer_id, '-', 2) AS UNSIGNED)) " +
                 "FROM employees WHERE customer_id LIKE 'AU" + currentYear + "-%'";

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
}