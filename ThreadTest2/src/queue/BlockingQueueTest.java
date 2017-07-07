package queue;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



/*
 * �������У��������ݵ��ٶ�С��ȡ���ݵ��ٶȻ���ֵȴ����������������ݺ�ȡ���ݵ��̻߳�����ȡ������
 */
public class BlockingQueueTest {
	public static void main(String[] args) {
		List list = new ArrayList<String>();
		final Lock myLock=new ReentrantLock();
		//���������п��Դ��3������
		final BlockingQueue queue = new ArrayBlockingQueue(3);
		for(int i=0;i<2;i++){
			new Thread(){
				public void run(){
					while(true){
						try {
					
						Thread.sleep((long)(Math.random()*1000));
							System.out.println(Thread.currentThread().getName() + "׼��������!");							
							queue.put(1);
							
								System.out.println(Thread.currentThread().getName() + "�Ѿ��������ݣ�" + 							
								"����Ŀǰ��" + queue.size() + "������");
						} catch (InterruptedException e) {
							e.printStackTrace();
							}
					
					}
					
				}
			}.start();
			
		}
		
		new Thread(){
			public void run(){
				while(true){
					try {
						
						//���˴���˯��ʱ��ֱ��Ϊ100��1000���۲����н��
						Thread.sleep(1000);
						System.out.println(Thread.currentThread().getName() + "׼��ȡ����!");
						queue.take();
						System.out.println(Thread.currentThread().getName() + "�Ѿ�ȡ�����ݣ�" + 							
								"����Ŀǰ��" + queue.size() + "������");					
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
			}
			
		}.start();			
	
}
}