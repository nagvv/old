package Chat;

import java.awt.BorderLayout;
import java.awt.Font;
import java.net.InetAddress;
import java.util.Calendar;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class PanelChat extends JPanel
{
	Actions act =  MainClass.actions;
	private static final long serialVersionUID = 1L;
    String hour,minute,second;
    
	JTextArea jta;

	public void get(String str, InetAddress ia)
	{		
		if(str.startsWith("say"))
		{
			add(str.substring(3), ia);
		}
		else if(str.startsWith("ping"))
		{
			MainClass.client.Send("ok", ia.toString().substring(1));
		}	
		else if(str.startsWith("ok"))
		{
			add("отвечает", ia);
		}	
	}
	public void get(String str, String ip)
	{		
		if(str.startsWith("say"))
		{
			add(str.substring(3), ip);
		}
	}
	
	public void add(String str, String ip)
	{
		Calendar time = Calendar.getInstance();

	    if(time.get(Calendar.HOUR_OF_DAY)<10)
	    {
	    	hour = "0"+time.get(Calendar.HOUR_OF_DAY);
	    }
	    else
	    {
	    	hour = ""+time.get(Calendar.HOUR_OF_DAY);
	    }
	    
	    if(time.get(Calendar.MINUTE)<10)
	    {
	    	minute = "0"+time.get(Calendar.MINUTE);
	    }
	    else
	    {
	    	minute = ""+time.get(Calendar.MINUTE);
	    }
	    
	    if(time.get(Calendar.SECOND)<10)
	    {
	    	second = "0"+time.get(Calendar.SECOND);
	    }
	    else
	    {
	    	second = ""+time.get(Calendar.SECOND);
	    }
	    
	    String clock = "-"+hour+":"+minute+":"+second+"- ";
	    
		jta.setText(jta.getText() + "\n" +  clock + str +"   >>> "+ip);

	}
	
	public void add(String str, InetAddress ia)
	{
		Calendar time = Calendar.getInstance();

	    if(time.get(Calendar.HOUR_OF_DAY)<10)
	    {
	    	hour = "0"+time.get(Calendar.HOUR_OF_DAY);
	    }
	    else
	    {
	    	hour = ""+time.get(Calendar.HOUR_OF_DAY);
	    }
	    
	    if(time.get(Calendar.MINUTE)<10)
	    {
	    	minute = "0"+time.get(Calendar.MINUTE);
	    }
	    else
	    {
	    	minute = ""+time.get(Calendar.MINUTE);
	    }
	    
	    if(time.get(Calendar.SECOND)<10)
	    {
	    	second = "0"+time.get(Calendar.SECOND);
	    }
	    else
	    {
	    	second = ""+time.get(Calendar.SECOND);
	    }
	    
	    String clock = "-"+hour+":"+minute+":"+second+"- ";
	    
		jta.setText(jta.getText() + "\n"  + clock +"("+ ia + ") >>>   " + str);
		act.chmsg(1, str);
		
	}
	
	public void error(String err)
	{
		if(err == "null")
		{
			jta.setText(jta.getText() + "\n ***Введите текст***");
		}
		else if(err == "server")
		{
			jta.setText(jta.getText() + "\n ***Не удалось подключиться***");		
		}
		else if(err == "port")
		{
			jta.setText(jta.getText() + "\n ***Порт занят***");
		}
		else
		{
			jta.setText(jta.getText() + "\n ***Ошибка***");
		}
	}
	
	
	PanelChat()
	{
		setLayout(new BorderLayout());
		jta = new JTextArea();
		jta.setFont(new Font("Arial Unicode MS", Font.BOLD, 12));
		jta.setEditable(false);
		jta.setWrapStyleWord(true);
		add(jta);		 
		jta.setText("Welcome");
	}
}
