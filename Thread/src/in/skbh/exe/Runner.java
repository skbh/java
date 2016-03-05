package in.skbh.exe;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

	private int count = 0;
	private final Lock lock = new ReentrantLock();
	private final Condition cond = lock.newCondition();

	private void increment() {

		for (int i = 0; i < 10000; i++) {
			count++;
		}
	}

	public void firstThread() throws InterruptedException {
		lock.lock();
		System.out.println("Waiting...");
		cond.await();
		System.out.println("awake and counting again...");

		try {
			increment();
		} finally {
			lock.unlock();
		}
	}

	@SuppressWarnings("resource")
	public void secondThread() throws InterruptedException {
		lock.lock();
		System.out.println("press any key");
		new Scanner(System.in).nextLine();
		System.out.println("key pressed");
		cond.signal();
		try {
			increment();
		} finally {
			lock.unlock();
		}
	}

	public void finished() {
		System.out.println("count : " + count);
	}

}
