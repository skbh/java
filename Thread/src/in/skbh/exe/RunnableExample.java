package in.skbh.exe;

import java.util.Date;

class RunnableService implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i <= 10; i++) {
			System.out.println("value of i =" + i + " " + new Date());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class RunnableExample {

	public static void main(String[] args) {
		Thread t1 = new Thread(new RunnableService());
		Thread t2 = new Thread(new RunnableService());
		t1.start();
		t2.start();

	}

}
