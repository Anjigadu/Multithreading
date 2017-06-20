import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class SchedulerExecutorServiceExample {

	public static void main(String args[]){
		
		ScheduledExecutorService executorService=Executors.newScheduledThreadPool(5);
		
		ScheduledFuture scheduledFuture =
				executorService.schedule(new Callable() {
			        public Object call() throws Exception {
			            System.out.println("Executed!");
			            return "Called!";
			        }
			    },
			    5,
			    TimeUnit.SECONDS);

			try {
				System.out.println("result = " + scheduledFuture.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			executorService.shutdown();
		
	}
	
}
