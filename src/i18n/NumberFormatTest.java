package i18n;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatTest {
	public static void main(String[] args) {
		double db = 1234000.567 ; 
		Locale[] locales = {Locale.CHINA,Locale.CANADA} ;
		NumberFormat[] nfs = new NumberFormat[6] ;
		for (int i = 0; i < locales.length; i++) {
			nfs[i*3] = NumberFormat.getNumberInstance(locales[i]);
			nfs[i*3 +1] = NumberFormat.getPercentInstance(locales[i]) ; 
			nfs[i*3 +2] = NumberFormat.getCurrencyInstance(locales[i]);
		}
		for (int i = 0; i < nfs.length; i++) {
			System.out.println(nfs[i].format(db));
		}
	}
}
