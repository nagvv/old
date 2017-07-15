package pack1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Cam extends JPanel implements MouseMotionListener
{
	private static final long serialVersionUID = 1L;
	
	data d = General.d;
	String status="";
	double edsize = 1;
	Cam c = this;
	
	Cam()
	{
		this.addMouseMotionListener(this);
		
		ActionListener lis = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int min;
				if(c.getWidth()<c.getHeight())
				{
					min=c.getWidth();
				}
				else
				{
					min=c.getHeight();

				}
				edsize=(double)min/(d.mapSize+d.obsize*2);				

				if(General.d.player.health>0)
				{
					status = Integer.toString(General.d.player.health);
				}
				else
				{
					status = "died";
				}
				repaint();
			}		
		};
		Timer t = new Timer(1000/60, lis);
		t.start();
		
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawRect((int)(c.getWidth()-(d.mapSize*edsize))/2, (int)(d.obsize*edsize), (int)(d.mapSize*edsize), (int)(d.mapSize*edsize));


		for(int i=0 ;i<d.kolvoentity ; i++)
		{
			if(d.arr[i].isLife)
			{
				g.drawRect((int)(c.getWidth()-(d.mapSize*edsize))/2+(int)(d.arr[i].x*edsize), (int)(d.arr[i].y*edsize), (int)(d.playerSize*edsize), (int)(d.playerSize*edsize));
			}
		}
		g.setColor(Color.red);
		if(d.player.isLife)
		{
			g.drawRect((int)(c.getWidth()-(d.mapSize*edsize))/2+(int)(d.player.x*edsize), (int)(d.player.y*edsize), (int)(d.playerSize*edsize),(int) (d.playerSize*edsize));
		}
		
		g.drawString(status, (int)(c.getWidth()-(d.mapSize*edsize))/2+(int)(d.player.x*edsize), (int)((d.player.y-d.playerSize/2)*edsize));
		g.drawString(Integer.toString(General.d.time), (int)(d.player.x*edsize), (int)((d.player.y+d.playerSize*2)*edsize));
		
		
	}
	
	public void mouseDragged(MouseEvent e) 
	{
		d.mouseX = (e.getX()-d.playerSize*edsize/2)/edsize;
		d.mouseY = (e.getY()-d.playerSize*edsize/2)/edsize;
	}

	public void mouseMoved(MouseEvent e) 
	{
		d.mouseX = (e.getX()-d.playerSize*edsize/2)/edsize;
		d.mouseY = (e.getY()-d.playerSize*edsize/2)/edsize;
	}	
}
