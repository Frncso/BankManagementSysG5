package BankManage.AccountModels;

public class AccountRequest {

    private String requestId;
    private String customerId;
    private String requestedType;     // checking or savings
    private String description;
    private String requestDate;
    private String status;            // pending, approved, rejected

    public AccountRequest() {}

    public AccountRequest(String requestId, String customerId, String requestedType,
                          String description, String requestDate) {
        this.requestId = requestId;
        this.customerId = customerId;
        this.requestedType = requestedType;
        this.description = description;
        this.requestDate = requestDate;
        this.status = "Pending";
    }

    // get set
    
    public String getRequestId() { return requestId; }
    public void setRequestId(String requestId) { this.requestId = requestId; }
    
    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }
    
    public String getRequestedType() { return requestedType; }
    public void setRequestedType(String requestedType) { this.requestedType = requestedType; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getRequestDate() { return requestDate; }
    public void setRequestDate(String requestDate) { this.requestDate = requestDate; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
}