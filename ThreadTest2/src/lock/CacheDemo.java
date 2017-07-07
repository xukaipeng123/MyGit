package lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheDemo {

	private Map<String, Object> cache = new HashMap<String, Object>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
            CacheDemo cacheDemo=new CacheDemo();
            System.out.println(cacheDemo.getData("1")); 
	}
          
	private ReadWriteLock rwl = new ReentrantReadWriteLock();
	public  Object getData(String key){
		//上读锁后，读线程可以访问
		rwl.readLock().lock();
		Object value = null;
		try{
			value = cache.get(key);
			if(value == null){
				rwl.readLock().unlock();
				rwl.writeLock().lock();
				try{
					if(value==null){
						value = "aaaa";//实际实现queryDB();
					}
				}finally{
					rwl.writeLock().unlock();
				}
				rwl.readLock().lock();
			}
		}finally{
			rwl.readLock().unlock();
		}
		return value;
	}
}
