package BankManage.AppService;
 
import BankManage.AccountModels.TransactionModel;
import BankManage.DataService.TransactionDataService;
import java.util.ArrayList;
import java.util.List;
 
public class TransactionService {
    
    TransactionDataService tds = new TransactionDataService();
    
    // filter options
    
    public static final String FILTER_ALL       = "All";
    public static final String FILTER_COMPLETED = "Completed";
    public static final String FILTER_DECLINED  = "Declined";
    public static final String FILTER_SUSPENDED = "Suspended";
    public static final String FILTER_FROZEN    = "Frozen";
    public static final String FILTER_POSITIVE  = "Positive (+)";
    public static final String FILTER_NEGATIVE  = "Negative (-)";
    
    // get all transactions for a given account id
    
    public List<TransactionModel> getTransactions(String accountId) {
        return tds.getTransactionsByAccountId(accountId);
    }
    
    // filter transactions by status or amount direction
    
    public List<TransactionModel> filterTransactions(List<TransactionModel> transactions, String filter) {
        List<TransactionModel> filtered = new ArrayList<>();
        
        for (TransactionModel t : transactions) {
            switch (filter) {
                case FILTER_ALL:
                    filtered.add(t);
                    break;
                case FILTER_COMPLETED:
                    if (t.getStatus().equalsIgnoreCase("Completed")) filtered.add(t);
                    break;
                case FILTER_DECLINED:
                    if (t.getStatus().equalsIgnoreCase("Declined")) filtered.add(t);
                    break;
                case FILTER_SUSPENDED:
                    if (t.getStatus().equalsIgnoreCase("Suspended")) filtered.add(t);
                    break;
                case FILTER_FROZEN:
                    if (t.getStatus().equalsIgnoreCase("Frozen")) filtered.add(t);
                    break;
                case FILTER_POSITIVE:
                    if (t.getAmount() > 0) filtered.add(t);
                    break;
                case FILTER_NEGATIVE:
                    if (t.getAmount() < 0) filtered.add(t);
                    break;
                default:
                    filtered.add(t);
                    break;
            }
        }
        
        return filtered;
    }
    
    // convert transaction list to table-ready 2D array
    
    public String[][] toTableData(List<TransactionModel> transactions) {
        String[][] data = new String[transactions.size()][6];
        
        for (int i = 0; i < transactions.size(); i++) {
            TransactionModel t = transactions.get(i);
            
            data[i][0] = t.getTransactionId();                  // transaction info (transact_id)
            data[i][1] = t.getPurchaseName();                   // name
            data[i][2] = t.getDate();                           // date
            data[i][3] = t.getStatus();                         // status
            data[i][4] = formatAmount(t.getAmount());           // amount
            data[i][5] = t.getAccountType();                    // account type
        }
        
        return data;
    }
    
    // format amount with peso sign and +/- prefix
    
    public String formatAmount(double amount) {
        if (amount >= 0) {
            return String.format("+₱%,.2f", amount);
        } else {
            return String.format("-₱%,.2f", Math.abs(amount));
        }
    }
    
    // compute total deposits (positive amounts)
    
    public double getTotalDeposits(List<TransactionModel> transactions) {
        double total = 0;
        for (TransactionModel t : transactions) {
            if (t.getAmount() > 0) total += t.getAmount();
        }
        return total;
    }
    
    // compute total withdrawals (negative amounts)
    
    public double getTotalWithdrawals(List<TransactionModel> transactions) {
        double total = 0;
        for (TransactionModel t : transactions) {
            if (t.getAmount() < 0) total += t.getAmount();
        }
        return total;
    }
    
    // get most recent transaction amount for display
    
    public double getRecentActivity(List<TransactionModel> transactions) {
        if (transactions.isEmpty()) return 0;
        return transactions.get(0).getAmount();
    }
    
    // record a new transaction
    
    public boolean recordTransaction(TransactionModel t) {
        if (t.getAmount() == 0) {
            System.out.println("TransactionService Warning: Amount cannot be zero.");
            return false;
        }
        if (t.getAccountId() == null || t.getAccountId().isEmpty()) {
            System.out.println("TransactionService Warning: Account ID is missing.");
            return false;
        }
        return tds.insertTransaction(t);
    }
    
    // update a transaction status
    
    public boolean updateStatus(String transactId, String newStatus) {
        return tds.updateTransactionStatus(transactId, newStatus);
    }
}
