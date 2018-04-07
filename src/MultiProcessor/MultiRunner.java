package MultiProcessor;

import com.doktorlar.VeriKopyala;

public class MultiRunner implements Runnable {
	
	private String db;
	int start,finish;
	public MultiRunner(String dbid,int start,int finish) {
		db=dbid;
		this.start=start;
		this.finish=finish;
	}
	
	@Override
	public void run() {
		
		try {
			VeriKopyala islemyap = new VeriKopyala();
			islemyap.islem(start, finish, db);
		} catch (Exception e) {
			// TODO: handle exception
		}

		
	}
	
	
	
}
