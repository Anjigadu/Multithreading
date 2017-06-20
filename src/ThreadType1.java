
// first wat to create a thread is 
public class ThreadType1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Thread1 thread1 =new Thread1();
thread1.start();

Thread1 thread12=new Thread1();
thread12.start();
	}

}


class Thread1 extends Thread{

	@Override
	public void run() {
	
		
		for(int i=0;i<9;i++){
			System.out.println(" threading Execution Process"+i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
