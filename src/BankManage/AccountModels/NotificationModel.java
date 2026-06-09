package BankManage.AccountModels;

public class NotificationModel {
    private int notificationId;
    private String customerId;
    private String accountId;
    private String message;
    private boolean isRead;
    private String createdAt;

    public NotificationModel() {}

    public NotificationModel(String customerId, String accountId, String message) {
        this.customerId = customerId;
        this.accountId = accountId;
        this.message = message;
        this.isRead = false;
    }

    public int getNotificationId() { return notificationId; }
    public void setNotificationId(int notificationId) { this.notificationId = notificationId; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getAccountId() { return accountId; }
    public void setAccountId(String accountId) { this.accountId = accountId; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public boolean isRead() { return isRead; }
    public void setRead(boolean read) { isRead = read; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
}