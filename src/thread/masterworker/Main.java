package thread.masterworker;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		long start = System.currentTimeMillis() ;
		Master master = new Master(new Worker(), 1000) ; 
		Random r = new Random() ; 
		for (int i = 0; i < 1000; i++) {
			Task t = new Task() ; 
			t.setId(i);
			t.setName("Node:"+i);
			t.setPrice(r.nextInt(1000));
			master.submit(t);
		}
		master.execute(); 
		while(true){
			if(master.isCompleted()){
				long end = System.currentTimeMillis() ;
				int ret = master.getResults() ; 
				System.out.println(ret);
				System.out.println("times :" + (end - start));
				break ;
			}
		}
	}
}
