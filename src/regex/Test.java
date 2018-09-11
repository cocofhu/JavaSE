package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {
		System.out.println("abc".matches("..."));
		System.out.println("a11432a".replaceAll("\\d", "-"));
		Pattern p = Pattern.compile("[a-z]{3}");
		Matcher m = p.matcher("fgh") ; 
		System.out.println(m.matches());
		System.out.println("fgh".matches("[a-z]{3}"));
		System.out.println("a".matches("pppp|a"));
		System.out.println("a".matches("."));
		System.out.println("aa".matches("a+"));
		System.out.println("aaaa".matches("a*"));
		System.out.println("a".matches("a?"));
		System.out.println("".matches("a?"));
		System.out.println("".matches("a{0,1}"));
		System.out.println("a".matches("a{0,1}"));
		System.out.println("a".matches("[asdasdasdasdsad]"));
		System.out.println("^".matches("[^\\^]"));
		System.out.println("A".matches("[a-zA-z]"));
		System.out.println("A".matches("[a-z|A-z]"));
		System.out.println("b".matches("[A-Z]|[a-z]"));
		System.out.println("z".matches("[a-z&&c]"));
		System.out.println("b".matches("[A-Z[a-z]]"));
		System.out.println(" \r\t\n".matches("\\s{4}"));
		System.out.println("asdd".matches("[^\\s]{4}"));
		System.out.println(" ".matches("\\S"));
		System.out.println("dsadasada233232".matches("[a-z]{3,100}\\d+"));
		System.out.println("\\".matches("\\\\"));
		System.out.println("a".matches("\\p{Lower}"));
		System.out.println("hello sir".matches("^h.*"));
		System.out.println("hello sir".matches(".*ir$"));
		System.out.println("hello sir".matches("^h[a-z]{1,3}o\\b.*"));
		System.out.println(" \n".matches("^[\\s]*\\n$"));
		System.out.println("aaa 8888c".matches(".*\\d{4}."));
		System.out.println("aaa 8888c".matches(".*\\b\\d{4}."));
		System.out.println("aaa8888c".matches(".*\\d{4}."));
		System.out.println("aaa8888c".matches(".\\b\\d{4}."));
		Pattern p1 = Pattern.compile("\\d{3,5}");
		String s1= "123-1231-1231332-23" ; 
		Matcher m1 = p1.matcher(s1) ;
		System.out.println(m1.matches());
		m1.reset() ; //
		System.out.println(m1.find());
		System.out.println(m1.start() +"-" +m1.end());
		System.out.println(m1.find());
		System.out.println(m1.start() +"-" +m1.end());
		System.out.println(m1.find());
		System.out.println(m1.start() +"-" +m1.end());
		System.out.println(m1.lookingAt());
		m1.reset();
		while(m1.find()){
			System.out.println(m1.group());
		}
		
		Pattern p2 = Pattern.compile("java",Pattern.CASE_INSENSITIVE);
		Matcher m2 = p2.matcher("java Java JAVaIloveJAVA you hateJava afasdfasdf");
		StringBuffer buf = new StringBuffer();
		int i=0;
		while(m2.find()) {
			i++;
			if(i%2 == 0) {
				m2.appendReplacement(buf, "java");
			} else {
				m2.appendReplacement(buf, "JAVA");
			}
		}
		m2.appendTail(buf);
		System.out.println(buf);
		System.out.println("Java".matches("(?i)(java)"));
		System.out.println("aa".matches("(a)\\1"));//
		System.out.println("()".matches("\\(\\)"));
		
		Pattern p3 = Pattern.compile("(?<=a)123");
		Matcher m3 = p3.matcher("aa1233a");
		m3.reset();
		while(m3.find()){
			System.out.println(m3.group());
		}

		
	}

}
