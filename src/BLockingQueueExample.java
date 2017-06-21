import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BLockingQueueExample {

	
	static BlockingQueue<Integer> blockingQueue=new ArrayBlockingQueue<>(5) ; 
	
	public static void producer() throws InterruptedException{
		Random random=new Random();
		while(true){
			blockingQueue.put(random.nextInt(50));
		}
	
	}
	
	public static void consumer() throws InterruptedException{
		Thread.sleep(1000);
		Random random=new Random();
		while(true){
			if(blockingQueue.size()==5)
			blockingQueue.take();
			System.out.println(""+blockingQueue.take() +" size of queue"+blockingQueue.size());
		}
		
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		Thread thread=new Thread(new Runnable() {
			public void run() {
				try {
					producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		Thread thread2=new Thread(new Runnable() {
			public void run() {
				try {
					consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		thread.start();
		thread2.start();
		thread.join();
		thread2.join();
	}

	
	
}
