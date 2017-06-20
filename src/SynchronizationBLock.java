import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.Current;

//Synchronized  Block ackires entrance lock on instance object we can execute parallel two synchronized blocks by two separate threads 
public class SynchronizationBLock {
	
	Object lock1=new Object();
	Object lock2=new Object();
	List<Integer> list1=new ArrayList<Integer>();
	List<Integer> list2=new ArrayList<Integer>();

	
	public void stage1(){
		synchronized(lock1){
			for(int i=0;i<=1000;i++){
				list1.add(new Integer(i));
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


public  void stage2(){
	synchronized(lock2){
		for(int i=0;i<=1000;i++){
			list2.add(new Integer(i));
		}
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}


		public void process(){
			stage1();
			stage2();
		}



	public static void main(String args[]){
		
		System.out.println("starting");
		long start=System.currentTimeMillis();
		Thread thread=new Thread(new Runnable() {
			
			@Override
			public void run() {
				SynchronizationBLock bLock=new SynchronizationBLock();
				bLock.process();
				
			}
		});
		
		
		
	Thread thread2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				SynchronizationBLock bLock=new SynchronizationBLock();
				bLock.process();
				
			}
		});
	thread.start();
		thread2.start();

		try {
			thread.join();
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long end=System.currentTimeMillis();
		System.out.println("Time taken"+(end-start));
	}

}
