package in.skbh.exe;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Detecting Potential Deadlocks prevention [ lock example ]
public class BankAccount {

	private final Account sender = new Account();
	private final Account receiver = new Account();
	Random random = new Random();

	private final Lock lock1 = new ReentrantLock();
	private final Lock lock2 = new ReentrantLock();

	private void acquireLock(Lock lock1, Lock lock2) throws InterruptedException {
		boolean tryToGetLock1 = false;
		boolean tryToGetLock2 = false;
		while (true) {
			try {
				tryToGetLock1 = lock1.tryLock();
				tryToGetLock2 = lock2.tryLock();
			} finally {
				if (tryToGetLock1 && tryToGetLock2) {
					return;
				}
				if (tryToGetLock1) {
					lock1.unlock();
				}
				if (tryToGetLock2) {
					lock2.unlock();
				}
			}

			Thread.sleep(1);
		}
	}

	public void firstTransaction() {
		for (int i = 0; i < 100; i++) {
			/*
			 * lock1.lock(); lock2.lock();
			 */
			try {
				acquireLock(lock1, lock2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
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
			/*
			 * lock1.lock(); lock2.lock();
			 */
			try {
				acquireLock(lock1, lock2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
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

// simple lock example

/*
 * public class BankAccount {
 * 
 * private final Account sender = new Account(); private final Account receiver
 * = new Account(); Random random = new Random();
 * 
 * private final Lock lock1 = new ReentrantLock(); private final Lock lock2 =
 * new ReentrantLock();
 * 
 * public void firstTransaction() { for (int i = 0; i < 100; i++) {
 * lock1.lock(); lock2.lock(); try { sender.transfer(sender, receiver,
 * random.nextInt(100)); } finally { lock1.unlock(); lock2.unlock(); } }
 * 
 * }
 * 
 * public void secondTransaction() { for (int i = 0; i < 100; i++) {
 * lock1.lock(); lock2.lock(); try { sender.transfer(receiver, sender,
 * random.nextInt(100)); } finally { lock1.unlock(); lock2.unlock(); } } }
 * 
 * public void finishedTransation() { System.out.println(
 * "Balance of sender account : " + sender.getBalance()); System.out.println(
 * "Balance of Receiver account : " + receiver.getBalance());
 * System.out.println("Balance of Total Amount : " + (sender.getBalance() +
 * receiver.getBalance())); }
 * 
 * }
 */
