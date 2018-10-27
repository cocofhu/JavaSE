package base;

public class InterfaceTest {
	static interface Moveable{
		int MAX_SPEED = 200 ;
		default void move(){
			System.out.println("moving ");
		}
	}
	static class Car implements Moveable{
		@Override
		public void move() {
			// MAX_SPEED = 100 ;
			System.out.println("The car is moving at "+MAX_SPEED+"km/h");
		}
	}
	public static void main(String[] args) {
		Moveable m = new Car() ;
		m.move();
	}
}
