class Class01 extends Thread{
	
	public int threadNo;

	public Class01(int threadNo) {
		super();
		this.threadNo = threadNo;
	}
	
	//override the run method
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		countMe();
	}
	
	public void countMe() {
		for(int i=1; i<=9; i++) {
			
			//because of this sleep, both the thread will be printed randomly since one of them will sleep and vice versa
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("the value of i is " + i+ " and the thread number is "+threadNo);
		}
	}
	
}

public class ExtendThread {
	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		Class01 obj1 = new Class01(1);
		obj1.start();
		System.out.println("******************");
		Class01 obj2 = new Class01(2);
		obj2.start();
		
		//without this sleep the total time will be printed in the beginning
		try {
			Thread.sleep(4505);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("Total Time Taken is - " + (endTime-startTime));
		
		
	}

}
