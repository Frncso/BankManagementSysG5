package BankManage.AppService;

import BankManage.AccountModels.NotificationModel;
import BankManage.DataService.NotificationDataService;
import java.util.List;

public class NotificationService {

    private final NotificationDataService notificationDataService = new NotificationDataService();

    // for status change ng account
    public boolean createStatusChangeNotification(String customerId, String accountId, 
                                                  String oldStatus, String newStatus, String reason) {
        String message = String.format(
            "Your account %s has been set to \"%s\" status due to: %s",
            accountId, newStatus.toLowerCase(), reason
        );

        NotificationModel notification = new NotificationModel(customerId, accountId, message);
        return notificationDataService.createNotification(notification);
    }
    
    // for notification pag processed yung request
    public boolean createRequestProcessedNotification(String customerId, String requestId, 
                                                  String requestType, String status) {

        String message;

        if ("Accepted".equalsIgnoreCase(status)) {
            message = String.format(
                "Your request (%s) has been Accepted. Request ID: %s",
                requestType, requestId
            );
        } else {
            message = String.format(
                "Your request (%s) has been Rejected. Request ID: %s",
                requestType, requestId
            );
        }

        NotificationModel notification = new NotificationModel(customerId, null, message);
        return notificationDataService.createNotification(notification);
    }

    public List<NotificationModel> getUnreadNotifications(String customerId) {
        return notificationDataService.getUnreadNotifications(customerId);
    }

    public void markAllNotificationsAsRead(String customerId) {
        notificationDataService.markAllAsRead(customerId);
    }
}