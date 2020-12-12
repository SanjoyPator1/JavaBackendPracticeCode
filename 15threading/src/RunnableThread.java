import java.util.Random;

//2 way of using runnable thread
class MyClass implements Runnable{
	
	public int threadNo;
	
	public MyClass(int threadNo) {
		super();
		this.threadNo = threadNo;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Random  random = new Random();
		
		for(int i=1; i<=9; i++) {
			
			//because of this sleep, both the thread will be printed randomly since one of them will sleep and vice versa
			try {
				Thread.sleep(random.nextInt(300));	//0 to 500
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("the value of i is " + i+ " and the thread number is "+threadNo);
		}
		
		
	}
	
	
	
}


public class RunnableThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread thread1 = new Thread(new MyClass(1));
		Thread thread2 = new Thread(new MyClass(2));
		
		thread1.start();
		thread2.start();
		
		//can make thread like this
		Thread threadNew =new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=1; i<=9; i++) {
					
					//because of this sleep, both the thread will be printed randomly since one of them will sleep and vice versa
					try {
						Thread.sleep(500);	//0 to 500
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println("OTHER - The value of i is " + i);
				}
			}
		});	//can't start here when naming the thread to use later
		
		threadNew.start();  //have to start here

	}

}
