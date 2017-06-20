import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownlatchExample {
	
	public static void main(String args[]){
		CountDownLatch latch=new CountDownLatch(3);
		
		ExecutorService executor=Executors.newFixedThreadPool(3);
		
		for(int i=0; i<3;i++){
			executor.submit(new RunningTask(latch));
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("completed");
	}
	
	
	
	
}


class RunningTask implements Runnable{
CountDownLatch latch;
	
	public RunningTask(CountDownLatch latch){
	this.latch=latch;
}
	@Override
	public void run() {
      System.out.println("thread is started"+latch);	
      
      latch.countDown();
	//System.out.println("completed "+latch);
	}
	
}