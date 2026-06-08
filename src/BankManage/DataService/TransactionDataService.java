package BankManage.DataService;
 
import BankManage.AccountModels.TransactionModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
 
public class TransactionDataService {
 
    // fetch all transactions by account id
 
    public List<TransactionModel> getTransactionsByAccountId(String accountId) {
        List<TransactionModel> transactionList = new ArrayList<>();
 
        String query = "SELECT t_id, transact_id, Account_ID, Account_Type, Firstname, " +
                       "Purchase_Name, Date, Amount, Status " +
                       "FROM transactinfo_tbl WHERE Account_ID = ? ORDER BY Date DESC";
 
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
 
            ps.setString(1, accountId);
            ResultSet rs = ps.executeQuery();
 
            while (rs.next()) {
                TransactionModel t = new TransactionModel();
 
                t.setT_ID(rs.getInt("t_id"));
                t.setTransactionId(rs.getString("transact_id"));
                t.setAccountId(rs.getString("Account_ID"));
                t.setAccountType(rs.getString("Account_Type"));
                t.setCustomerName(rs.getString("Firstname"));
                t.setPurchaseName(rs.getString("Purchase_Name"));
                t.setDate(rs.getString("Date"));
                t.setAmount(rs.getDouble("Amount"));
                t.setStatus(rs.getString("Status"));
 
                transactionList.add(t);
            }
 
        } catch (SQLException e) {
            System.out.println("TransactionDataService Error [getTransactionsByAccountId]: " + e.getMessage());
        }
 
        return transactionList;
    }
 
    // fetch all transactions (admin use)
 
    public List<TransactionModel> getAllTransactions() {
        List<TransactionModel> transactionList = new ArrayList<>();
 
        String query = "SELECT t_id, transact_id, Account_ID, Account_Type, Firstname, " +
                       "Purchase_Name, Date, Amount, Status " +
                       "FROM transactinfo_tbl ORDER BY Date DESC";
 
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
 
            ResultSet rs = ps.executeQuery();
 
            while (rs.next()) {
                TransactionModel t = new TransactionModel();
 
                t.setT_ID(rs.getInt("t_id"));
                t.setTransactionId(rs.getString("transact_id"));
                t.setAccountId(rs.getString("Account_ID"));
                t.setAccountType(rs.getString("Account_Type"));
                t.setCustomerName(rs.getString("Firstname"));
                t.setPurchaseName(rs.getString("Purchase_Name"));
                t.setDate(rs.getString("Date"));
                t.setAmount(rs.getDouble("Amount"));
                t.setStatus(rs.getString("Status"));
 
                transactionList.add(t);
            }
 
        } catch (SQLException e) {
            System.out.println("TransactionDataService Error [getAllTransactions]: " + e.getMessage());
        }
 
        return transactionList;
    }
 
    // insert a new transaction record
    // auto-generates transact_id based on the new t_id from auto_increment
 
    public boolean insertTransaction(TransactionModel t) {
        String query = "INSERT INTO transactinfo_tbl " +
                       "(transact_id, Account_ID, Account_Type, Firstname, Purchase_Name, Date, Amount, Status) " +
                       "VALUES ('TEMP', ?, ?, ?, ?, ?, ?, ?)";
 
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
 
            ps.setString(1, t.getAccountId());
            ps.setString(2, t.getAccountType());
            ps.setString(3, t.getCustomerName());
            ps.setString(4, t.getPurchaseName());
            ps.setString(5, t.getDate());
            ps.setDouble(6, t.getAmount());
            ps.setString(7, t.getStatus());
 
            int rows = ps.executeUpdate();
 
            if (rows == 0) {
                return false;
            }
 
            // gen transact_id from the auto_increment t_id
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedTId = generatedKeys.getInt(1);
 
                    // format: TXN-000001, padded to 6 digits
                    String transactId = "TXN-" + String.format("%06d", generatedTId);
                    t.setTransactionId(transactId);
                    t.setT_ID(generatedTId);
 
                    // update the row with the generated transact_id
                    String updateQuery = "UPDATE transactinfo_tbl SET transact_id = ? WHERE t_id = ?";
                    try (PreparedStatement updatePs = conn.prepareStatement(updateQuery)) {
                        updatePs.setString(1, transactId);
                        updatePs.setInt(2, generatedTId);
                        updatePs.executeUpdate();
                    }
                }
            }
 
            return true;
 
        } catch (SQLException e) {
            System.out.println("TransactionDataService Error [insertTransaction]: " + e.getMessage());
            return false;
        }
    }
 
    // update status of a transaction by transact_id
 
    public boolean updateTransactionStatus(String transactId, String newStatus) {
        String query = "UPDATE transactinfo_tbl SET Status = ? WHERE transact_id = ?";
 
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
 
            ps.setString(1, newStatus);
            ps.setString(2, transactId);
 
            int rows = ps.executeUpdate();
            return rows > 0;
 
        } catch (SQLException e) {
            System.out.println("TransactionDataService Error [updateTransactionStatus]: " + e.getMessage());
            return false;
        }
    }
 
    // generate a transact_id based on the current max t_id
    // format: TXN-000001, increments with each new record
    // use this for preview/display before inserting — insertTransaction generates it automatically
 
    public String generateTransactionId() {
        String query = "SELECT MAX(t_id) FROM transactinfo_tbl";
 
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
 
            ResultSet rs = ps.executeQuery();
 
            if (rs.next()) {
                int maxId = rs.getInt(1); // returns 0 if no records yet
                int nextId = maxId + 1;
                return "TXN-" + String.format("%06d", nextId);
            }
 
        } catch (SQLException e) {
            System.out.println("TransactionDataService Error [generateTransactionId]: " + e.getMessage());
        }
 
        // fallback if query fails
        return "TXN-000001";
    }
}