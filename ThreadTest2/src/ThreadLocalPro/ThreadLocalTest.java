package ThreadLocalPro;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ThreadLocalTest {


	//private static ThreadLocal<MyThreadScopeData> myThreadScopeData = new ThreadLocal<MyThreadScopeData>();
	public static void main(String[] args) {
		for(int i=0;i<2;i++){
			new Thread(new Runnable(){
				@Override
				public void run() {
					int data = new Random().nextInt(50);
					System.out.println(Thread.currentThread().getName() 
							+ " has put data :" + data);
					
					MyThreadScopeData.getThreadInstance().setName("name" + data);
					MyThreadScopeData.getThreadInstance().setAge(data);
					new A().get();
					new B().get();
				}
			}).start();
		}
	}
	
	static class A{
		public void get(){
			MyThreadScopeData myData = MyThreadScopeData.getThreadInstance();
			System.out.println("A from " + Thread.currentThread().getName() 
					+ " getMyData: " + myData.getName() + "," +
					myData.getAge());
		}
	}
	
	static class B{
		public void get(){
					
			
			MyThreadScopeData myData = MyThreadScopeData.getThreadInstance();
			System.out.println("B from " + Thread.currentThread().getName() 
					+ " getMyData: " + myData.getName() + "," +
					myData.getAge());			
		}		
	}
}

class MyThreadScopeData{
	//��������ģʽ
	//˽�л����캯��
	private MyThreadScopeData(){}
	//дһ����̬�����Ļ�ȡ�������
	public static /*synchronized*/ MyThreadScopeData getThreadInstance(){
		MyThreadScopeData instance = map.get();
		if(instance == null){
			instance = new MyThreadScopeData();
			map.set(instance);
		}
		return instance;
	}
	//private static MyThreadScopeData instance = null;//new MyThreadScopeData();
	//�����ݶ������ThreadLocal�����п���ʵ���̷߳�Χ�ڵ����ݹ���
	private static ThreadLocal<MyThreadScopeData> map = new ThreadLocal<MyThreadScopeData>();
	
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
