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
					System.out.println(Thread.currentThread().getName()+"׼�������ݣ���ǰ�����е�����������"+BlockingQueue1.myBlockingQueue.size());
					BlockingQueue1.myBlockingQueue.put("1");
					System.out.println(Thread.currentThread().getName()+"�Ѿ��������ݵ�ǰ�Ķ�����"+BlockingQueue1.myBlockingQueue.size()+"������");
					
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
				System.out.println(Thread.currentThread().getName()+"׼��ȡ�����ݵ�ǰ����Ϊ"+BlockingQueue1.myBlockingQueue.size());
				BlockingQueue1.myBlockingQueue.take();
				System.out.println(Thread.currentThread().getName()+"�Ѿ�ȡ�����ݵĵ�ǰ����Ϊ��"+BlockingQueue1.myBlockingQueue.size());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}

