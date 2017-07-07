package cn.itcast.heima2;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		    new Timer().schedule(new MyTimerTask(),2000);
              while(true){
                   Thread.sleep(1000);
                   System.out.println(new Date().getSeconds());
	}
              
          
}

}
class MyTimerTask extends TimerTask{
    public static int i=2;
	@Override
	public void run() {
		if(i%2==0)
		{   	
            new Timer().schedule(new MyTimerTask(), 2000);
            System.out.println("boom!");
            i++;
           
            
	}else{
		      
		      new Timer().schedule(new MyTimerTask(), 4000);
		      System.out.println("boom!");
		      i++;
		      
	}
	
	}
}
