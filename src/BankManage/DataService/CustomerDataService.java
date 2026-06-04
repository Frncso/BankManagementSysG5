package BankManage.DataService;

import BankManage.AccountModels.CustomerModel;
import BankManage.AppService.Encryption;
import java.sql.*;

public class CustomerDataService {

    Encryption en = new Encryption();
    
    public boolean save(CustomerModel customer) {
    String sql = "INSERT INTO customers " +
                 "(first_name, last_name, password, date_of_birth, occupation, income_range, id_type, id_number, is_active, customer_id)" +
                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, 'TEMP')";

    try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

        stmt.setString(1, customer.getFirstName());
        stmt.setString(2, customer.getLastName());
        stmt.setString(3, customer.getPassword());
        stmt.setString(4, customer.getDateOfBirth());
        stmt.setString(5, customer.getOccupation());
        stmt.setString(6, customer.getIncomeRange());
        stmt.setString(7, customer.getIdType());
        stmt.setString(8, customer.getIdNumber());
        stmt.setBoolean(9, customer.isActive());

        int affectedRows = stmt.executeUpdate();

        if (affectedRows == 0) {
            return false;
        }

        // gen id
        try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int generatedId = generatedKeys.getInt(1);

                // custom id based on the auto_increment from sql
                int year = java.time.LocalDate.now().getYear();
                String seq = String.format("%05d", generatedId);
                String initials = (en.decrypt(customer.getFirstName().substring(0, 1)).toUpperCase() +
                                   en.decrypt(customer.getLastName().substring(0, 1)).toUpperCase());

                String customId = "U" + year + "-" + seq + "-" + initials;
                customer.setCustomerId(customId);

                // update row iwth custom id
                String updateSql = "UPDATE customers SET customer_id = ? WHERE c_id = ?";
                try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                    updateStmt.setString(1, customId);
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

    public CustomerModel findByCredentials(String customerID) {
        String sql = "SELECT * FROM customers WHERE customer_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, customerID);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                CustomerModel c = new CustomerModel();
                c.setCustomerId(rs.getString("customer_id"));
                c.setFirstName(rs.getString("first_name"));
                c.setLastName(rs.getString("last_name"));
                c.setPassword(rs.getString("password"));
                c.setDateOfBirth(rs.getString("date_of_birth"));
                c.setOccupation(rs.getString("occupation"));
                c.setIncomeRange(rs.getString("income_range"));
                c.setIdType(rs.getString("id_type"));
                c.setIdNumber(rs.getString("id_number"));
                c.setActive(rs.getBoolean("is_active"));
                return c;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public int getMaxSequenceForCurrentYear() {
    int currentYear = java.time.LocalDate.now().getYear();
    String sql = "SELECT MAX(CAST(SUBSTRING_INDEX(customer_id, '-', 2) AS UNSIGNED)) " +
                 "FROM customers WHERE customer_id LIKE 'U" + currentYear + "-%'";

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