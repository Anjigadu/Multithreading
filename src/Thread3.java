
public class Thread3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread=new Thread(new Runnable() {
			
			@Override
			public void run() {
			
				for(int i=0;i<9;i++){
					System.out.println("hello "+i);
				}
				
			}
		});
		
		thread.start();

	}

}
