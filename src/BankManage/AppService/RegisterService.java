package BankManage.AppService;

import BankManage.AccountModels.*;
import java.util.ArrayList;
import java.util.List;

public class RegisterService {

    private final Encryption en = new Encryption();

    // in-memory muna before sql implementation
    private static final List<CustomerModel> customerList = new ArrayList<>();
    private static final List<EmployeeModel> employeeList = new ArrayList<>();

    // cus reg
    public boolean addCustomer(CustomerModel newCustomer) {
        try {
            // gagawa ng id (generated)
            String generatedId = IdGenerator.generateCustomerId(newCustomer.getFirstName(), newCustomer.getLastName());
            newCustomer.setCustomerId(generatedId);

            // encrypting fields, papalitan ko yung pass to hash
            newCustomer.setFirstName(en.encrypt(newCustomer.getFirstName()));
            newCustomer.setLastName(en.encrypt(newCustomer.getLastName()));
            newCustomer.setPassword(en.encrypt(newCustomer.getPassword()));
            newCustomer.setDateOfBirth(en.encrypt(newCustomer.getDateOfBirth()));
            newCustomer.setIdNumber(en.encrypt(newCustomer.getIdNumber()));

            // store in mem
            customerList.add(newCustomer);

            // debug
            
            System.out.println("Registered!");
            System.out.println("ID: " + newCustomer.getCustomerId());
            System.out.println("Name: " + newCustomer.getFirstName() + " " + newCustomer.getLastName());
            System.out.println("DOB (encrypted): " + newCustomer.getDateOfBirth());
            System.out.println("Password (encrypted): " + newCustomer.getPassword());

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // staff reg
    public boolean addEmployee(EmployeeModel newEmployee) {
        try {
            // gagawa ng id (generated)
            String generatedId = IdGenerator.generateStaffId(newEmployee.getEmployeeFName(), newEmployee.getEmployeeLName());
            newEmployee.setEmployeeId(generatedId);

            // encrypting fields, papalitan ko yung pass to hash
            newEmployee.setEmployeeFName(en.encrypt(newEmployee.getEmployeeFName()));
            newEmployee.setEmployeeLName(en.encrypt(newEmployee.getEmployeeLName()));
            newEmployee.setEmployeeAdd(en.encrypt(newEmployee.getEmployeeAdd()));
            newEmployee.setEmployeeDOfBirth(en.encrypt(newEmployee.getEmployeeDOfBirth()));
            newEmployee.setEmployeeSecPin(en.encrypt(newEmployee.getEmployeeSecPin()));
            newEmployee.setIDNo(en.encrypt(newEmployee.getIDNo()));

            // store in mem
            employeeList.add(newEmployee);

            System.out.println("Registered!");
            System.out.println("ID: " + newEmployee.getEmployeeId());
            System.out.println("Name: " + newEmployee.getEmployeeFName() + " " + newEmployee.getEmployeeLName());
            System.out.println("Position: " + newEmployee.getEmployeePosition());
            System.out.println("Password (encrypted): " + newEmployee.getEmployeeSecPin());

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // get all customer tas employee testing pang debug
    public List<CustomerModel> getAllCustomers() {
        return new ArrayList<>(customerList);
    }

    public List<EmployeeModel> getAllEmployees() {
        return new ArrayList<>(employeeList);
    }

    public void printAllRegisteredUsers() {
        System.out.println("\nCustomer Count: (" + customerList.size() + ")");
        for (CustomerModel c : customerList) {
            System.out.println(c.getCustomerId() + " | " + c.getFirstName() + " " + c.getLastName());
        }

        System.out.println("\nStaff Count: (" + employeeList.size() + ")");
        for (EmployeeModel e : employeeList) {
            System.out.println(e.getEmployeeId() + " | " + e.getEmployeeFName() + " " + e.getEmployeeLName() 
                               + " | Position: " + e.getEmployeePosition());
        }
    }

    // clearing staffs
    public void clearAllData() {
        customerList.clear();
        employeeList.clear();
        System.out.println("All in-memory data cleared.");
    }
}