package in.skbh.exe;

public class Re_Enterant_Banking_Application {

	public static void main(String[] args) {
		BankAccount bankAccount = new BankAccount();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				bankAccount.firstTransaction();
			}

		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				bankAccount.secondTransaction();
			}

		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		bankAccount.finishedTransation();
	}

}
