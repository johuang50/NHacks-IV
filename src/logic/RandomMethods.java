package logic;
import java.util.Timer;
import java.util.TimerTask;

public class RandomMethods {
	
	static String separator = ":";
	
	public static void main(String[] args) {
		long initialTime = System.currentTimeMillis();
		
		TimerTask task = new TimerTask()
		{
		        public void run()
		        {
		        	long time = (System.currentTimeMillis() - initialTime)/1000;
		        	int seconds = Math.round(time)%60;
		        	separator = ":";
		        	if(seconds < 10) {
		        		
		        		separator = separator + 0;
		        	}
		            System.out.println((int) time/60 + separator + seconds);
		         
		        }

		};
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(task, 0, 1000l);
	}
	

	
	
}
