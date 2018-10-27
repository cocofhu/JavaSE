package base;

import java.util.UUID;

public class AccessControlTest {
	static class Something{
		{
			System.out.println("something init...");
		}
	}
	static class Animal{
		public Something some = new Something() ; 
		// 用UID标识两只动物是否为同一动物
		public final String uid ;
		// private modifier
		private final int race ;
		// protected modifier
		protected int weight ;
		public Animal(int race) {
			this.uid = UUID.randomUUID().toString();
			this.race = race ;
			System.out.println("Animal(int)");
		}
		public final String getUid() {
			return uid;
		}
		public final int getRace() {
			return race;
		}
		public void move(){
			throw new UnsupportedOperationException();
		}
		@Override
		public String toString() {
			return "Animal [uid=" + uid + ", race=" + race + ", weight=" + weight + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((uid == null) ? 0 : uid.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Animal other = (Animal) obj;
			if (uid == null) {
				if (other.uid != null)
					return false;
			} else if (!uid.equals(other.uid))
				return false;
			return true;
		}
		
	}
	static class Dog extends Animal{
		private static final int  DEFAULT_DOG_RACE= 1 ;
		private String name ;
		public Dog(String name) {
			super(DEFAULT_DOG_RACE);
			this.name = name ; 
			System.out.println("DOG(int)");
		}
		@Override
		public void move() {
			System.out.println(uid);
			// Error
//			System.out.println(race);
			System.out.println(weight);
			System.out.println("Dog move");
		}
		@Override
		public String toString() {
			return "Dog [name=" + name + "]";
		}
		
	}
	public static void main(String[] args) {
		new Dog("ABC").move();
	}
}
