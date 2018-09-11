package base;

public class BreakAndContinueTest {
	public static void main(String args[]){
		bb:
		//System.out.println("BB");Error
		//cc:
		//System.out.println("AA");
		for(int i = 0 ; i < 10 ; i++){
			System.out.println(i);
			//if(i == 5) break cc ; 
			if(i == 3) continue bb;
		}
	}
}
