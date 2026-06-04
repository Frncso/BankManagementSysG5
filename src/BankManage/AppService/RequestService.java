package BankManage.AppService;

import BankManage.AccountModels.RequestModel;
import BankManage.DataService.RequestDataService;

public class RequestService {

    GetDateAndTime time = new GetDateAndTime();
    private final String timestamp = time.requestTime();
    
    private final RequestDataService requestDAO = new RequestDataService();

    public boolean createRequest(RequestModel request) {
        String requestId = "REQ-" + timestamp;
        request.setRequestId(requestId);

        return requestDAO.save(request);
    }
}