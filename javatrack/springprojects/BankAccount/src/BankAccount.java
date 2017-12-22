
public class BankAccount {
	private String accountNumber;
	private double checkingBalance = 0;
	private double savingBalance;
	private static int numberOfAccount = 0;
	private static double totalMoney = 0;
	
	
	public BankAccount() {
		this.accountNumber = generateAccount();
        numberOfAccount++;
    }
	private String generateAccount() {
		String acc ="";
		int max = 10;
		int min = 0;
		
		for(int i = 0; i < 10; i ++) {
			int random =(int)(Math.random() * max + min);
			acc = acc.concat(String.valueOf(random));
		}
		return acc;
	}
	public String getAccountNumber() {
		return this.accountNumber;
	}
	public double getCheckingBalance() {
		return this.checkingBalance;
	}
	public double getSavingBalance() {
		return this.savingBalance;
	}
	public void deposit(String accountType, double amount) {
		String acc = accountType.toLowerCase();
		
		if(acc.equals("checking")) {
			this.checkingBalance += amount;
			totalMoney += amount;
		} else if(acc.equals("saving")) {
			this.savingBalance += amount;
			totalMoney += amount;
		} else {
			System.out.println("Could not find account with the name");
		}
	}
	public void withdraw(String accountType, double amount) {
		String acc = accountType.toLowerCase();

		if(acc.equals("checking")) {
			if(this.checkingBalance - amount < 0) {
				System.out.println("Insufficient funds");
			} else {
				this.checkingBalance -= amount;
				totalMoney -= amount;
			}
		} else if(acc.equals("saving")) {
			if(this.savingBalance - amount < 0) {
				System.out.println("Insufficient funds");
			} else {
				this.savingBalance -= amount;
				totalMoney -= amount;
			}
		} else {
			System.out.println("Could not find account with the name");
		}
	}
	public double accountBalance() {
		double total = this.checkingBalance + this.savingBalance;
		return total;
	}

	public static double getTotalMoney() {
		return totalMoney;
	}

	public static int getNumberOfAccounts() {
		return numberOfAccount;
	}
}
