


// synchronized on method  will aCkvire entersic lock on the object   
public class SyncrinizationClass {
 int count=0;
 
 public synchronized void increment(){
	 
	 count++;
 }
 public void test(String str){
	 System.out.println("test method"+str);
 }
		public static void main(String args[]){
			SyncrinizationClass class1=new SyncrinizationClass();
			class1.doWork();
			
			//System.out.println("count"+count);
		}
	
	
			public void doWork(){
				
				Thread thread=new Thread(new Runnable() {
					
					@Override
					public void run() {
						for(int i=0;i<10000;i++){
							increment();
							
						}
						test("first");
					}
				});
				
				
				
             Thread thread2=new Thread(new Runnable() {
					
					@Override
					public void run() {
						for(int i=0;i<10000;i++){
							increment();
							
						}
						test("second");
					}
				});
             
             
             thread.start();
             
             thread2.start();
             
             try {
				thread.join();
				thread2.join();
				System.out.println("cnt t"+count);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
			

}
