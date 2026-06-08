package BankManage.AccountModels;
 
public class TransactionModel {
    
    private int t_id;
    private String transactionId;
    private String accountId;
    private String accountType;     // acc type
    private String customerName;
    private String purchaseName;
    private String date;
    private double amount;
    private String status;          // pending, completed, declined
    private boolean flagged;
    private String fromAccount;
    private String toAccount;
    
    public TransactionModel() {}
    
    public TransactionModel(int t_id, String transactionId, String accountId, String accountType,
                            String customerName, String purchaseName, String description,
                            String date, double amount, String status, boolean flagged) {
        this.t_id = t_id;
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.accountType = accountType;
        this.customerName = customerName;
        this.purchaseName = purchaseName;
        this.date = date;
        this.amount = amount;
        this.status = status;
        this.flagged = flagged;
    }
    
    public int getT_ID() { return t_id; }
    public void setT_ID(int t_id) { this.t_id = t_id; }
    
    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }
    
    public String getAccountId() { return accountId; }
    public void setAccountId(String accountId) { this.accountId = accountId; }
    
    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }
    
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    
    public String getPurchaseName() { return purchaseName; }
    public void setPurchaseName(String purchaseName) { this.purchaseName = purchaseName; }
    
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public boolean isFlagged() { return flagged; }
    public void setFlagged(boolean flagged) { this.flagged = flagged; }
    
    public String getFromAccount() { return fromAccount; }
    public void setFromAccount(String fromAccount) { this.fromAccount = fromAccount; }

    public String getToAccount() { return toAccount; }
    public void setToAccount(String toAccount) { this.toAccount = toAccount; }
}
 