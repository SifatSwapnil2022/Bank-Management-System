import java.util.Scanner;

public class Account extends Person { //account class extends person class

	//variables
    private String accountPin;
    private String accountId;
    private String accountName;
    private int accountBalance;
    private boolean accountInfo;
    private boolean accountManager;
    private Manager manager;

    //constructor with parameter
    public Account(String accountName, String accountId, String accountPin, int accountBalance) {
        this.accountPin = accountPin;
        this.accountId = accountId;
        this.accountName = accountName;
        this.accountBalance = accountBalance;
    }

    
    //get set methods
    public String getAccountPin() {
        return accountPin;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public boolean getaccountInfo() {
        return accountInfo;
    }

    public boolean getAccountManager() {
        return accountManager;
    }

    public void setAccountBalance(int balance) {
        this.accountBalance = balance;
    }

    public void setaccountInfo(boolean accountInfo) {
        this.accountInfo = accountInfo;
    }

    public void setManager(String managerId) {
        Manager[] manager = new Manager[99]; //array
        Scanner inputAccountId = new Scanner(System.in);
        manager[0] = new Manager();
        manager[0].setManager(managerId); //need manager id
        manager[0].setHaveManager(true); //if there is any manager id , then it will be true
        manager[0].setAccount(accountId, accountPin); //a manager needs Id and pin for account
        this.accountManager = true;
        System.out.println("Manager ID: " + manager[0].getManagerId());
    }

    public void getManagerInformation() {
        System.out.println("Manager ID: " + manager.getManagerId());
        System.out.println("Manager Password: " + manager.getManagerPassword());
        System.out.println("Have Manager: " + manager.getHaveManager());
    }

}
