import java.util.Scanner;

public class ATM {
	private String userId;
	private String pin;
	private double balance = 0;

	public ATM(String userId, String pin) {
		this.userId = userId;
		this.pin = pin;
	}

	public boolean authenticate(String userId, String pin) {
		return this.userId.equals(userId) && this.pin.equals(pin);
	}

	public void checkBalance() {
		System.out.println("Your current balance is: " + balance);
	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println("Amount Deposited Successfully");
		} else {
			System.out.println("Invalid Amount");
		}
	}

	public void withdraw(double amount) {
		if (amount > 0) {
			if (amount <= balance) {
				balance -= amount;
				System.out.println("Amount withdrawn successfully");
			} else {
				System.out.println("Insufficient balance");
			}
		} else {
			System.out.println("Invalid amount");
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		ATM atm = new ATM("user", "1234");

		System.out.println("Welcome to User Atm");
		System.out.println("Enter your User ID");
		String userId = s.next();
		System.out.println("Enter your PIN");
		String pin = s.next();

		if (atm.authenticate(userId, pin)) {
			int choice;
			do {
				System.out.println("\n====ATM Menu====");
				System.out.println("1. Check Balance");
				System.out.println("2. Deposit");
				System.out.println("3. Withdraw");
				System.out.println("4. Exit");
				System.out.println("Choose an option: ");
				choice = s.nextInt();

				switch (choice) {
				case 1:
					atm.checkBalance();
					break;
				case 2:
					System.out.println("Enter amount to deposit");
					double deposit = s.nextDouble();
					atm.deposit(deposit);
					break;
				case 3:
					System.out.println("Enter amount to withdraw");
					double withdraw = s.nextDouble();
					atm.withdraw(withdraw);
					break;
				case 4:
					System.out.println("Thank you for choosing us!");
					break;
				default:
					System.out.println("Invalid Choice! Please try again.");
				}

			} while (choice != 4);

		} else {
			System.out.println("Invalid User ID or PIN");
		}

		s.close();
	}
}
