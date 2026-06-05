package BankManage.AccountModels;

public class OneTimeCode {

    private int otcId;
    private String employeeId;     
    private String accessCode;     // 8char code, like 95BV210
    private String status;         // used or unused
    private String createdAt;

    public OneTimeCode() {}

    public OneTimeCode(String accessCode) {
        this.accessCode = accessCode;
        this.status = "Unused";
    }

    public int getOtcId() { return otcId; }
    public void setOtcId(int otcId) { this.otcId = otcId; }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getAccessCode() { return accessCode; }
    public void setAccessCode(String accessCode) { this.accessCode = accessCode; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
}