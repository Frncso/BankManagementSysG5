package BankManage.AppService;

import BankManage.DataService.CustomerDataService;
import BankManage.DataService.EmployeeDataService;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {

    private static AtomicInteger customerCounter;
    private static AtomicInteger staffCounter;

    // Call this once when the application starts
    public static void initialize() {
        CustomerDataService customerDataService = new CustomerDataService();
        EmployeeDataService employeeDataService = new EmployeeDataService();

        int lastCustomerSeq = customerDataService.getMaxSequenceForCurrentYear();
        int lastStaffSeq = employeeDataService.getMaxSequenceForCurrentYear();

        customerCounter = new AtomicInteger(lastCustomerSeq + 1);
        staffCounter = new AtomicInteger(lastStaffSeq + 1);

        System.out.println("ID Generator initialized. Next Customer: " + customerCounter.get() +
                           ", Next Staff: " + staffCounter.get());
    }

    public static String generateCustomerId(String firstName, String lastName) {
        if (customerCounter == null) {
            initialize(); // safety
        }
        int year = LocalDate.now().getYear();
        String seq = String.format("%05d", customerCounter.getAndIncrement());
        String initials = (firstName.substring(0, 1) + lastName.substring(0, 1)).toUpperCase();
        return "U" + year + "-" + seq + "-" + initials;
    }

    public static String generateStaffId(String firstName, String lastName) {
        if (staffCounter == null) {
            initialize();
        }
        int year = LocalDate.now().getYear();
        String seq = String.format("%05d", staffCounter.getAndIncrement());
        String initials = (firstName.substring(0, 1) + lastName.substring(0, 1)).toUpperCase();
        return "AU" + year + "-" + seq + "-" + initials;
    }
}