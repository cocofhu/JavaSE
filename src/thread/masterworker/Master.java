package thread.masterworker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Master {
	
	private ConcurrentLinkedQueue<Task> tasks = new ConcurrentLinkedQueue<Task>();
	
	private HashMap<String, Thread> workers = new HashMap<String, Thread>() ; 
	
	private ConcurrentHashMap<String, Object> results = new ConcurrentHashMap<String, Object>() ; 
	
	public Master(Worker worker,int workerCount){
		worker.setWorkerQueue(this.tasks);
		worker.setResultMap(this.results);
		for (int i = 0; i < workerCount; i++) {
			workers.put("Node : "+i+"", new Thread(worker));
		}
	}
	
	public void submit(Task task){
		this.tasks.add(task) ; 
	}
	
	public void execute(){
		for (Map.Entry<String, Thread> m : workers.entrySet()) {
			m.getValue().start(); 
		}
	}

	public boolean isCompleted() {
		for (Map.Entry<String, Thread> m : workers.entrySet()) {
			if(m.getValue().getState() != Thread.State.TERMINATED){
				return false ; 
			}
		}
		return true;
	}
	public int getResults() {
		Integer ret = 0 ; 
		for (Map.Entry<String, Object> m : results.entrySet()) {
			ret+= (Integer) m.getValue() ;
		}
		return ret ; 
	}
}
