package cn.itcast.heima2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
public class CollectionModifyExceptionTest {
	public static void main(String[] args) {
		ArrayList<User> users = new ArrayList<User>();
			
			//new ArrayList();
		users.add(new User("����",28));	
		users.add(new User("����",25));			
		users.add(new User("����",31));	
		Iterator itrUsers = users.iterator();
		while(itrUsers.hasNext()){
			System.out.println("aaaa");
			User user = (User)itrUsers.next();
			if("����".equals(user.getName())){
				System.out.println("sasdas");
				users.remove(user);
				//itrUsers.remove();
			} else {
				System.out.println(user);				
			}
		}
	}
}	 
