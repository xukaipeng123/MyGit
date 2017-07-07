package cn.itcast.heima2;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//设定线程池里有3个线程
		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		//ExecutorService threadPool = Executors.newCachedThreadPool();
		//ExecutorService threadPool = Executors.newSingleThreadExecutor();
		for(int i=1;i<=10;i++){
			final int task = i;
			
			threadPool.execute(new Runnable(){
				@Override
				public void run() {
					for(int j=1;j<=10;j++){
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() + " is looping of " + j + " for  task of " + task);
					}
				}
			});
		}
		System.out.println("all of 10 tasks have committed! ");
		//threadPool.shutdownNow();
		
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("定时器开始工作！");
			}
		}, 6, 2, TimeUnit.SECONDS);
				
	}

}
