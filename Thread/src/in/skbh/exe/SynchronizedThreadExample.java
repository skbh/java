package in.skbh.exe;

import java.util.Date;

public class SynchronizedThreadExample {

	/* private final AtomicInteger count = new AtomicInteger(0); */
	private Integer count = 0;

	public synchronized void increment() {
		count++;
	}

	public static void main(String[] args) {

		SynchronizedThreadExample synchronizedThreadExample = new SynchronizedThreadExample();
		synchronizedThreadExample.doCounting();

	}

	public void doCounting() {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println(new Date());
				for (int i = 0; i < 1000; i++) {
					increment();// count.incrementAndGet();
				}
			}

		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println(new Date());
				for (int i = 0; i < 1000; i++) {
					increment(); // count.incrementAndGet();
				}
			}

		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Count# " + count);

	}

}
