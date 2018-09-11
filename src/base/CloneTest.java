package base;

public class CloneTest{
	public static void main(String[] args)throws CloneNotSupportedException {
		Person p1 = new Person();
		p1.name = new String("AAA");
		Person p2 = p1.clone();
		System.out.println(p1.name == p2.name ) ;
	}
	
}
class Person implements Cloneable{
	public String name ; 
	public Person clone() throws CloneNotSupportedException{
		return (Person)super.clone();
	}
}