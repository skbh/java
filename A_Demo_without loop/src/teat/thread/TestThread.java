package teat.thread;


class runnable implements Runnable{
    
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Started");
		for(int s=0;s<=20;s++){
			System.out.println("s= " + s + " by " + Thread.currentThread().getName());
			try {
				System.out.println("Sleeping for 500 Millisec" + Thread.currentThread().getName());
				Thread.sleep(500);
				
				} catch (InterruptedException e) {
					System.out.println("The thread has been interrupted");
					System.out.println("The thread is interrupted : " + Thread.currentThread().isInterrupted());
				
			}
			
			
		}
		System.out.println(Thread.currentThread().getName() + "is exiting from thread");
	}
	
}


public class TestThread {

	public static void main(String[] args) {
		runnable run=new runnable();
		Thread th=new Thread(run);
		Thread th_1=new Thread(run);
		Thread th_2=new Thread(run);
		th.setName("first");
		th.start();
		th_1.start();
		th_1.setName("second");
		th_2.start();
		th_2.setName("third");
		

	}

}
