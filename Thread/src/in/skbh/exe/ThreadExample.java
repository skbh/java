package in.skbh.exe;

import java.util.Date;

class Service extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("value of i =" + i + " " + new Date());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

public class ThreadExample {

	public static void main(String[] args) {
		Service service = new Service();
		Service service1 = new Service();
		service.start();
		service1.start();

	}

}
