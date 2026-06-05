package BankManage.DataService;

import BankManage.AccountModels.OneTimeCode;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OneTimeCodeDataService {

    public boolean generateAccessCode(String accessCode) {
        String sql = "INSERT INTO one_time_codes (access_code, status) VALUES (?, 'Unused')";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, accessCode);
            return stmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isValidAccessCode(String accessCode) {
        String sql = "SELECT * FROM one_time_codes WHERE access_code = ? AND status = 'Unused'";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, accessCode);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean useAccessCode(String employeeId, String accessCode){
        String sql = "UPDATE one_time_codes SET status = 'Used', employee_id = ? WHERE access_code = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, employeeId);
            stmt.setString(2, accessCode);
            System.out.println("Employee: "+employeeId + "\nAccess Code:" + accessCode);
            return stmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<OneTimeCode> getAllCodes() {
        List<OneTimeCode> codes = new ArrayList<>();
        String sql = "SELECT * FROM one_time_codes ORDER BY created_at DESC";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                OneTimeCode code = new OneTimeCode();
                code.setEmployeeId(rs.getString("employee_id"));
                code.setAccessCode(rs.getString("access_code"));
                code.setStatus(rs.getString("status"));
                code.setCreatedAt(rs.getString("created_at"));
                codes.add(code);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return codes;
    }
}