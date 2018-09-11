package thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

public class ForkJoinPoolTest1 {
	static class PrintTask extends RecursiveAction{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int end ; 
		private int start ; 
		public PrintTask(int start, int end) {
			this.end = end;
			this.start = start;
		}

		@Override
		protected void compute() {
			if(end - start < 50){
				for(int i = start ; i <end ;i++){
					System.out.println(i);
				}
			}else{
				int middle = (start + end) / 2;
				new PrintTask(start, middle).fork();
				new PrintTask(middle, end).fork() ;
			}
		}
		
	}
	public static void main(String[] args) throws InterruptedException {
		ForkJoinPool pool = new ForkJoinPool() ; 
		pool.submit(new PrintTask(0, 300));
		pool.awaitTermination(2, TimeUnit.SECONDS) ; 
		pool.shutdown();
	}
}
