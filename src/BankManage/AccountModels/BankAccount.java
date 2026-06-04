package BankManage.AccountModels;

public class BankAccount {

    private int a_id;
    private String accountId;       // acc-00001-AA
    private String customerId;      // U2026-00001-AA <- customer id foreign key dito
    private String accountType;     // checking or saving
    private double balance;
    private String status;          // active frozen suspended closed

    public BankAccount() {}

    public BankAccount(String accountId, String customerId, String accountType, double balance, String status) {
        this.accountId = accountId;
        this.customerId = customerId;
        this.accountType = accountType;
        this.balance = balance;
        this.status = status;
    }

    // get set GOOOO
    public int getA_id() { return a_id; }
    public void setA_id(int a_id) { this.a_id = a_id; }

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

    @Override
    public String toString() {
        return accountType + " (" + accountId + ") - ₱" + balance + " [" + status + "]";
    }
}