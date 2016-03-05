package in.skbh.exe;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

	private final Account sender = new Account();
	private final Account receiver = new Account();
	Random random = new Random();

	private final Lock lock1 = new ReentrantLock();
	private final Lock lock2 = new ReentrantLock();

	public void firstTransaction() {
		for (int i = 0; i < 100; i++) {
			lock1.lock();
			lock2.lock();
			try {
				sender.transfer(sender, receiver, random.nextInt(100));
			} finally {
				lock1.unlock();
				lock2.unlock();
			}
		}

	}

	public void secondTransaction() {
		for (int i = 0; i < 100; i++) {
			lock1.lock();
			lock2.lock();
			try {
				sender.transfer(receiver, sender, random.nextInt(100));
			} finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}

	public void finishedTransation() {
		System.out.println("Balance of sender account : " + sender.getBalance());
		System.out.println("Balance of Receiver account : " + receiver.getBalance());
		System.out.println("Balance of Total Amount : " + (sender.getBalance() + receiver.getBalance()));
	}

}
