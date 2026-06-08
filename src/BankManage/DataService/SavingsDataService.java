package BankManage.DataService;

import BankManage.AccountModels.savingsModels;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SavingsDataService {
 
    // inserts a new savings goal record into the savings table
    public boolean insertSavingsGoal(savingsModels goal) {
        String query = "INSERT INTO savings (target_title, target_amnt, goal_status) VALUES (?, ?, ?)";
 
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
 
            stmt.setString(1, goal.getTargetTitle());
            stmt.setDouble(2, goal.gettargetAmnt());
            stmt.setString(3, goal.getgoalStatus());
 
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
 
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // updates the goal_status of a specific savings goal
    public boolean updateGoalStatus(int gsavingsId, String newStatus) {
        String query = "UPDATE savings SET goal_status = ? WHERE gsavings_id = ?";
 
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
 
            stmt.setString(1, newStatus);
            stmt.setInt(2, gsavingsId);
 
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
 
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
 
    // deletes a savings goal record from the savings table
    public boolean deleteGoal(int gsavingsId) {
        String query = "DELETE FROM savings WHERE gsavings_id = ?";
 
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
 
            stmt.setInt(1, gsavingsId);
 
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
 
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
 
       // kinukuha lahat ng "In Progress" na goals para sa view goals
    public List<savingsModels> getAllGoals() {
        List<savingsModels> goals = new ArrayList<>();
        String query = "SELECT gsavings_id, target_title, target_amnt, goal_status FROM savings WHERE goal_status = 'In Progress'";
 
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
 
            while (rs.next()) {
                savingsModels goal = new savingsModels();
                goal.setgsavingsId(rs.getInt("gsavings_id"));
                goal.setTargetTitle(rs.getString("target_title"));
                goal.settargetAmnt(rs.getDouble("target_amnt"));
                goal.setgoalStatus(rs.getString("goal_status"));
                goals.add(goal);
            }
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return goals;
    }
 
    // kinukuha lahat ng "Completed" na goals para sa achieved goals
    public List<savingsModels> getCompletedGoals() {
        List<savingsModels> goals = new ArrayList<>();
        String query = "SELECT gsavings_id, target_title, target_amnt, goal_status FROM savings WHERE goal_status = 'Completed'";
 
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
 
            while (rs.next()) {
                savingsModels goal = new savingsModels();
                goal.setgsavingsId(rs.getInt("gsavings_id"));
                goal.setTargetTitle(rs.getString("target_title"));
                goal.settargetAmnt(rs.getDouble("target_amnt"));
                goal.setgoalStatus(rs.getString("goal_status"));
                goals.add(goal);
            }
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return goals;
    }
}
