package BankManage.AccountModels;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {

    private static final AtomicInteger customerCounter = new AtomicInteger(1);
    private static final AtomicInteger staffCounter = new AtomicInteger(1);

    public static String generateCustomerId(String firstName, String lastName) {
        int year = LocalDate.now().getYear();
        String seq = String.format("%05d", customerCounter.getAndIncrement());
        String initials = (firstName.substring(0, 1) + lastName.substring(0, 1)).toUpperCase();
        return "U" + year + "-" + seq + "-" + initials;
    }

    public static String generateStaffId(String firstName, String lastName) {
        int year = LocalDate.now().getYear();
        String seq = String.format("%05d", staffCounter.getAndIncrement());
        String initials = (firstName.substring(0, 1) + lastName.substring(0, 1)).toUpperCase();
        return "AU" + year + "-" + seq + "-" + initials;
    }
}