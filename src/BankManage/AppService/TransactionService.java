package BankManage.AppService;

import BankManage.AccountModels.BankAccount;
import BankManage.AccountModels.CustomerModel;
import BankManage.AccountModels.TransactionModel;
import BankManage.DataService.CustomerDataService;
import BankManage.DataService.TransactionDataService;
import java.util.ArrayList;
import java.util.List;

public class TransactionService {

    private final TransactionDataService tds = new TransactionDataService();

    public static final String FILTER_ALL = "All";
    public static final String FILTER_COMPLETED = "Completed";
    public static final String FILTER_DECLINED = "Declined";
    public static final String FILTER_SUSPENDED = "Suspended";
    public static final String FILTER_FROZEN = "Frozen";
    public static final String FILTER_POSITIVE = "Positive (+)";
    public static final String FILTER_NEGATIVE = "Negative (-)";
    public static final String FILTER_FLAGGED = "Flagged";

    // get methods (all and by accoundid)
    public List<TransactionModel> getTransactions(String accountId) {
        return tds.getTransactionsByAccountId(accountId);
    }

    public List<TransactionModel> getAllTransactions() {
        return tds.getAllTransactions();
    }

    public TransactionModel getTransactionById(String transactId) {
        List<TransactionModel> all = tds.getAllTransactions();
        for (TransactionModel t : all) {
            if (t.getTransactionId() != null && t.getTransactionId().equalsIgnoreCase(transactId)) {
                return t;
            }
        }
        return null;
    }

    // filtering functions
    public List<TransactionModel> filterTransactions(List<TransactionModel> transactions, String filter) {
        List<TransactionModel> filtered = new ArrayList<>();
        if (transactions == null) return filtered;

        for (TransactionModel t : transactions) {
            switch (filter) {
                case FILTER_ALL:
                    filtered.add(t);
                    break;
                case FILTER_COMPLETED:
                    if ("Completed".equalsIgnoreCase(t.getStatus())) filtered.add(t);
                    break;
                case FILTER_DECLINED:
                    if ("Declined".equalsIgnoreCase(t.getStatus())) filtered.add(t);
                    break;
                case FILTER_SUSPENDED:
                    if ("Suspended".equalsIgnoreCase(t.getStatus())) filtered.add(t);
                    break;
                case FILTER_FROZEN:
                    if ("Frozen".equalsIgnoreCase(t.getStatus())) filtered.add(t);
                    break;
                case FILTER_POSITIVE:
                    if (t.getAmount() > 0) filtered.add(t);
                    break;
                case FILTER_NEGATIVE:
                    if (t.getAmount() < 0) filtered.add(t);
                    break;
                case FILTER_FLAGGED:
                    if (t.isFlagged()) filtered.add(t);
                    break;
                default:
                    filtered.add(t);
            }
        }
        return filtered;
    }

    // formatting ng table for admin
    public String[][] toTableData(List<TransactionModel> transactions) {
        if (transactions == null) return new String[0][9];
        String[][] data = new String[transactions.size()][9];

        for (int i = 0; i < transactions.size(); i++) {
            TransactionModel t = transactions.get(i);
            data[i][0] = t.getTransactionId();
            data[i][1] = t.getAccountId();
            data[i][2] = t.getAccountType();
            data[i][3] = t.getCustomerName();
            data[i][4] = t.getPurchaseName();
            data[i][5] = t.getDate();
            data[i][6] = formatAmount(t.getAmount());
            data[i][7] = t.getStatus();
            data[i][8] = t.isFlagged() ? "YES" : "NO";
        }
        return data;
    }
    
        // for customer UI
    public String[][] toCustomerTableData(List<TransactionModel> transactions) {
        if (transactions == null) return new String[0][6];

        String[][] data = new String[transactions.size()][7];

        for (int i = 0; i < transactions.size(); i++) {
            TransactionModel t = transactions.get(i);

            data[i][0] = t.getTransactionId();
            data[i][1] = t.getPurchaseName();
            data[i][2] = (t.getToAccount() != null && !t.getToAccount().isEmpty()) 
                            ? t.getToAccount() 
                            : t.getPurchaseName();           
            data[i][3] = t.getDate();
            data[i][4] = t.getStatus();
            data[i][5] = formatAmount(t.getAmount());
            data[i][6] = t.getAccountType();
        }
        return data;
    }

    public String formatAmount(double amount) {
        if (amount >= 0) {
            return String.format("+₱%,.2f", amount);
        } else {
            return String.format("-₱%,.2f", Math.abs(amount));
        }
    }

