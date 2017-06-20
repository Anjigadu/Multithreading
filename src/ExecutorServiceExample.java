import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {
	
	public static void main(String args[]){
		ExecutorService executorService=Executors.newSingleThreadExecutor();
		
		/*executorService.execute(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Anonymus Task");
			}
		});
		
		executorService.shutdown();*/
		
		
	/*	Future future = executorService.submit(new Runnable() {
		    public void run() {
		        System.out.println("Asynchronous task");
		    }
		});

		try {
			future.get();  //returns null if the task has finished correctly.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		
		/*Future future=executorService.submit(new Callable() {

			@Override
			public Object call() throws Exception {
				System.out.println("executing Asyncronous task");
				return "Returning String Object";
			}
		});
		try {
			System.out.println("   returned Value"+future.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//create collable Hash set
		
		Set<Callable<String>> callables=new HashSet<Callable<String>>();
		
		callables.add(new Callable<String>() {

			@Override
			public String call() throws Exception {
				return "task1";
			}
		});
		
		
		callables.add(new Callable<String>() {

			@Override
			public String call() throws Exception {
				return "task2";
			}
		});
		
		
		
		callables.add(new Callable<String>() {

			@Override
			public String call() throws Exception {
				return "task3";
			}
		});
		
		try {
			String result=executorService.invokeAny(callables);
			System.out.println(" result    "+result);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			List<Future<String>> futures=executorService.invokeAll(callables);
			
			for(Future<String> future:futures){
				
				try {
					System.out.println(" task List ...:"+future.get());
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
