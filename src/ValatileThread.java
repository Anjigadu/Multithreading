// Volatile will garantees the visibility of variable from main memmory.it directly read form main memory .and changes will Reflect immediatly to the main memory rather than CPU Cache 

//http://tutorials.jenkov.com/java-concurrency/volatile.html


import java.util.Scanner;

public class ValatileThread {
	
	public static void main(String args[]){
		Processor processor=new Processor();
		processor.start();
		
		
		//stop thethread
		
		Scanner scanner=new Scanner(System.in);
		scanner.nextLine();
		processor.shutdown();
	}

}

class Processor extends Thread{
	private volatile boolean runable=true;
	@Override
	public void run() {
		while(runable){
			System.out.println("executing");
		}
		try {
			
			Thread.sleep(100);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void shutdown(){
		runable=false;
	}
	
}