package queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueue1 {
 public	static BlockingQueue<String> myBlockingQueue=new ArrayBlockingQueue<String>(3);
	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		for(int i=0;i<2;i++){
		new Thread( new MyThreadPut()).start();
		}for(int j=0;j<2;j++){
		 new Thread(new MyThreadTake()).start();
		}
         
	}

}


class MyThreadPut implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		   while(true){
			      try {
					Thread.sleep((long)(Math.random()*1000));
					System.out.println(Thread.currentThread().getName()+"准备放数据，当前队列中的数据数量是"+BlockingQueue1.myBlockingQueue.size());
					BlockingQueue1.myBlockingQueue.put("1");
					System.out.println(Thread.currentThread().getName()+"已经放入数据当前的队列有"+BlockingQueue1.myBlockingQueue.size()+"个数据");
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   }
	}
	
	
}
class MyThreadTake implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			 try {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName()+"准备取走数据当前数据为"+BlockingQueue1.myBlockingQueue.size());
				BlockingQueue1.myBlockingQueue.take();
				System.out.println(Thread.currentThread().getName()+"已经取走数据的当前数据为："+BlockingQueue1.myBlockingQueue.size());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}

