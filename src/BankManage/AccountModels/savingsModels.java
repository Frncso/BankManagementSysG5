package BankManage.AccountModels;

public class savingsModels {
    
    private int gsavingsId;
    private String targetTitle;
    private double targetAmnt;
    private String goalStatus;
    private String goalUserId;
    
    public savingsModels(){}
    
    public savingsModels(int gsavingsId, String targetTitle, double targetAmnt, String goalStatus, String goalUserId){
        this.gsavingsId = gsavingsId;
        this.targetTitle = targetTitle;
        this.targetAmnt = targetAmnt;
        this.goalStatus = goalStatus;
        this.goalUserId = goalUserId;
    }
    
    public int getgsavingsId(){return gsavingsId;}
    public void setgsavingsId(int gsavingsId){this.gsavingsId = gsavingsId;}
    
    public String getTargetTitle(){return targetTitle;}
    public void setTargetTitle(String targetTitle){this.targetTitle = targetTitle;}
    
    public String getgoalStatus(){return goalStatus;}
    public void setgoalStatus(String goalStatus){this.goalStatus = goalStatus;}
    
    public double gettargetAmnt(){return targetAmnt;}
    public void settargetAmnt(double targetAmnt){this.targetAmnt = targetAmnt;}
    
    public String getgoalUserId(){return goalUserId;}
    public void setgoalUserId(String goalUserId){this.goalUserId = goalUserId;}
    
}
