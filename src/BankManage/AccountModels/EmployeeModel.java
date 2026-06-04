package BankManage.AccountModels;

public class EmployeeModel {
    private String employeeId;
    private String employeeFName;
    private String employeeLName;       
    private String employeeSecPin;     // pass
    private String employeeDOfBirth; // siguro concat lang dito mm/dd/yyyy
    private String employeePosition;
    private String accessCode;

    public EmployeeModel() {}

    public EmployeeModel(String employeeId, String employeeFName, String employeeLName, String employeeSecPin,
                         String employeeDOfBirth, String employeePosition, String accessCode) {
        this.employeeId = employeeId;
        this.employeeFName = employeeFName;
        this.employeeLName = employeeLName;
        this.employeeSecPin = employeeSecPin;
        this.employeeDOfBirth = employeeDOfBirth;
        this.employeePosition = employeePosition;
        this.accessCode = accessCode;

    }

    // get set
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getEmployeeFName() { return employeeFName; }
    public void setEmployeeFName(String employeeFName) { this.employeeFName = employeeFName; }

    public String getEmployeeLName() { return employeeLName; }
    public void setEmployeeLName(String employeeLName) { this.employeeLName = employeeLName; }

    public String getEmployeeSecPin() { return employeeSecPin; }
    public void setEmployeeSecPin(String employeeSecPin) { this.employeeSecPin = employeeSecPin; }
    
    public String getEmployeeDOfBirth() { return employeeDOfBirth; }
    public void setEmployeeDOfBirth(String employeeDOfBirth) { this.employeeDOfBirth = employeeDOfBirth; }

    public String getEmployeePosition() { return employeePosition; }
    public void setEmployeePosition(String employeePosition) { this.employeePosition = employeePosition; }
    
    public String getAccessCode() { return accessCode; }
    public void setAccessCode(String accessCode) { this.accessCode = accessCode; }

}