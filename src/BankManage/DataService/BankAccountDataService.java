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
    
    // get account by id (for record sakes)
    public BankAccount getAccountById(String accountId) {
        String sql = "SELECT * FROM bank_accounts WHERE account_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, accountId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                BankAccount acc = new BankAccount();
                acc.setAccountId(rs.getString("account_id"));
                acc.setCustomerId(rs.getString("customer_id"));
                acc.setAccountType(rs.getString("account_type"));
                acc.setBalance(rs.getDouble("balance"));
                acc.setStatus(rs.getString("status"));
                return acc;
            }
        } catch (SQLException e) {
            System.out.println("BankAccountDS Error [getAccountById]: " + e.getMessage());
        }
        return null;
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
    
    public boolean closeStatus(String accountId, String newStatus, double reset) {
        String sql = "UPDATE bank_accounts SET status = ?, balance = ? WHERE account_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newStatus);
            stmt.setDouble(2, reset);
            stmt.setString(3, accountId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // updation ng balance
    public boolean updateBalance(String accountId, double newBalance) {
        String sql = "UPDATE bank_accounts SET balance = ? WHERE account_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, newBalance);
            stmt.setString(2, accountId);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("BankAccountDAO Error [updateBalance]: " + e.getMessage());
            return false;
        }
    }
    
    // checks if active and existing yung data (used for transfer)
    public boolean accountExistsAndIsActive(String accountId) {
        String sql = "SELECT status FROM bank_accounts WHERE account_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, accountId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String status = rs.getString("status");
                return "Active".equalsIgnoreCase(status);
            }

        } catch (SQLException e) {
            System.out.println("BankAccountDAO Error [accountExistsAndIsActive]: " + e.getMessage());
        }

        return false; // acc isnt active or not existing
    }
    
    public int getTotalAccountsCnt(){
        String sql = "SELECT COUNT(*) AS total FROM bank_accounts";
    
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("total");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
    
    public int getActiveAccountsCnt(String status){
        String sql = "SELECT COUNT(*) AS total FROM bank_accounts WHERE status = ?";
    
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, status);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("total");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
    
    public int getFrozenAccountsCnt(String status){
        String sql = "SELECT COUNT(*) AS total FROM bank_accounts WHERE status = ?";
    
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, status);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("total");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
    
    public int getSuspendedAccountsCnt(String status){
        String sql = "SELECT COUNT(*) AS total FROM bank_accounts WHERE status = ?";
    
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, status);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("total");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public List<BankAccount> getAllAccountsWithCustomerName() {
        List<BankAccount> accounts = new ArrayList<>();

        String sql = "SELECT ba.*, c.first_name, c.last_name " +
                     "FROM bank_accounts ba " +
                     "JOIN customers c ON ba.customer_id = c.customer_id " +
                     "ORDER BY ba.created_at DESC";
        
        BankManage.AppService.Encryption en = new BankManage.AppService.Encryption();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                BankAccount acc = new BankAccount();
                acc.setAccountId(rs.getString("account_id"));
                acc.setCustomerId(rs.getString("customer_id"));
                acc.setAccountType(rs.getString("account_type"));
                acc.setBalance(rs.getDouble("balance"));
                acc.setStatus(rs.getString("status"));
                
                String firstName = en.decrypt(rs.getString("first_name"));
                String lastName = en.decrypt(rs.getString("last_name"));

                if (firstName != null && lastName != null) {
                    String fullName = (firstName + " " + lastName).toUpperCase();
                    acc.setCustomerName(fullName);
                } else {
                    acc.setCustomerName("UNKNOWN CUSTOMER");
                }

                accounts.add(acc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }
    
}