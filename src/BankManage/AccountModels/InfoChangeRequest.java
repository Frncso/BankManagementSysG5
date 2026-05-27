package BankManage.AccountModels;

public class InfoChangeRequest {

    private String requestId;
    private String customerId;
    private String fieldToChange;     // "firstName", "occupation", etc.
    private String newValue;
    private String requestDate;
    private String status;            // pen, approve, decline

    public InfoChangeRequest() {}

    public InfoChangeRequest(String requestId, String customerId, String fieldToChange,
                             String newValue, String requestDate) {
        this.requestId = requestId;
        this.customerId = customerId;
        this.fieldToChange = fieldToChange;
        this.newValue = newValue;
        this.requestDate = requestDate;
        this.status = "Pending";
    }

    // get set
    
    public String getRequestId() { return requestId; }
    public void setRequestId(String requestId) { this.requestId = requestId; }
    
    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }
    
    public String getFieldToChange() { return fieldToChange; }
    public void setFieldToChange(String fieldToChange) { this.fieldToChange = fieldToChange; }
    
    public String getNewValue() { return newValue; }
    public void setNewValue(String newValue) { this.newValue = newValue; }
    
    public String getRequestDate() { return requestDate; }
    public void setRequestDate(String requestDate) { this.requestDate = requestDate; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}