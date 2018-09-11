package i18n;
import java.text.DateFormat;
import java.util.Date;

public class DateFormatTest {

	public static void main(String[] args) {
		//DateFormat format = DateFormat.getDateInstance() ;
		//DateFormat format = DateFormat.getDateInstance(DateFormat.FULL, Locale.ENGLISH);
//		DateFormat format = DateFormat.getDateTimeInstance() ;
		DateFormat format = DateFormat.getDateTimeInstance() ;
		System.out.println(format.format(new Date()));
	}

}
