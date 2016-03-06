package in.skbh.exe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Execute implements Runnable {
	private int count = 0;
	private final Lock lock = new ReentrantLock();

	public int getCount() {
		return count;
	}

	@Override
	public void run() {
		lock.lock();
		task();
		lock.unlock();

	}

	private void task() {

		for (int i = 1; i <= 100000; i++) {
			count++;
		}

	}

}

public class MultiThread {

	public static void main(String[] args) {
		Execute execute = new Execute();

		Thread t1 = new Thread(execute);
		Thread t2 = new Thread(execute);
		Thread t3 = new Thread(execute);
		t1.start();
		t2.start();
		t3.start();
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("counting done : " + execute.getCount());

	}

}
