package BankManage.AccountModels;

public class TransactionModel {

    private String transactionId;
    private String accountId;
    private String customerName;
    private String description;      // transfer from juan
    private String date;
    private double amount;
    private String status;           // pending, completed, declined

    public TransactionModel() {}

    public TransactionModel(String transactionId, String accountId, String customerName,
                       String description, String date, double amount) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.customerName = customerName;
        this.description = description;
        this.date = date;
        this.amount = amount;
        this.status = "Pending";
    }

    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }
    
    public String getAccountId() { return accountId; }
    public void setAccountId(String accountId) { this.accountId = accountId; }
    
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

}