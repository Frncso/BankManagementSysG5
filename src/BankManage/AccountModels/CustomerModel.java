package BankManage.AccountModels;
import java.util.ArrayList;
import java.util.List;

public class CustomerModel {

    private String customerId;        // customer-00001 ++
    private String firstName;
    private String lastName;
    private String password;
    private String dateOfBirth;       // broken down to separate
    private String occupation;
    private String incomeRange;
    private String idType;
    private String idNumber;
    private boolean isActive = true;

    private List<BankAccount> accounts = new ArrayList<>();

    // construct
    public CustomerModel() {}

    public CustomerModel(String customerId, String firstName, String lastName, String password,
                    String dateOfBirth, String occupation, String incomeRange,
                    String idType, String idNumber) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.occupation = occupation;
        this.incomeRange = incomeRange;
        this.idType = idType;
        this.idNumber = idNumber;
    }

    // get and set
    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getOccupation() { return occupation; }
    public void setOccupation(String occupation) { this.occupation = occupation; }

    public String getIncomeRange() { return incomeRange; }
    public void setIncomeRange(String incomeRange) { this.incomeRange = incomeRange; }

    public String getIdType() { return idType; }
    public void setIdType(String idType) { this.idType = idType; }

    public String getIdNumber() { return idNumber; }
    public void setIdNumber(String idNumber) { this.idNumber = idNumber; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }

    public List<BankAccount> getAccounts() { return accounts; }
    public void addAccount(BankAccount account) { this.accounts.add(account); }

}