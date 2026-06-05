package BankManage.AppService;

import BankManage.AccountModels.ActivityLog;
import BankManage.DataService.ActivityLogDataService;
import java.util.List;

public class ActivityLogService {

    private final ActivityLogDataService activityLogDataService = new ActivityLogDataService();

    public boolean logActivity(String requestId, String customerId, String accountId, String action, String performedBy) {
        
        ActivityLog log = new ActivityLog();
        log.setRequestId(requestId);
        log.setCustomerId(customerId);
        log.setAccountId(accountId);
        log.setAction(action);
        log.setPerformedBy(performedBy);

        return activityLogDataService.logAction(log);
    }
    
    public List<ActivityLog> getRecentActivities(int limit) {
        return activityLogDataService.getRecentActivities(limit);
    }   
}