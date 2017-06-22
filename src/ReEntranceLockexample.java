import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReEntranceLockexample {
	

	public static void main(String args[]) throws InterruptedException{
		Producer producer=new Producer();
		Thread thread=new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					producer.firstthread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread thread2=new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					producer.secondThread();
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
		
		producer.finalOutput();
	}
}



class Producer{
	ReentrantLock lock=new ReentrantLock();
	Condition condition=lock.newCondition();
	
	  private int Count=0;
	public  void firstthread() throws InterruptedException{
	//	Thread.sleep(1000);
		lock.lock();
		System.out.println(" wating ...");
		condition.await();
		System.out.println(" Reasumed ...");
		try{
			inCrement();
			
		}finally{
			lock.unlock();
		}
	
	}
	
	public  void secondThread() throws InterruptedException{
		lock.lock();
		Thread.sleep(1000);
		Scanner scanner=new Scanner(System.in);
		System.out.println("press the enter key");
		scanner.nextLine();
		condition.signal();
		try{
			inCrement();
		}finally{
			lock.unlock();
		}
		
	}

     private void inCrement(){
		for(int i=0;i<10000;i++){
			Count++;
		}
  }

     
     public void finalOutput(){
    	 System.out.println(" total count"+Count);
     }
}