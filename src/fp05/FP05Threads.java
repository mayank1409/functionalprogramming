package fp05;

public class FP05Threads {

	public static void main(String[] args) {
		
		// Approach 1
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					System.out.println(Thread.currentThread().getName() +  " :: " + i);
				}
				
			}
		};
		
		
		// Approach 2 using Functional Programming
		Runnable runnable2 = () -> {
			for (int i = 0; i < 10000; i++) {
				System.out.println(Thread.currentThread().getName() +  " :: " + i);
			}
		};
		
		Thread thread1 = new Thread(runnable2);
		thread1.setName("Thread1");
		Thread thread2 = new Thread(runnable2);
		thread2.setName("Thread2");
		
		thread1.start();
		thread2.start();
		

	}

}
