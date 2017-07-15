package pack1;

public class General 
{
	static Window w;
	static Cam c;	
	static data d;	
	static Control ct;

	public static void main(String[] args) 
	{		
		d = new data();
		ct = new Control();
		new Thread()
		{
			public void run()
			{
				w = new Window();
			}
		}.start();
	}
}
