import java.io.IOException;

public class General 
{
	static Window w;
	static Sortpnl s;
	static Sort1 sort1;
	static Sort2 sort2;
	static Debugpnl dbpnl;
	static boolean cont;
	static ToSort ts;
	static  Thread th;
	

	
	public static void main(String[] args) throws IOException 
	{
		dbpnl = new Debugpnl();
		ts = new ToSort();
		System.out.println(Thread.currentThread().getName());
		
		th = new Thread()
		{
			public void run()
			{
					sort1 = new Sort1();
					sort2 = new Sort2();
			}
		};
		th.start();
		th.setName("new");
		w = new Window();
	}		
}
