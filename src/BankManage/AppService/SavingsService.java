package BankManage.AppService;
 
import BankManage.AccountModels.savingsModels;
import BankManage.DataService.SavingsDataService;
import java.util.ArrayList;
import java.util.List;
 
public class SavingsService {
 
    private final SavingsDataService savingsDataService = new SavingsDataService();
 
    // validates inputs and delegates saving to the repository
    public boolean createSavingsGoal(String title, String amountText, String userId) {
        if (title == null || title.isBlank()) {
            return false;
        }
 
        double amount;
        try {
            amount = Double.parseDouble(amountText);
        } catch (NumberFormatException e) {
            return false;
        }
 
        if (amount <= 0) {
            return false;
        }
 
        // build model and pass to data layer
        savingsModels goal = new savingsModels();
        goal.setTargetTitle(title);
        goal.settargetAmnt(amount);
        goal.setgoalStatus("In Progress");
        goal.setgoalUserId(userId);
 
        return savingsDataService.insertSavingsGoal(goal);
    }
 
    // validation helpers used by the UI layer
    public boolean isTitleValid(String title) {
        return title != null && !title.isBlank();
    }
 
    public boolean isAmountValid(String amountText) {
        try {
            double value = Double.parseDouble(amountText);
            return value > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
 
    // marks a savings goal as complete
    public boolean completeGoal(int gsavingsId, String userId) {
        return savingsDataService.updateGoalStatus(gsavingsId, "Completed", userId);
    }
 
    // removes a savings goal permanently
    public boolean removeGoal(int gsavingsId, String userId) {
        return savingsDataService.deleteGoal(gsavingsId, userId);
    }
 
    // retrieves all goals and delegates to data layer
    public List<savingsModels> getAllGoals(String userId) {
        return savingsDataService.getAllGoals(userId);
    }
 
    // calculates percentage of target amount relative to current balance
    public double calculatePercentage(double targetAmnt, double currentBalance) {
        if (currentBalance <= 0) {
            return 0;
        }
 
        double percentage = (currentBalance / targetAmnt) * 100;
 
        // cap at 100% so it doesnt overflow
        if (percentage > 100) {
            return 100;
        }
 
        return Math.round(percentage * 10.0) / 10.0;
    }
 
    // formats percentage as a readable string
    public String formatPercentage(double percentage) {
        if (percentage == 100) {
            return "100%";
        }
        return percentage + "%";
    }
    
    // get all completed goals para ipasa sa data layer
    public List<savingsModels> getCompletedGoals(String userId) {
        return savingsDataService.getCompletedGoals(userId);
    }
    
    // get count ng completed
    public int getCompletedGoalsCount(String customerId) {
        return savingsDataService.getCompletedGoalsCount(customerId);
    }
    
}
