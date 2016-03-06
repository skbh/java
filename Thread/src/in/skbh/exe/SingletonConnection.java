package in.skbh.exe;

import java.util.concurrent.Semaphore;

public class SingletonConnection {
	private static SingletonConnection singletonConnection;
	private int connection = 0;
	Semaphore semaphore = new Semaphore(50);

	private SingletonConnection() {
		if (SingletonConnection.singletonConnection != null) {
			throw new IllegalStateException("Already instantiated");
		}
	}

	public static SingletonConnection getInstance() {
		if (singletonConnection != null)
			return singletonConnection;
		return new SingletonConnection();
	}

	public void connect() {
		try {
			semaphore.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		synchronized (this) {
			connection++;
			System.out.println("Active Connection =" + connection);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		synchronized (this) {
			connection--;
		}

		semaphore.release();
	}

}
