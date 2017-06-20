import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadpoolExecutorExample {

	
	public static void main(String args[]){
		
		int  corePoolSize  =    5;
		int  maxPoolSize   =   10;
		long keepAliveTime = 5000;

		ExecutorService threadPoolExecutor =
		        new ThreadPoolExecutor(
		                corePoolSize,
		                maxPoolSize,
		                keepAliveTime,
		                TimeUnit.MILLISECONDS,
		                new LinkedBlockingQueue<Runnable>()
		                );
		
		threadPoolExecutor.execute(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("task");
				
			}
		});
		threadPoolExecutor.shutdown();
		System.out.println("size"+threadPoolExecutor.isShutdown());
	}
}
