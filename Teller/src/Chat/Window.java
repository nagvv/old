package Chat;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;


public class Window 
{
	protected TrayIcon trayIcon;
	protected JPopupMenu popup;
	protected SystemTray tray;
	private Image icon;
	JFrame jfrm;
	private JScrollPane jsp;
	Window() 
	{	
		jfrm = new JFrame("IPtell");
		jfrm.setVisible(true);
		jfrm.setSize(600, 500);
		jfrm.getContentPane().setLayout(new BorderLayout());
		jfrm.getContentPane().add(MainClass.sender, "South");		
		jfrm.setMinimumSize(new Dimension(580 , 150));	
		jsp = new JScrollPane(MainClass.chat);
		jfrm.getContentPane().add(jsp,"Center");
		
		try {
			icon = ImageIO.read(MainClass.class.getResource("icon.png"));
			jfrm.setIconImage(icon);
		} 
		catch (IOException e) 
		{
			
		}	
	
	 
	        if (SystemTray.isSupported()) 
	        {	 
	    		jfrm.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    		jfrm.addWindowListener(new WindowAdapter()
	    		{
	    			public void windowIconified(WindowEvent e) 
	                {
	                    jfrm.setVisible(false);
	                }
	            });
	        	
	            tray = SystemTray.getSystemTray();
	 
	            popup = new JPopupMenu();
	            JMenuItem exiter = new JMenuItem("Выход");
	            exiter.addActionListener(MainClass.actions.exitListener);
	            popup.add(exiter);
	 
	            trayIcon = new TrayIcon(icon, MainClass.version);	 	         
	            trayIcon.setImageAutoSize(true);
	            trayIcon.addActionListener(MainClass.actions.open);       
	            trayIcon.addMouseListener(MainClass.actions.mouseAdapter);
	 
	            try 
	            {
	                tray.add(trayIcon);
	            }
	            catch (AWTException e) 
	            {
	                System.err.println("Трея не добавлена.");
	            }
	        } 
	        else 
	        {
	        	jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        }
	}
}
