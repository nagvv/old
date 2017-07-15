package Chat;

import java.io.*;
import java.net.*;

public class Client
{	  		
	ServerSocket servers;
	
	Socket from;
	Socket to;
    
	String fserver;
	
	BufferedReader in;
	PrintWriter out;	

	Client()
	{
		new Thread()
		{
			public void run()
			{				
			    try 
			    {
			    	servers = new ServerSocket(1111);

			    	while(true)
			    	{
				    	from= servers.accept();
				    	in  = new BufferedReader(new InputStreamReader(from.getInputStream()));
				    	MainClass.chat.get(in.readLine() ,from.getInetAddress());
			    	}
			    } 
			    catch (IOException e) 
			    {
			    	MainClass.chat.error("port");
			    }	   
			}
		}.start();
	}
	
	public void Send(String text, String ip)
	{
		try
		{	
			to = new Socket(ip,1111);	
			out = new PrintWriter(to.getOutputStream(),true);
			out.println(text);	
			MainClass.chat.get(text,ip);			
		}
		catch(Exception e)
		{
			MainClass.chat.error("server");
		}
	}
	
	
}