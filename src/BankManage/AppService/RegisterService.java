package BankManage.AppService;

import BankManage.AccountModels.CustomerModel;
import BankManage.AccountModels.EmployeeModel;
import BankManage.DataService.CustomerDataService;
import BankManage.DataService.EmployeeDataService;

public class RegisterService {

    private final Encryption en = new Encryption();
    private final CustomerDataService customerDataService = new CustomerDataService();
    private final EmployeeDataService employeeDataService = new EmployeeDataService();

    public boolean registerCustomer(CustomerModel customer) {
        try {
            String id = IdGenerator.generateCustomerId(customer.getFirstName(), customer.getLastName());
            customer.setCustomerId(id);

            customer.setFirstName(en.encrypt(customer.getFirstName()));
            customer.setLastName(en.encrypt(customer.getLastName()));
            customer.setPassword(en.encrypt(customer.getPassword()));
            customer.setDateOfBirth(en.encrypt(customer.getDateOfBirth()));
            customer.setIdNumber(en.encrypt(customer.getIdNumber()));

            return customerDataService.save(customer);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean registerEmployee(EmployeeModel employee) {
        try {
            String id = IdGenerator.generateStaffId(employee.getEmployeeFName(), employee.getEmployeeLName());
            employee.setEmployeeId(id);

            employee.setEmployeeFName(en.encrypt(employee.getEmployeeFName()));
            employee.setEmployeeLName(en.encrypt(employee.getEmployeeLName()));
            employee.setEmployeeSecPin(en.encrypt(employee.getEmployeeSecPin()));
            employee.setEmployeeDOfBirth(en.encrypt(employee.getEmployeeDOfBirth()));
            employee.setAccessCode(employee.getAccessCode());

            return employeeDataService.save(employee);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}