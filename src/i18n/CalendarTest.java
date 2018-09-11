package i18n;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarTest {
	public static void main(String[] args) {
		Calendar c1 = Calendar.getInstance() ; 
		Calendar c2 = new GregorianCalendar() ;
		int year = c1.get(Calendar.YEAR) ;
		int month = c1.get(Calendar.MONTH);
		int day = c1.get(Calendar.DAY_OF_MONTH) ; 
		int hour = c1.get(Calendar.HOUR_OF_DAY);
		int minute = c1.get(Calendar.MINUTE) ;
		int second = c1.get(Calendar.SECOND);
		int mullisecond = c1.get(Calendar.MILLISECOND) ; 
		int week = c1.get(Calendar.DAY_OF_WEEK) ;
		String[] weeks = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"} ;
		StringBuilder sb = new StringBuilder()  ;
		sb.append(year).append("年").append(month).append("月")
		.append(day).append("日 ").append(hour).append(":").append(minute).append(" ")
		.append(second)
		.append(" ").append(mullisecond).append(" ").append(weeks[week]);
		System.out.println(sb);
	}
}
