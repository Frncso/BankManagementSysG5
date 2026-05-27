package BankManage.AccountModels;

public class BankAccount {

    private String accountId;       // acc-00001 increments blah
    private String customerId;
    private String accountType;     // checking or saving
    private double balance;
    private String status;          // active, frozen, suspended, closed

    public BankAccount() {}

    public BankAccount(String accountId, String customerId, String accountType, double initialBalance) {
        this.accountId = accountId;
        this.customerId = customerId;
        this.accountType = accountType;
        this.balance = initialBalance;
        this.status = "Active";
    }

    // get set
    public String getAccountId() { return accountId; }
    public void setAccountId(String accountId) { this.accountId = accountId; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

}