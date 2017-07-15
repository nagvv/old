package Chat;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Actions 
{
	protected ActionListener exitListener;
	protected ActionListener open;
	protected MouseAdapter mouseAdapter;
	protected WindowAdapter windowIconifed;
	protected ActionListener send;
	protected PInformer pinf;
	protected ActionListener ping;
	private Clip c;
	
	
	Actions()
	{
		send = new ActionListener()
        {	 
			public void actionPerformed(ActionEvent ае) 
			{
				if(MainClass.sender.jtf.getText().length() == 0)
				{
					MainClass.chat.error("null");
				}
				else 
				{
					MainClass.client.Send("say"+MainClass.sender.jtf.getText(),MainClass.sender.ip.getText());
					MainClass.sender.jtf.setText("");
				}
			}
        };	
        
        ping = new ActionListener()
        {	 
			public void actionPerformed(ActionEvent ае) 
			{
				MainClass.client.Send("ping",MainClass.sender.ip.getText());
			}
        };	
		
		
		exitListener = new ActionListener()
        {	 
            public void actionPerformed(ActionEvent e) 
            {
            	MainClass.frame.tray.remove(MainClass.frame.trayIcon);
                System.exit(0);
            }
        };	
        
        open = new ActionListener() 
        {

            public void actionPerformed(ActionEvent e)
            {           
            	MainClass.frame.jfrm.setVisible(true);
            }
        };	
        
        mouseAdapter = new MouseAdapter()
        {
            public void mouseReleased(MouseEvent e)
            {
                if (e.isPopupTrigger()) 
                {
                	MainClass.frame.popup.setLocation(e.getX(), e.getY());
                	MainClass.frame.popup.setInvoker(MainClass.frame.popup);
                	MainClass.frame.popup.setVisible(true);
                }
            }
        };
        
        windowIconifed = new WindowAdapter()
		{
			public void windowIconified(WindowEvent e) 
            {
                MainClass.frame.jfrm.setVisible(false);
            }
        };
	}
	
    
    void chmsg(int i, String s) 
    {
    	if(pinf != null)
    	{
    		pinf.setVisible(false);
    	}
    	try 
		{
			c = AudioSystem.getClip();
			AudioInputStream ais;
			ais = AudioSystem.getAudioInputStream(MainClass.class.getResource("newMsg.wav"));
			c.open(ais);
			c.loop(0);;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}				
    	pinf = new PInformer(s);
    	new Thread()
    	{
    		public void run()
    		{
    			try 
    			{
					sleep(5000);
					pinf.setVisible(false);
				}
    			catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
    		}
    	}.start();
    }

}
