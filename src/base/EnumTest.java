package base;

public class EnumTest {
	public static void main(String[] args){
		Operation p = Operation.PLUS ; 
		System.out.println(p.eval(4,5));
	}
}
interface Eval {
	int eval(int x,int y) ; 
} 
enum Operation{
	PLUS{
		public int eval(int x,int y){
			return x+y;
		}
	},
	MINUS{
		public int eval(int x,int y){
			return x-y;
		}
	},
	DIVIDE{
		public int eval(int x,int y){
			return x/y;
		}
	},
	MULTIPLY{
		public int eval(int x,int y){
			return x*y;
		}
	};
	public abstract int eval(int x,int y);
}
