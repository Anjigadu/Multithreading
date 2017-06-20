import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
	
		public static void main(String args[]){
			
			ExecutorService executor=Executors.newFixedThreadPool(2);
			for(int i=0;i<5;i++){
				executor.submit(new Process(i));
			}
			
			executor.shutdown();
			
			try {
				executor.awaitTermination(1, TimeUnit.DAYS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("All task Completed");
		}

}

 class Process implements Runnable {
     private int i;
	 
	 Process(int i){
		 this.i=i;
	 }
	 
	@Override
	public void run() {

		System.out.println("starting the task "+i);
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			
		}
		
		System.out.println("completed the task "+i);
	}
	 
	
}