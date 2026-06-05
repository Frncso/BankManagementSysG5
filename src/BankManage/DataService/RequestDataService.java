package BankManage.DataService;

import BankManage.AccountModels.RequestModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequestDataService {

    public boolean save(RequestModel request) {
        String sql = "INSERT INTO requests (request_id, account_number, customer_id, account_type, request_type, purpose, status) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, request.getRequestId());
            stmt.setString(2, request.getAccountNumber());
            stmt.setString(3, request.getCustomerId());
            stmt.setString(4, request.getAccountType());
            stmt.setString(5, request.getRequestType());
            stmt.setString(6, request.getPurpose());
            stmt.setString(7, request.getStatus());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<RequestModel> getProcessedRequests() {
    List<RequestModel> requests = new ArrayList<>();
    
    String sql = "SELECT r.*, c.first_name, c.last_name " +
                 "FROM requests r " +
                 "JOIN customers c ON r.customer_id = c.customer_id " +
                 "WHERE r.status IN ('Accepted', 'Rejected') " +
                 "ORDER BY r.created_at DESC";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                RequestModel r = mapResultSetToRequest(rs);
                requests.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requests;
    }

    public List<RequestModel> getAllRequestsByStatus(String status) {
    List<RequestModel> list = new ArrayList<>();
    
    String sql = "SELECT * FROM requests WHERE status = ? " +
                 "ORDER BY created_at DESC";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
         
        stmt.setString(1, status);  
        
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                RequestModel r = new RequestModel();
                r.setRequestId(rs.getString("request_id"));
                r.setCustomerId(rs.getString("customer_id"));
                r.setAccountNumber(rs.getString("account_number"));
                r.setRequestType(rs.getString("request_type"));
                r.setAccountType(rs.getString("account_type"));
                r.setStatus(rs.getString("status"));
                r.setTimestamp(rs.getString("created_at"));
                list.add(r);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
        return list;
    }
    
    public RequestModel findByReqID(String reqID) { // finding specific request by request_id
        String sql = "SELECT * FROM requests WHERE request_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, reqID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                RequestModel request = new RequestModel();

                request.setRequestId(rs.getString("request_id"));
                request.setAccountNumber(rs.getString("account_number"));
                request.setCustomerId(rs.getString("customer_id"));
                request.setAccountType(rs.getString("account_type"));
                request.setRequestType(rs.getString("request_type"));
                request.setPurpose(rs.getString("purpose"));
                request.setStatus(rs.getString("status"));
                request.setTimestamp(rs.getString("created_at"));

                return request;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
    
    private RequestModel mapResultSetToRequest(ResultSet rs) throws SQLException {
        RequestModel r = new RequestModel();
        r.setRequestId(rs.getString("request_id"));
        r.setAccountNumber(rs.getString("account_number"));
        r.setCustomerId(rs.getString("customer_id"));
        r.setAccountType(rs.getString("account_type"));
        r.setRequestType(rs.getString("request_type"));
        r.setPurpose(rs.getString("purpose"));
        r.setStatus(rs.getString("status"));
        r.setTimestamp(rs.getString("created_at"));

        return r;
    }
    
    public boolean updateRequestStatus(String requestId, String newStatus) { // update yung request status lang
        String sql = "UPDATE requests SET status = ? WHERE request_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newStatus);
            stmt.setString(2, requestId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public int getPendingRequestCount(String status){
        String sql = "SELECT COUNT(*) AS total FROM requests WHERE status = ?";
    
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, status);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("total");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
    
}