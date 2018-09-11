package i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest {
	public static void main(String[] args) {
		Locale locale = Locale.getDefault() ; 
		ResourceBundle rb = ResourceBundle.getBundle("info", locale) ; 
		System.out.println(rb.getString("username"));
	}
}
