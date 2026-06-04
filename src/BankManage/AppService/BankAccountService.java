package BankManage.AppService;

import BankManage.AccountModels.BankAccount;
import BankManage.AccountModels.CustomerModel;
import BankManage.DataService.BankAccountDataService;
import java.util.List;

public class BankAccountService {
    
    Encryption en = new Encryption();

    private final BankAccountDataService accountDataService = new BankAccountDataService();

    public boolean createDefaultAccounts(CustomerModel customer) {
        try {
            String initials = (en.decrypt(customer.getFirstName().substring(0, 1)).toUpperCase() +
                               en.decrypt(customer.getLastName().substring(0, 1)).toUpperCase());

            // checking acc
            BankAccount checking = new BankAccount();
            checking.setCustomerId(customer.getCustomerId());
            checking.setAccountType("Checking");
            checking.setBalance(0.00);
            checking.setStatus("Active");
            boolean checkingOk = accountDataService.save(checking, initials);

            // savings acc
            BankAccount savings = new BankAccount();
            savings.setCustomerId(customer.getCustomerId());
            savings.setAccountType("Savings");
            savings.setBalance(0.00);
            savings.setStatus("Active");
            boolean savingsOk = accountDataService.save(savings, initials);

            return checkingOk && savingsOk;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<BankAccount> getCustomerAccounts(String customerId) {
        return accountDataService.findByCustomerId(customerId);
    }
}