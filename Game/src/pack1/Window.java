package pack1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;



public class Window implements KeyListener
{
	Cam cam = new Cam();
	Control ct = General.ct;
	JFrame jfrm;
	ActionListener lis;
	JMenuBar menuBar;
	JMenu Menu;
	JMenuItem MenuItem;
	
	Window()
	{

		jfrm = new JFrame();

		jfrm.setTitle("Game test");
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setVisible(true);	
		menuBar = new JMenuBar();
		Menu = new JMenu("Игра");
		MenuItem = new JMenuItem("Старт");		
		jfrm.setJMenuBar(menuBar);		
		menuBar.add(Menu);		
		Menu.add(MenuItem);	
		MenuItem.addActionListener(lis = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ct.starGame();
			}			
		});
		jfrm.addKeyListener(this);
		jfrm.getContentPane().add(cam);
		jfrm.setSize(640,700);	
		
	}
	
	public void keyPressed(KeyEvent k)
	{
	    switch(k.getKeyCode())
	    {
	    case 32:
	    	General.d.player.moving = true;
	    	break;
	    }
	}

	public void keyReleased(KeyEvent k)
	{
	    switch(k.getKeyCode())
	    {
	    case 32:
	    	General.d.player.moving = false;
	    	break;
	    }
	  }

	  public void keyTyped(KeyEvent k)
	  {
	  }
}
