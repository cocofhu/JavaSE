package thread.masterworker;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker implements Runnable{

	private ConcurrentLinkedQueue<Task> tasks ; 
	private ConcurrentHashMap<String, Object> results  ;
	
	public void setWorkerQueue(ConcurrentLinkedQueue<Task> tasks) {
		this.tasks = tasks ;
	}

	public void setResultMap(ConcurrentHashMap<String, Object> results) {
		this.results = results ; 
	}
	
	@Override
	public void run() {
		while(true){
			Task input = this.tasks.poll() ;
			if(input == null ) break ; 
			Object output = handle(input) ; 
			this.results.put(""+input.getId(), output) ; 
		}
	}

	private Object handle(Task input) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return input.getPrice() ;
	}

}
