package BankManage.AccountModels;

public class EmployeeModel {
    private String employeeId;
    private String employeeFName;
    private String employeeLName;
    private String employeeAdd;        // address
    private String employeeDOfBirth; // siguro concat lang dito mm/dd/yyyy
    private String employeeSecPin;     // pass
    private String employeePosition;
    private String IDType;
    private String IDNo;

    public EmployeeModel() {}

    public EmployeeModel(String employeeId, String employeeFName, String employeeLName,
                         String employeeAdd, String employeeDOfBirth, String employeeSecPin,
                         String employeePosition, String IDType, String IDNo) {
        this.employeeId = employeeId;
        this.employeeFName = employeeFName;
        this.employeeLName = employeeLName;
        this.employeeAdd = employeeAdd;
        this.employeeDOfBirth = employeeDOfBirth;
        this.employeeSecPin = employeeSecPin;
        this.employeePosition = employeePosition;
        this.IDType = IDType;
        this.IDNo = IDNo;
    }

    // ==================== GETTERS & SETTERS ====================
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getEmployeeFName() { return employeeFName; }
    public void setEmployeeFName(String employeeFName) { this.employeeFName = employeeFName; }

    public String getEmployeeLName() { return employeeLName; }
    public void setEmployeeLName(String employeeLName) { this.employeeLName = employeeLName; }

    public String getEmployeeAdd() { return employeeAdd; }
    public void setEmployeeAdd(String employeeAdd) { this.employeeAdd = employeeAdd; }

    public String getEmployeeDOfBirth() { return employeeDOfBirth; }
    public void setEmployeeDOfBirth(String employeeDOfBirth) { this.employeeDOfBirth = employeeDOfBirth; }

    public String getEmployeeSecPin() { return employeeSecPin; }
    public void setEmployeeSecPin(String employeeSecPin) { this.employeeSecPin = employeeSecPin; }

    public String getEmployeePosition() { return employeePosition; }
    public void setEmployeePosition(String employeePosition) { this.employeePosition = employeePosition; }

    public String getIDType() { return IDType; }
    public void setIDType(String IDType) { this.IDType = IDType; }

    public String getIDNo() { return IDNo; }
    public void setIDNo(String IDNo) { this.IDNo = IDNo; }
}