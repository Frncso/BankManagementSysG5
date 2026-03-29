package BankManage.AppService;
import BankManage.AccountModels.*;

public class RegisterService{
    
    Encryption en = new Encryption();
    
    public boolean AddEmployee(EmployeeModel newEmployee){
        
        // no validation yet
        
        // if existing return false;
        
        // if not, encrypt
        
        String encryptedFName = en.encrypt(newEmployee.getEmployeeFName());
        String encryptedLName = en.encrypt(newEmployee.getEmployeeLName());
        String encryptedAdd = en.encrypt(newEmployee.getEmployeeAdd());
        String encryptedDOfBirth = en.encrypt(newEmployee.getEmployeeDOfBirth());
        String encryptedSecPin = en.encrypt(newEmployee.getEmployeeSecPin());
        String encryptedPosition = en.encrypt(newEmployee.getEmployeePosition());
        String encryptedIDType = en.encrypt(newEmployee.getIDType());
        String encryptedIDNo = en.encrypt(newEmployee.getIDNo());
        
        EmployeeModel encrypted = new EmployeeModel();
        encrypted.setEmployeeFName(encryptedFName);
        encrypted.setEmployeeLName(encryptedLName);
        encrypted.setEmployeeAdd(encryptedAdd);
        encrypted.setEmployeeDOfBirth(encryptedDOfBirth);
        encrypted.setEmployeeSecPin(encryptedSecPin);
        encrypted.setEmployeePosition(encryptedPosition);
        encrypted.setIDType(encryptedIDType);
        encrypted.setIDNo(encryptedIDNo);
        
        return true;
    }
    
}
