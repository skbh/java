package in.skbh.exe;

import java.util.Date;
import java.util.Scanner;

class Processor implements Runnable {
	private volatile boolean running = true;

	@Override
	public void run() {
		while (running) {
			System.out.println(new Date());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void shutdown() {
		running = false;
	}

}

public class SimpleThreadingExample {

	public static void main(String[] args) {
		Processor p1 = new Processor();
		Thread t1 = new Thread(p1);
		t1.start();
		System.out.println("Press any key to shutdown");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		p1.shutdown();

	}

}
