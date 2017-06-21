import java.util.LinkedList;
import java.util.Random;

public class ProducerConsumerSynchExe {

	public static void main(String[] args) throws InterruptedException {
		
		Product product=new Product();
		
		Thread thread=new Thread( new Runnable() {
			
			@Override
			public void run() {
				try {
					product.producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread thread2=new Thread( new Runnable() {
			
			@Override
			public void run() {
				try {
					product.condumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		thread.start();
		thread2.start();
		thread.join();
		thread.join();

	}

}

 class Product{
	 
	 Object lock=new Object();
	 
	 
	 LinkedList<Integer> integers=new LinkedList<Integer>();
	private final int limit=10;
	 
	 public void producer() throws InterruptedException{
		 int value=0;
		synchronized(lock){
			 while(true){
				 if(integers.size()==limit){
					 lock.wait();
				 }
				
				 integers.add(value++);
				 lock.notify();
				// 
			 }
		}
		
		 
		 
	 }
	 public void condumer() throws InterruptedException{
		 Random random=new Random();
		
		 synchronized(lock){
			 while(true){
			 System.out.println("size "+integers.size());
			 int value=integers.removeFirst();
			  System.out.println(" value Consumed   "+value);
			 if(integers.size()==0){
				 lock.wait();
			 }
			 lock.notify();
			 
			 
			 Thread.sleep(random.nextInt(1000));
			 }
		 }
		 
		 
	 }
	
}