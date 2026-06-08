package BankManage.DataService;

import BankManage.AccountModels.TransactionModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDataService {

    // get all transactions

    public List<TransactionModel> getTransactionsByAccountId(String accountId) {
        List<TransactionModel> list = new ArrayList<>();
        String sql = "SELECT * FROM transactinfo_tbl WHERE Account_ID = ? ORDER BY Date DESC";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, accountId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(mapResultSetToTransaction(rs));
            }
        } catch (SQLException e) {
            System.out.println("TransactionDataService Error [getTransactionsByAccountId]: " + e.getMessage());
        }
        return list;
    }

    public List<TransactionModel> getAllTransactions() {
        List<TransactionModel> list = new ArrayList<>();
        String sql = "SELECT * FROM transactinfo_tbl ORDER BY Date DESC";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(mapResultSetToTransaction(rs));
            }
        } catch (SQLException e) {
            System.out.println("TransactionDataService Error [getAllTransactions]: " + e.getMessage());
        }
        return list;
    }

    // insert transactions

    public boolean insertTransaction(TransactionModel t) {
        String sql = "INSERT INTO transactinfo_tbl (transact_id, Account_ID, Account_Type, Firstname, " +
                     "Purchase_Name, Date, Amount, Status, flagged, fromAccount, toAccount) " +
                     "VALUES ('TEMP', ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, t.getAccountId());
            ps.setString(2, t.getAccountType());
            ps.setString(3, t.getCustomerName());
            ps.setString(4, t.getPurchaseName());
            ps.setString(5, t.getDate());
            ps.setDouble(6, t.getAmount());
            ps.setString(7, t.getStatus() != null ? t.getStatus() : "Pending");
            ps.setBoolean(8, t.isFlagged());
            ps.setString(9, t.getFromAccount());
            ps.setString(10, t.getToAccount());

            int rows = ps.executeUpdate();
            if (rows == 0) return false;

            // generation of id
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    int generatedId = keys.getInt(1);
                    String newTransactId = "TXN-" + String.format("%06d", generatedId);
                    t.setTransactionId(newTransactId);
                    t.setT_ID(generatedId);

                    String updateSql = "UPDATE transactinfo_tbl SET transact_id = ? WHERE t_id = ?";
                    try (PreparedStatement updatePs = conn.prepareStatement(updateSql)) {
                        updatePs.setString(1, newTransactId);
                        updatePs.setInt(2, generatedId);
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

    // method updating ng statuses and flags

    public boolean updateTransactionStatus(String transactId, String newStatus) {
        String sql = "UPDATE transactinfo_tbl SET Status = ? WHERE transact_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newStatus);
            ps.setString(2, transactId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("TransactionDataService Error [updateTransactionStatus]: " + e.getMessage());
            return false;
        }
    }

    public boolean updateTransactionFlagged(String transactId, boolean isFlagged) {
        String sql = "UPDATE transactinfo_tbl SET flagged = ? WHERE transact_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setBoolean(1, isFlagged);
            ps.setString(2, transactId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("TransactionDataService Error [updateTransactionFlagged]: " + e.getMessage());
            return false;
        }
    }

    private TransactionModel mapResultSetToTransaction(ResultSet rs) throws SQLException {
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
        t.setFlagged(rs.getBoolean("flagged"));
        t.setFromAccount(rs.getString("fromAccount"));
        t.setToAccount(rs.getString("toAccount"));
        return t;
    }
}