
 class Runner implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<9;i++){
			System.out.println(" Hello"+i);	
		}
		
		try {
			Thread.sleep(100);
				} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					};
	}

}


public class ThreadWithRunnable{
	public static void main(String arg[]){
		
	Thread thread=new Thread(new Runner());
	thread.start();
	}
	
	
}