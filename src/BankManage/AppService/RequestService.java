package BankManage.AppService;

import BankManage.AccountModels.RequestModel;
import BankManage.DataService.RequestDataService;

public class RequestService {

    GetDateAndTime time = new GetDateAndTime();
    private final String timestamp = time.requestTime();
    
    private final RequestDataService requestDataService = new RequestDataService();

    public boolean createRequest(RequestModel request) {
        String requestId = "REQ-" + timestamp;
        request.setRequestId(requestId);

        return requestDataService.save(request);
    }
    
    public int getPenReqCnt(String status){
        String setStatus = status;
        return requestDataService.getPendingRequestCount(setStatus);
    }
}