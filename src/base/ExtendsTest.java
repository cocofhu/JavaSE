package base;

public class ExtendsTest{
	public static void main(String[] args){
		Fruit apple = new Apple();
		apple.weight = 50 ; 
		apple.info();
	}
}
class Fruit{
	public int weight;
	protected void info(){System.out.println("I am a fruit! The weight of me is " + weight );}
}
class Apple extends Fruit{
	private int weight ;
	@Override
	public void info(){
		super.info();
		System.out.println("I am an apple!"+weight+super.weight);
	}
}
/*
class RedApple extends Apple{
	@Override
	public void info(){
		super.super.info();
		System.out.println("I am an apple!");
	}
}*/