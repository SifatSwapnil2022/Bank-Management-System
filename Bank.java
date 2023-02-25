import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Bank {
	// Scanner object which is defined globally from a static method
	static Scanner inputChoice = new Scanner(System.in);
	static Scanner inputAccountName = new Scanner(System.in);
	static Scanner inputAccountId = new Scanner(System.in);
	static Scanner inputAccountPin = new Scanner(System.in);
	static Scanner inputAccountBalance = new Scanner(System.in);
	static Scanner inputAccountLimit = new Scanner(System.in);
	static Scanner inputAccountWithdraw = new Scanner(System.in);
	static int accountCount = 0;

	static Account[] account = new Account[9999]; // ARRAY

	public static void main(String[] args) {
		boolean wrong = false;

		while (!wrong) {
			Captcha c = new Captcha();
			String genaratedCaptcha = c.getcaptchaValue();
			System.out.println(" ####### Verify that you are not a robot ....................");

			System.out.println("\n\nCaptcha :" + genaratedCaptcha);
			Scanner input = new Scanner(System.in);
			System.out.print("Please ,  verify the captcha :");

			String verification = input.nextLine();// nextLine() consumes newline character

			if (genaratedCaptcha.equals(verification)) {
				System.out.println("Verified : Welcome, you can enter the Bank Management System.............");
				welcomeMenu();
			} else {
				System.out.println("Invalid captcha, please try again Sir !!!!");
				wrong = false;
				break;

			}
		}

	}

	public static void welcomeMenu() {
		boolean end = false;
		System.out.println("************ Welcome to the Online EWU BANK. *************");
		while (end == false) {
			try {
				System.out.println("\n Type 1 - Create Account");
				System.out.println(" Type 2 - Exit");
				System.out.print("\nChoice: ");
				int choice = inputChoice.nextInt();
				switch (choice) {
				case 1:
					System.out.print("\nCreate Account.");
					manageAccount();
					end = true;
					break;
				case 2:
					System.out.println("\nExit.");
					end = true;
					break;
				default:
					System.out.println("\nInvalid Choice.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nError" + e);
			}
		}
	}

	public static void LoginMenu(int accountCount) {
		boolean end = false;
		System.out.println("***************************************************");
		System.out.println("************ Welcome to Online the EWU BANK *************");
		while (end == false) {
			try {
				System.out.println("\n Type 1 - Create Account");
				System.out.println(" Type 2 - Login");
				System.out.println(" Type 3 - Set Manager");
				System.out.println(" Type 4 - Get Info Manager");
				System.out.println(" Type 5 - Exit");
				System.out.print("\nChoice: ");
				int choice = inputChoice.nextInt();// user choice
				switch (choice) {
				case 1:
					System.out.print("\nCreate Account.");
					createAccount(accountCount);
					end = true;
					break;
				case 2:
					System.out.println("\nLogin.");
					LoginSystem(accountCount);
					end = true;
					break;
				case 3:
					System.out.println("\nSet Manager.");
					setManager(accountCount);
					end = true;
					break;
				case 4:
					System.out.println("\nGet Manager.");
					getManagerInfo(accountCount);
					end = true;
					break;
				case 5:
					System.out.println("\nExit.");
					end = true;
					System.exit(0);
					break;

				default:
					System.out.println("\nInvalid Choice.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nError" + e);
			}

		}
	}

	public static void LoginSystem(int accountCount) {
		int choice = 0;
		boolean holderAccount = true;
		while (holderAccount == true) {
			boolean holderMenu = true;
			System.out.println("\n ########## Login Menu ##########");
			System.out.print("\n Enter your account ID: ");
			String accountLoginId = inputAccountId.nextLine(); // user give their id no
			System.out.print(" Enter your account pin: ");
			String accountLoginPin = inputAccountPin.nextLine(); // user give their pin no
			System.out.println("\n #################################");
			for (int k = 0; k < accountCount; k++) {
				if (accountLoginId.equals(((Account) account[k]).getAccountId())) { // checking if the account match
																					// with id
					if (accountLoginPin.equals(((Account) account[k]).getAccountPin())) {// checking if the account
																							// match with pin
						System.out.println("\n **** Login Success!");
						System.out.println(" **** Account Name: " + ((Account) account[k]).getAccountName()
								+ " Account ID: " + ((Account) account[k]).getAccountId() + " Account Pin: "
								+ ((Account) account[k]).getAccountPin() + " Account Balance: "
								+ ((Account) account[k]).getAccountBalance());
						while (holderMenu == true) {
							System.out.println("****************** ACCOUNT MENU ******************");
							System.out.println("Welcome : " + ((Account) account[k]).getAccountName());
							System.out.println(" Type 1 - Check Balance");
							System.out.println(" Type 2 - Withdraw");
							System.out.println(" Type 3 - Deposit");
							System.out.println(" Type 4 - Transfer");
							System.out.println(" Type 5 - Change account");
							if (((Account) account[k]).getaccountInfo() == true) { // if there is account info
								System.out.println(" Type 6 - Check account information");
							} else {
								System.out.println(" Type 6 - Register account information");
							}
							System.out.println(" Type 7 - Exit");
							System.out.print("Choice: ");
							choice = inputChoice.nextInt();
							switch (choice) {
							case 1:
								System.out.println(
										"\n === Your Balance is " + ((Account) account[k]).getAccountBalance());
								break;
							case 2:
								System.out.println("\n Withdraw.");
								withdraw(k);
								break;
							case 3:
								System.out.println("\n Deposit.");
								deposit(k);
								break;
							case 4:
								System.out.println("\n Transfer.");
								Transferable(k);
								break;
							case 5:
								System.out.println("\n Change account.");
								holderAccount = true;
								holderMenu = false;
								LoginMenu(accountCount); // back to log in menu
								break;
							case 6:
								if (((Account) account[k]).getaccountInfo() == true) {
									System.out.println(" Type 5 - Check account information");
									getAccountInfo(k);
									break;
								} else {
									System.out.println(" Type 5 - Register account information");
									setAccountInfo(k);
									break;
								}
							case 7:
								System.out.println("\n Exit.");
								holderAccount = false;
								holderMenu = false;
								System.exit(0);
								break;
							default:
								System.out.println("\n Invalid Choice.");
							}
						}
					} else {

						System.out.println("\n!!! Invalid Password !!!");
					}

				} else {

				}
			}
		}
	}

	public static void manageAccount() {

		boolean holderAccount = true;
		System.out.print("\n Enter amount of all account: ");
		int accountLimit = inputAccountLimit.nextInt();

		try {
			for (int i = 0; i < accountLimit; i++) {
				System.out.print("\n No." + (i + 1) + " Account");
				System.out.print("\n Enter your account name: ");
				String accountName = inputAccountName.nextLine();
				System.out.print(" Enter your account ID: ");
				String accountId = inputAccountId.nextLine();
				System.out.print(" Enter your account pin: ");
				String accountPin = inputAccountPin.nextLine();
				System.out.print(" Enter your account balance: ");
				int accountBalance = inputAccountBalance.nextInt();
				if (accountName.trim().isEmpty() || accountId.trim().isEmpty()) {
					// The trim() method removes any (starting) and (ending) white spaces from the
					// specified string.
					// checks whether a string is empty or not

					System.out.println("Please enter all information.");
					i--;
					continue;
				}
				if (accountName.trim().length() > 50 || accountId.trim().length() > 13) {
					System.out.println("too many characters.");
					i--;
					continue;
				}
				if (i == 0) {
					account[i] = new Account(accountName, accountId, accountPin, accountBalance);
					accountCount++;
				} else {
					for (int j = 0; j < accountCount; j++) {
						if (account[j].getAccountId().equals(accountId)) {
							System.out.println("Account ID already exists.");
							i--;
							break;
						} else if (j == accountCount - 1) {
							account[i] = new Account(accountName, accountId, accountPin, accountBalance);
							accountCount++;
							break;
						}
					}
				}

			}
			System.out.println("****************************************************");

			for (int j = 0; j < accountLimit; j++) {
				int no = j + 1;
				System.out.println("\nNo." + no);
				System.out.println("Account ID = " + ((Account) account[j]).getAccountId());
				System.out.println("Account Name = " + ((Account) account[j]).getAccountName());
				System.out.println("Account Pin = " + ((Account) account[j]).getAccountPin());
				System.out.println("Account Balance = " + ((Account) account[j]).getAccountBalance());
			}

		} catch (InputMismatchException e) {
			System.out.println("\nError " + e + " Please try again");
		}

		LoginMenu(accountLimit);

	}

	public static void createAccount(int accountCount) {

		System.out.print("\n Enter amount of all account: ");
		int accountLimit = inputAccountLimit.nextInt();
		int accountCreateStart = accountCount;
		accountLimit = accountLimit + accountCount;

		try {
			for (int i = accountCount; i <= accountLimit - 1; i++) {
				System.out.print("\n No." + (i + 1) + " Account");
				System.out.print("\n Enter your account name: ");
				String accountName = inputAccountName.nextLine();
				System.out.print(" Enter your account ID: ");
				String accountId = inputAccountId.nextLine();
				System.out.print(" Enter your account pin: ");
				String accountPin = inputAccountPin.nextLine();
				System.out.print(" Enter your account balance: ");
				int accountBalance = inputAccountBalance.nextInt();
				if (accountName.trim().isEmpty() || accountId.trim().isEmpty()) {
					System.out.println("Please enter all information.");
					i--;
					continue;
				}
				if (accountName.trim().length() > 50 || accountId.trim().length() > 13) {
					System.out.println("too many characters.");
					i--;
					continue;
				}
				if (i == 0) {
					account[i] = new Account(accountName, accountId, accountPin, accountBalance);
					accountCount++;
				} else {
					for (int j = 0; j < accountCount; j++) {
						if (account[j].getAccountId().equals(accountId)) {
							System.out.println("Account ID already exists.");
							i--;
							break;
						} else if (j == accountCount - 1) {
							account[i] = new Account(accountName, accountId, accountPin, accountBalance);
							accountCount++;
							break;
						}
					}
				}
			}
			System.out.println("**************************************************");

			for (int j = 0; j < accountCount; j++) {
				int no = j + 1;
				System.out.println("\nNo." + no);
				System.out.println("Account ID = " + ((Account) account[j]).getAccountId());
				System.out.println("Account Name = " + ((Account) account[j]).getAccountName());
				System.out.println("Account Pin = " + ((Account) account[j]).getAccountPin());
				System.out.println("Account Balance = " + ((Account) account[j]).getAccountBalance());
			}
			if (accountCount == accountLimit) {
				LoginMenu(accountCount);
			}
		} catch (InputMismatchException e) {
			System.out.println("\nError " + e + " Please try again");
		}
	}

	public static void setAccountInfo(int accountId) { // argument account id

		try {
			File myObj = new File("D:\\Java cse110 project\\BANKING\\New1Accountinfo.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		try {
			FileWriter fwrite = new FileWriter("D:\\Java cse110 project\\BANKING\\New1Accountinfo.txt");
			Scanner inputFirstName = new Scanner(System.in);
			Scanner inputLastName = new Scanner(System.in);
			Scanner inputIdCard = new Scanner(System.in);
			Scanner inputGender = new Scanner(System.in);
			Scanner inputPhoneNumber = new Scanner(System.in);
			Scanner inputAddress = new Scanner(System.in);
			Scanner inputEmail = new Scanner(System.in);
			Scanner inputPreviousWithdraw = new Scanner(System.in);
			Scanner inputPreviousTransfer = new Scanner(System.in);
			Scanner inputPreviousDeposit = new Scanner(System.in);
			
			
			System.out.print("\n Enter your first name: ");
			String fisrtName = inputFirstName.nextLine();
			fwrite.write("\nFirst name: " + fisrtName);

			System.out.print("\n Enter your last name: ");
			String lastName = inputLastName.nextLine();
			fwrite.write("\nLast name: " + lastName);

			System.out.print("\n Enter your idcard: ");
			String idCard = inputIdCard.nextLine();
			fwrite.write("\nId card: " + idCard);

			System.out.print("\n Enter your gender: ");
			String gender = inputGender.nextLine();
			fwrite.write("\nGender: " + gender);

			System.out.println("\nEnter your Phone number :");
			String phoneNumber = inputPhoneNumber.nextLine();
			fwrite.write("\nPhone number: " + phoneNumber);

			System.out.println("\nEnter your address:");
			String address = inputAddress.nextLine();
			fwrite.write("\nAddress: " + address);

			System.out.println("\nEnter your email address:");
			String email = inputEmail.nextLine();
			fwrite.write("\nEmail no: " + email);
			
			
			System.out.println("\nEnter your previous withdraw if you did:");
			String previousWithdraw = inputPreviousWithdraw.nextLine();
			fwrite.write("\nWithdraw: " + previousWithdraw);
			
			System.out.println("\nEnter your previous deposit if you did :");
			String previousDeposit = inputPreviousDeposit.nextLine();
			fwrite.write("\nDeposit: " +previousDeposit );
			
			System.out.println("\nEnter your previous Transfer if you did:");
			String previousTransfer = inputPreviousTransfer.nextLine();
			fwrite.write("\nTransfer: " + previousTransfer);
			

			((Account) account[accountId]).setAccount(fisrtName, lastName, idCard, gender, email, phoneNumber, address);
			((Account) account[accountId]).setaccountInfo(true);
			fwrite.close();
		}

		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {

			System.out.println("******************** Set Account Information Success!");
			System.out.println("******************* Your Account Information ***********************");
			System.out.println("First Name = " + ((Account) account[accountId]).getAccountFirstName());
			System.out.println("Last Name = " + ((Account) account[accountId]).getAccountLastName());
			System.out.println("ID Card = " + ((Account) account[accountId]).getAccountIdCard());
			System.out.println("Gender = " + ((Account) account[accountId]).getAccountGender());

			System.out.println("Email = " + ((Account) account[accountId]).getAccountEmail());
			System.out.println("Address no = " + ((Account) account[accountId]).getAccountAddress());
			System.out.println("Phone number = " + ((Account) account[accountId]).getAccountPhoneNumber());

			System.out.println(((Account) account[accountId]).getAccountFirstName() + " Balance is "
					+ ((Account) account[accountId]).getAccountBalance());
			System.out.println("********************************************************");
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public static void getAccountInfo(int accountId) {
		System.out.println("****************** Your Account Information ******************");
		System.out.println("First Name = " + ((Account) account[accountId]).getAccountFirstName());
		System.out.println("Last Name = " + ((Account) account[accountId]).getAccountLastName());
		System.out.println("ID Card = " + ((Account) account[accountId]).getAccountIdCard());
		System.out.println("Gender = " + ((Account) account[accountId]).getAccountGender());
		System.out.println("Email = " + ((Account) account[accountId]).getAccountEmail());
		System.out.println("Address no = " + ((Account) account[accountId]).getAccountAddress());
		System.out.println("Phone number = " + ((Account) account[accountId]).getAccountPhoneNumber());

		System.out.println(((Account) account[accountId]).getAccountFirstName() + " Balance is "
				+ ((Account) account[accountId]).getAccountBalance());

		System.out.println("**********************************************************");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public static void setManager(int accountCount) {
		Scanner inputManager = new Scanner(System.in);
		System.out.print("\n Enter New Manager ID: ");
		String setManagerId = inputManager.nextLine();
		for (int i = 0; i < accountCount; i++) {
			if (account[i].getAccountId().equals(setManagerId)) {
				String id = ((Account) account[i]).getAccountId();
				((Account) account[i]).setManager(id);
				System.out.println("********** Set Manager Success!");
				System.out.println(" Manager ID = " + ((Account) account[i]).getAccountId());
				break;
			} else if (i == accountCount - 1) {
				System.out.println("********** Set Manager Fail!");
				break;
			}

		}
		LoginMenu(accountCount);
	}

	public static void getManagerInfo(int accountCount) {
		for (int i = 0; i < accountCount; i++) {
			if (((Account) account[i]).getAccountManager() == true) {
				System.out.println("********** Manager Information **********");
				System.out.println("Manager ID = " + ((Account) account[i]).getAccountId());
				System.out.println("Manager Name = " + ((Account) account[i]).getAccountName());
				System.out.println("Manager Pin = " + ((Account) account[i]).getAccountPin());
				System.out.println("Manager Balance = " + ((Account) account[i]).getAccountBalance());
				System.out.println("****************************************");
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				break;
			} else if (i == accountCount - 1) {
				System.out.println("********** No Manager **********");
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				break;
			}

		}
		LoginMenu(accountCount);
	}

	public static void Transferable(int accountId) {
		Scanner inputAccountTransfer = new Scanner(System.in);
		Scanner inputAccountAmount = new Scanner(System.in);
		System.out.print("\n Enter other account id to transfer: ");
		String transferTo = inputAccountTransfer.nextLine();
		System.out.print("\n Enter transfer amount: ");
		int amount = inputAccountAmount.nextInt();
		if (amount > ((Account) account[accountId]).getAccountBalance()) {
			System.out.println("********** Transfer Fail!");
			System.out.println("********** Your Balance is " + ((Account) account[accountId]).getAccountBalance());
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		} else {

			int balance = ((Account) account[accountId]).getAccountBalance() - amount;
			((Account) account[accountId]).setAccountBalance(balance);
			for (int i = 0; i < account.length; i++) {
				if (account[i].getAccountId().equals(transferTo)) {
					int balance2 = ((Account) account[i]).getAccountBalance() + amount;
					((Account) account[i]).setAccountBalance(balance2);
					break;
				}
			}
			System.out.println("********** Transfer Success!");
			System.out.println("********** Your Balance is " + ((Account) account[accountId]).getAccountBalance());

			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

	public static void deposit(int accountId) {
		Scanner inputAccountDeposit = new Scanner(System.in);
		System.out.println(" Enter deposit amount: ");
		int deposit = inputAccountDeposit.nextInt();
		int balance = ((Account) account[accountId]).getAccountBalance();
		balance += deposit;
		((Account) account[accountId]).setAccountBalance(balance);
		System.out.println("Deposit Success!");
		System.out.println("Your Balance is " + ((Account) account[accountId]).getAccountBalance());
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public static void withdraw(int accountId) {

		Scanner inputAccountWithdraw = new Scanner(System.in);

		System.out.println(" Enter withdraw amount: ");
		int withdraw = inputAccountWithdraw.nextInt();
		if (withdraw > ((Account) account[accountId]).getAccountBalance()) {
			System.out.println("Insufficient Balance");
		} else {
			int balance = ((Account) account[accountId]).getAccountBalance();
			balance -= withdraw;
			((Account) account[accountId]).setAccountBalance(balance);
			System.out.println("Withdraw Success!");
			System.out.println("Your Balance is " + ((Account) account[accountId]).getAccountBalance());
		}

		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
}
