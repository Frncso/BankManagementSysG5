package BankManage.AccountModels;
public class EmployeeModel {
    
    private String FName, LName, Address, DOfBirth, SecurityPIN, Pos, IDType, IDNo;
    
    // set
    
    public void setEmployeeFName(String FName){
        this.FName = FName;
    }
    
    public void setEmployeeLName(String LName){
        this.LName = LName;
    }
    
    public void setEmployeeAdd(String Address){
        this.Address = Address;
    }
    
    public void setEmployeeDOfBirth(String DOfBirth){
        this.DOfBirth = DOfBirth;
    }
    
    public void setEmployeeSecPin(String SecurityPIN){
        this.SecurityPIN = SecurityPIN;
    }
    
    public void setEmployeePosition(String Pos){
        this.Pos = Pos;
    }
    
    public void setIDType(String IDType){
        this.IDType = IDType;
    }
    
    public void setIDNo(String IDNo){
        this.IDNo = IDNo;
    }
    
    // get
    
    public String getEmployeeFName(){
        return FName;
    }
    
    public String getEmployeeLName(){
        return LName;
    }
    
    public String getEmployeeAdd(){
        return Address;
    }
    
    public String getEmployeeDOfBirth(){
        return DOfBirth;
    }
    
    public String getEmployeeSecPin(){
        return SecurityPIN;
    }
    
    public String getEmployeePosition(){
        return Pos;
    }
    
    public String getIDType(){
        return IDType;
    }
    
    public String getIDNo(){
        return IDNo;
    }
    
}
