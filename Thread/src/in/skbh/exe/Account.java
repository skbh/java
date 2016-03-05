package in.skbh.exe;

public class Account {

	private Integer balance = new Integer(10000);

	public Integer getBalance() {
		return balance;
	}

	public void deposit(Integer amount) {
		balance += amount;

	}

	public void withdraw(Integer amount) {
		balance -= amount;

	}

	public void transfer(Account senderAccount, Account receiverAccount, Integer amount) {
		senderAccount.withdraw(amount);
		receiverAccount.deposit(amount);

	}

}
