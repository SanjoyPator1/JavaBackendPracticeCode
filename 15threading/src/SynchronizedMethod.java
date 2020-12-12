class Brackets{
	
	// this restricts the function to be used by different threads
	//but specific to objects - locks a specific object 
	//- so wont work in obj1 and obj2
	synchronized public void generate() {
		for(int i =1; i<=10; i++) {
			
			if(i<=5) {
				System.out.print("[");
			}else {
				System.out.print("]");
			}
		}
		System.out.println();
	}
	
	
}


public class SynchronizedMethod {

	public static void main(String[] args) {
		
		Brackets brackets = new Brackets();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i =1; i<=5; i++) {
					brackets.generate();
				}	
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i =1; i<=5; i++) {
					brackets.generate();
				}	
			}
		}).start();

	}

}
