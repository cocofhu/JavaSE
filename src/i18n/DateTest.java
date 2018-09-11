package i18n;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date.getTime());
		System.out.println(date);
		System.out.println(date.toLocaleString());
	}

}
