package BankManage.DataService;

import BankManage.AccountModels.BankAccount;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BankAccountDataService {

    public boolean save(BankAccount account, String initials) {
        String sql = "INSERT INTO bank_accounts (customer_id, account_type, balance, status, account_id) " +
                     "VALUES (?, ?, ?, ?, 'TEMP')";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, account.getCustomerId());
            stmt.setString(2, account.getAccountType());
            stmt.setDouble(3, account.getBalance());
            stmt.setString(4, account.getStatus());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) return false;

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedA_id = generatedKeys.getInt(1);
                    account.setA_id(generatedA_id);

                    // account id formatting
                    String accountId = "ACC-" + String.format("%05d", generatedA_id) + "-" + initials;
                    account.setAccountId(accountId);

                    String updateSql = "UPDATE bank_accounts SET account_id = ? WHERE a_id = ?";
                    try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                        updateStmt.setString(1, accountId);
                        updateStmt.setInt(2, generatedA_id);
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

    public List<BankAccount> findByCustomerId(String customerId) {
        List<BankAccount> list = new ArrayList<>();
        String sql = "SELECT * FROM bank_accounts WHERE customer_id = ? ORDER BY account_type";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, customerId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                BankAccount acc = new BankAccount();
                acc.setA_id(rs.getInt("a_id"));
                acc.setAccountId(rs.getString("account_id"));
                acc.setCustomerId(rs.getString("customer_id"));
                acc.setAccountType(rs.getString("account_type"));
                acc.setBalance(rs.getDouble("balance"));
                acc.setStatus(rs.getString("status"));
                list.add(acc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean updateStatus(String accountId, String newStatus) {
        String sql = "UPDATE bank_accounts SET status = ? WHERE account_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newStatus);
            stmt.setString(2, accountId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}