package BankManage.AppService;

import BankManage.AccountModels.CustomerModel;
import BankManage.AccountModels.EmployeeModel;
import BankManage.DataService.CustomerDataService;
import BankManage.DataService.EmployeeDataService;

public class LoginService {

    private final Encryption en = new Encryption();
    private final CustomerDataService customerDataService = new CustomerDataService();
    private final EmployeeDataService employeeDataService = new EmployeeDataService();

    public CustomerModel loginCustomer(String customerID, String password) {
        String encryptedPass = en.encrypt(password);
        CustomerModel customer = customerDataService.findByCredentials(customerID);
        if (customer != null && customer.getPassword().equals(encryptedPass)) {
            return customer;
        }
        return null;
    }

    public EmployeeModel loginStaff(String staffID, String password) {
        String encryptedPass = en.encrypt(password);
        EmployeeModel staff = employeeDataService.findByCredentials(staffID);
        if (staff != null && staff.getEmployeeSecPin().equals(encryptedPass)) {
            return staff;
        }
        return null;
    }
}