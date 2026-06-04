package BankManage.AccountModels;

public class RequestModel {

    private int r_id;
    private String requestId;        // REQ-TIMESTAMP smth
    private String accountNumber;    // ACC-00001-EF
    private String customerId;       // U2026-00001-JD
    private String accountType;      // checking / Savings
    private String requestType;      // close Account, open new acc
    private String purpose;
    private String status = "Pending";         // pending by default, approved, rejected
    private String timestamp;

    public RequestModel() {    }

    public RequestModel(String accountNumber, String customerId, String accountType,
                   String requestType, String purpose, String status) {
        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.accountType = accountType;
        this.requestType = requestType;
        this.purpose = purpose;
        this.status = status;
    }

    // get set GOOOOO
    public int getR_id() { return r_id; }
    public void setR_id(int r_id) { this.r_id = r_id; }

    public String getRequestId() { return requestId; }
    public void setRequestId(String requestId) { this.requestId = requestId; }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }

    public String getRequestType() { return requestType; }
    public void setRequestType(String requestType) { this.requestType = requestType; }

    public String getPurpose() { return purpose; }
    public void setPurpose(String purpose) { this.purpose = purpose; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
    
}