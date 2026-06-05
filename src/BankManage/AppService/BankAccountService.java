package BankManage.AppService;

import BankManage.AccountModels.BankAccount;
import BankManage.AccountModels.CustomerModel;
import BankManage.DataService.BankAccountDataService;
import BankManage.DataService.CustomerDataService;
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
    
    public boolean createNewAccount(String customerId, String accountType) {
        try {

            CustomerDataService customerDataService = new CustomerDataService();
            CustomerModel customer = customerDataService.findByCredentials(customerId);

            String initials = "XX";
            if (customer != null) {
                String first = en.decrypt(customer.getFirstName()) != null ? en.decrypt(customer.getFirstName()) : "";
                String last = en.decrypt(customer.getLastName()) != null ? en.decrypt(customer.getLastName()) : "";
                initials = (first.length() > 0 ? first.substring(0, 1) : "X") +
                           (last.length() > 0 ? last.substring(0, 1) : "X");
                initials = initials.toUpperCase();
            }

            BankAccount newAccount = new BankAccount();
            newAccount.setCustomerId(customerId);
            newAccount.setAccountType(accountType);
            newAccount.setBalance(0.00);
            newAccount.setStatus("Active");

            return accountDataService.save(newAccount, initials);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateAccountStatus(String accountId, String newStatus) {
        return accountDataService.updateStatus(accountId, newStatus);
    }

    public List<BankAccount> getAllAccountsWithCustomerName() {
        return accountDataService.getAllAccountsWithCustomerName();
    }
    
    public int getTotalCnt(){
        return accountDataService.getTotalAccountsCnt();
    }
    
    public int getActiveCnt(String status){
        String setStatus = status;
        return accountDataService.getActiveAccountsCnt(setStatus);
    }
    
    public int getFrozenCnt(String status){
        String setStatus = status;
        return accountDataService.getFrozenAccountsCnt(setStatus);
    }
    
    public int getSuspendedCnt(String status){
        String setStatus = status;
        return accountDataService.getSuspendedAccountsCnt(setStatus);
    }
    
}