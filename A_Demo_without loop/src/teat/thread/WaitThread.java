package teat.thread;

class ThreadA extends Thread {
	int total;

	@Override
	public void run() {
		synchronized (this) {
			for (int i = 1; i <= 1000; i++) {
				total = total + i;
											
			}// end loop
			
			notifyAll();
		}

	}

	

}

public class WaitThread extends Thread {
	ThreadA A;

	public WaitThread(ThreadA newobj) {
		A = newobj;
	}

	public void run() {
		synchronized (A) {
			try {
				System.out.println("Wating for calculation by " + Thread.currentThread().getName());
				A.wait();
			} catch (InterruptedException e) {
			}

			System.out.println("calculated value seen by  " +Thread.currentThread().getName() + " is "+ A.total);
			
		}
		
	}

	public static void main(String[] args) {
		ThreadA ath = new ThreadA();
		ath.start();// called calculator 
		WaitThread wt1=new WaitThread(ath);// value reader thread 1
		wt1.setName("first Thread");
		wt1.start();
		
		WaitThread wt2=new WaitThread(ath);// value reader thread 2
		wt2.setName("second Thread");
		wt2.start();
		
		WaitThread wt3=new WaitThread(ath);// value reader thread 3
		wt3.setName("Third thread");
		wt3.start();

		synchronized (ath) {
			try {
				System.out.println("Please wait its calculating...");
				ath.wait();
				

			} catch (InterruptedException e) {
				e.printStackTrace();
				
			}
			System.out.println("Total seen by main Thread : " + ath.total);

					

		}

	}

}






















