package in.skbh.exe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SemaphoreBasic {

	public static void main(String[] args) {
		SingletonConnection singletonConnection = SingletonConnection.getInstance();

		ExecutorService executor = Executors.newCachedThreadPool();
		for (int i = 0; i < 200; i++) {
			executor.submit(new Runnable() {
				@Override
				public void run() {
					singletonConnection.connect();

				}

			});
		}
		executor.shutdown();
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
