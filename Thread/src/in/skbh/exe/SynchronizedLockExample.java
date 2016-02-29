package in.skbh.exe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Job {
	private final Object lockOne = new Object();
	private final Object lockTwo = new Object();
	private final Random randon = new Random();
	private final List<Integer> list1 = new ArrayList<Integer>();
	private final List<Integer> list2 = new ArrayList<Integer>();

	public List<Integer> getList1() {
		return list1;
	}

	public List<Integer> getList2() {
		return list2;
	}

	public void addJobOne() {
		synchronized (lockOne) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list1.add(randon.nextInt(100));
		}

	}

	public void addJobTwo() {
		synchronized (lockTwo) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list2.add(randon.nextInt(100));
		}
	}

	public void process() {
		for (int i = 0; i < 1000; i++) {
			addJobOne();
			addJobTwo();
		}
	}

}

public class SynchronizedLockExample {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Job job = new Job();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				job.process();

			}

		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				job.process();

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
		long end = System.currentTimeMillis();

		System.out.println("execution Time# " + (end - start));
		System.out.println("list one# " + job.getList1().size());
		System.out.println("list two# " + job.getList2().size());
	}

}
