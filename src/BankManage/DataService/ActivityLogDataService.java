package BankManage.DataService;

import BankManage.AccountModels.ActivityLog;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityLogDataService {

    public boolean logAction(ActivityLog log) {
        String sql = "INSERT INTO activity_logs (request_id, customer_id, account_id, action, performed_by) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, log.getRequestId());
            stmt.setString(2, log.getCustomerId());
            stmt.setString(3, log.getAccountId());
            stmt.setString(4, log.getAction());
            stmt.setString(5, log.getPerformedBy());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<ActivityLog> getRecentActivities(int limit) {
        List<ActivityLog> logs = new ArrayList<>();

        String sql = "SELECT * FROM activity_logs ORDER BY created_at DESC LIMIT ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, limit);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ActivityLog log = new ActivityLog();
                log.setLogId(rs.getInt("log_id"));
                log.setRequestId(rs.getString("request_id"));
                log.setCustomerId(rs.getString("customer_id"));
                log.setAccountId(rs.getString("account_id"));
                log.setAction(rs.getString("action"));
                log.setPerformedBy(rs.getString("performed_by"));
                log.setTimestamp(rs.getString("created_at"));

                logs.add(log);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return logs;
    }
}