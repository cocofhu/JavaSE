package generic;

public class ErasureTest {
	static class Apple<T extends Number>{
		T size ;
		public Apple(){}
		public Apple(T size){this.size = size ;}
		public void setSize(T size){this.size = size ;}
		public T getSize() {
			return size;
		}
	}
	public static void main(String[] args) {
		Apple<Integer> a = new Apple<Integer>(6);
		Integer as = a.getSize() ;
		Apple b = a ; 
		Number size1 = b.getSize() ;
		//Integer size2 = b.getSize() ;
		
	}
}
