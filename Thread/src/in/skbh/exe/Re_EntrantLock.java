package in.skbh.exe;

public class Re_EntrantLock {

	public static void main(String[] args) {
		Runner runner = new Runner();
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {

				try {
					runner.firstThread();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		});
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					runner.secondThread();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		});

		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		runner.finished();

	}

}
