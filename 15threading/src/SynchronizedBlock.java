class Brackets2{
	
	// this restricts the function to be used by different threads
	//but specific to objects - locks a specific object 
	//- so wont work in obj1 and obj2
	//synchronized public void generate - BEFORE
	//this private object will restrict the lock to be edited explicitly
	private Object lock = "lock"; 
	public void generate() {
		
		//no impact will be seen now
		synchronized (lock) {
		for(int i =1; i<=10; i++) {
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(i<=5) {
				System.out.print("[");
			}else {
				System.out.print("]");
			}
		}
		System.out.println();
		}	//synchronized only up to this braces - block
		
		//later part is not synchronized
		
		for(int j =0; j<=10; j++) {
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}


public class SynchronizedBlock {

	public static void main(String[] args) {
		
		Brackets2 brackets = new Brackets2();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				long startTime = System.currentTimeMillis();
				for(int i =1; i<=5; i++) {
					brackets.generate();
				}
				long endTime = System.currentTimeMillis();
				System.out.println("Total Time Taken for thread 1 is - " + (endTime-startTime));
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				long startTime = System.currentTimeMillis();
				for(int i =1; i<=5; i++) {
					brackets.generate();
				}
				long endTime = System.currentTimeMillis();
				System.out.println("Total Time Taken for thread 2 is - " + (endTime-startTime));
			}
		}).start();

	}

}
