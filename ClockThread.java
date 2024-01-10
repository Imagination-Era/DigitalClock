package Clock;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ClockThread extends Thread{

	digitalClock dc;
	public ClockThread(digitalClock dc) {
		this.dc=dc;
		start();
	}

	public void run() {
		while(true) {
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
			String formatDate=sdf.format(date);
			
			String[]dateArr=formatDate.split(":");
			dc.Hours.setText(dateArr[0]);
			dc.Min.setText(dateArr[1]);
			dc.Seconds.setText(dateArr[2]);
			
		}
	}

}