    // stats
    public double getTotalDeposits(List<TransactionModel> transactions) {
        if (transactions == null) return 0;
        return transactions.stream().filter(t -> t.getAmount() > 0).mapToDouble(TransactionModel::getAmount).sum();
    }

    public double getTotalWithdrawals(List<TransactionModel> transactions) {
        if (transactions == null) return 0;
        return transactions.stream().filter(t -> t.getAmount() < 0).mapToDouble(TransactionModel::getAmount).sum();
    }

    public double getRecentActivity(List<TransactionModel> transactions) {
        if (transactions == null || transactions.isEmpty()) return 0;
        return transactions.get(0).getAmount();
    }

    // post, get, update
    public boolean recordTransaction(TransactionModel t) {
        if (t == null || t.getAmount() == 0 || t.getAccountId() == null || t.getAccountId().isEmpty()) {
            return false;
        }
        return tds.insertTransaction(t);
    }

    public boolean updateStatus(String transactId, String newStatus) {
        return tds.updateTransactionStatus(transactId, newStatus);
    }

    public boolean flagTransaction(String transactId, boolean isFlagged) {
        return tds.updateTransactionFlagged(transactId, isFlagged);
    }
    
    // getter ng from and to (sender receiver)
    
    public boolean recordDeposit(String accountId, String accountType, String customerName, double amount, String date) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than 0.");
            return false;
        }

        TransactionModel t = new TransactionModel();
        t.setAccountId(accountId);
        t.setAccountType(accountType);
        t.setCustomerName(customerName);
        t.setPurchaseName("Deposit");
        t.setDate(date);
        t.setAmount(amount);
        t.setStatus("Completed");
        t.setFlagged(false);
        t.setFromAccount("External Deposit");   
        t.setToAccount(accountId);

        return tds.insertTransaction(t);
    }
    
    public boolean recordWithdraw(String accountId, String accountType, String customerName, double amount, String date) {
        if (amount <= 0) {
            System.out.println("Withdraw amount must be greater than 0.");
            return false;
        }

        TransactionModel t = new TransactionModel();
        t.setAccountId(accountId);
        t.setAccountType(accountType);
        t.setCustomerName(customerName);
        t.setPurchaseName("Withdrawal");
        t.setDate(date);
        t.setAmount(-Math.abs(amount)); 
        t.setStatus("Completed");
        t.setFlagged(false);
        t.setFromAccount(accountId);
        t.setToAccount("External Withdrawal");

        return tds.insertTransaction(t);
    }
    
    // recording withdraw accross transactions (hinahanap din destination account)
    public boolean recordTransfer(String fromAccountId, String toAccountId,
                              String accountType, String customerName,
                              double amount, String date, String description) {

        if (amount <= 0) {
            System.out.println("Transfer amount must be greater than 0.");
            return false;
        }

        // negative amount (since transfer)
        TransactionModel senderTx = new TransactionModel();
        senderTx.setAccountId(fromAccountId);
        senderTx.setAccountType(accountType);
        senderTx.setCustomerName(customerName);
        senderTx.setPurchaseName("Transfer Out");
        senderTx.setDate(date);
        senderTx.setAmount(-Math.abs(amount));
        senderTx.setStatus("Completed");
        senderTx.setFlagged(false);
        senderTx.setFromAccount(fromAccountId);
        senderTx.setToAccount(toAccountId);

        boolean senderRecorded = tds.insertTransaction(senderTx);

        if (!senderRecorded) {
            return false;
        }

        // record transaction for the receiver if meron (checker senderRecorded)
        BankAccountService accountService = new BankAccountService();
        CustomerDataService customerDataService = new CustomerDataService();
        BankAccount toAccount = accountService.getAccountById(toAccountId);
        
        if (toAccount != null) {
            String userId = customerDataService.getFirstNameByCustomerId(toAccount.getCustomerId());
            
            TransactionModel receiverTx = new TransactionModel();
            receiverTx.setAccountId(toAccountId);
            receiverTx.setAccountType(toAccount.getAccountType());
            receiverTx.setCustomerName(userId);
            receiverTx.setPurchaseName("Transfer In");
            receiverTx.setDate(date);
            receiverTx.setAmount(Math.abs(amount));
            receiverTx.setStatus("Completed");
            receiverTx.setFlagged(false);
            receiverTx.setFromAccount(fromAccountId);
            receiverTx.setToAccount(toAccountId);

            tds.insertTransaction(receiverTx);
        }

        return true;
    }
}