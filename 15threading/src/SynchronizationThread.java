
public class SynchronizationThread {
	
	//synchronization will restrict this from accessed by different threads in the same time
	//learn this in the next video
	public static int counter = 0;

	public static void main(String[] args) {
		
		Thread threadNew =new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				for(int i=1; i<=1000; i++) {
					
					SynchronizationThread.counter++;
					//System.out.println("OTHER - The value of i is " + i);
				}
				System.out.println("LOOP in Thread1 is complete");
			}
		});	
		
		
		
		Thread thread2 =new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				for(int i=1; i<=1000; i++) {
					
					SynchronizationThread.counter++;
					//System.out.println("OTHER - The value of i is " + i);
				}
				System.out.println("LOOP in Thread2 is complete");
			}
		});	
		  
		threadNew.start();  
		thread2.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ERROR CATCHED");
		}
		System.out.println("The counter value is " + SynchronizationThread.counter);
		
		

	}

}
