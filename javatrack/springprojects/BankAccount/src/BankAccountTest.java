
public class BankAccountTest {

	public static void main(String[] args) {
		BankAccount b = new BankAccount();
        System.out.println(b.getAccountNumber());
        b.deposit("Checking", 1000);
        b.deposit("checking", 500);
		System.out.println(b.getCheckingBalance());
		b.deposit("Saving", 10);
		b.deposit("saving", 5);
		System.out.println(b.getSavingBalance());
		System.out.println(b.accountBalance());
		System.out.println(b.getTotalMoney());
	}

}
