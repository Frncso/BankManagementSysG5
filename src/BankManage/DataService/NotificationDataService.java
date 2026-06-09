package BankManage.DataService;

import BankManage.AccountModels.NotificationModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotificationDataService {

    public boolean createNotification(NotificationModel notification) {
        String sql = "INSERT INTO notifications (customer_id, account_id, message, is_read) " +
                     "VALUES (?, ?, ?, false)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, notification.getCustomerId());
            stmt.setString(2, notification.getAccountId());
            stmt.setString(3, notification.getMessage());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("NotificationDataService Error [createNotification]: " + e.getMessage());
            return false;
        }
    }

    public List<NotificationModel> getUnreadNotifications(String customerId) {
        List<NotificationModel> notifications = new ArrayList<>();
        String sql = "SELECT * FROM notifications WHERE customer_id = ? AND is_read = false ORDER BY created_at DESC";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, customerId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                NotificationModel n = new NotificationModel();
                n.setNotificationId(rs.getInt("notification_id"));
                n.setCustomerId(rs.getString("customer_id"));
                n.setAccountId(rs.getString("account_id"));
                n.setMessage(rs.getString("message"));
                n.setRead(rs.getBoolean("is_read"));
                n.setCreatedAt(rs.getString("created_at"));
                notifications.add(n);
            }
        } catch (SQLException e) {
            System.out.println("NotificationDataService Error [getUnreadNotifications]: " + e.getMessage());
        }
        return notifications;
    }

    public boolean markAllAsRead(String customerId) {
        String sql = "UPDATE notifications SET is_read = true WHERE customer_id = ? AND is_read = false";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, customerId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("NotificationDataService Error [markAllAsRead]: " + e.getMessage());
            return false;
        }
    }
}