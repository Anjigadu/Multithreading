import java.util.Scanner;

public class WaitNotiFyExample {

	public static void main(String[] args) throws InterruptedException {
Proces proces=new Proces();
		Thread thread=new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					proces.producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
Thread thread2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					proces.consumer();
				} catch (InterruptedException e) {
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


class Proces{
	public void producer() throws InterruptedException{
		synchronized (this){System.out.println("Running Producer Thread");
		System.out.println("waiting...");
		wait();
		System.out.println("Resumed");
		}
	}
	
	public void consumer() throws InterruptedException{
		Thread.sleep(100);
		synchronized (this){	
			System.out.println("Press enter key to contine");
		Scanner scanner=new Scanner(System.in);
		scanner.nextLine();
		
		notify();
		}
	}
}
