package BankManage.AppService;

import BankManage.AccountModels.CustomerModel;
import BankManage.AccountModels.EmployeeModel;

public class SessionManage {

    private static CustomerModel currentCustomer = null;
    private static EmployeeModel currentStaff = null;

    // login
    public static void loginCustomer(CustomerModel customer) {
        currentCustomer = customer;
        currentStaff = null; // clearing staff field
        System.out.println("Session started for Customer: " + customer.getFirstName()); // debug
    }

    public static void loginStaff(EmployeeModel staff) {
        currentStaff = staff;
        currentCustomer = null; // clearing user field
        System.out.println("Session started for Staff: " + staff.getEmployeeFName()); // debug
    }

    // gathering the current user
    public static CustomerModel getCurrentCustomer() {
        return currentCustomer;
    }

    public static EmployeeModel getCurrentStaff() {
        return currentStaff;
    }

    public static boolean isCustomerLoggedIn() {
        return currentCustomer != null;
    }

    public static boolean isStaffLoggedIn() {
        return currentStaff != null;
    }

    public static boolean isLoggedIn() {
        return currentCustomer != null || currentStaff != null;
    }

    public static String getCurrentUserType() {
        if (currentCustomer != null) return "Customer";
        if (currentStaff != null) return "Staff";
        return "None";
    }

    // logging out
    public static void logout() {
        currentCustomer = null;
        currentStaff = null;
        resetProcessedCount();
        System.out.println("User logged out. Session cleared."); /// debug
    }

    // getting name for display
    public static String getCurrentUserDisplayName() {
        if (currentCustomer != null) {
            return currentCustomer.getFirstName();
        } else if (currentStaff != null) {
            return currentStaff.getEmployeeFName();
        }
        return "Guest";
    }
    
    // processed counter ni staff
    private static int processedCount = 0;

    public static void incrementProcessedCount() {
        processedCount++;
    }

    public static int getProcessedCount() {
        return processedCount;
    }

    public static void resetProcessedCount() {
        processedCount = 0;
    }
    
}