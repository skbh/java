package in.skbh.exe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Process implements Runnable {
	private int id = 0;

	@Override
	public void run() {
		System.out.println("Starting # " + id);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("completed # " + id);

	}

	public Process(int id) {
		this.id = id;
	}

}

public class ThreadPoolExecutorFramwork {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 5; i++) {
			executor.submit(new Process(i));
		}
		executor.shutdown();
		System.out.println("All tak submitted");
		try {
			executor.awaitTermination(3, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("All tak Completed");

	}

}
