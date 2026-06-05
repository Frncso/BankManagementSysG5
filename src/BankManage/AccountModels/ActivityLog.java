package BankManage.AccountModels;

public class ActivityLog {

    private int logId;
    private String requestId;      // req table
    private String customerId;     // cus table
    private String accountId;      // bank accs table
    private String action;         // accepted rejected closed frozen suspended etc etc
    private String performedBy;    // fname of staff/admin
    private String timestamp;      // created_at from database

    public ActivityLog() {}

    public ActivityLog(String requestId, String customerId, String accountId, String action, String performedBy) {
        this.requestId = requestId;
        this.customerId = customerId;
        this.accountId = accountId;
        this.action = action;
        this.performedBy = performedBy;
    }

    // get set
    public int getLogId() { return logId; }
    public void setLogId(int logId) { this.logId = logId; }

    public String getRequestId() { return requestId; }
    public void setRequestId(String requestId) { this.requestId = requestId; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getAccountId() { return accountId; }
    public void setAccountId(String accountId) { this.accountId = accountId; }

    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }

    public String getPerformedBy() { return performedBy; }
    public void setPerformedBy(String performedBy) { this.performedBy = performedBy; }

    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
}