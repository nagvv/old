package pack1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Player 
{	
	boolean isLife = false, moving = false;
	double x=50,y=50, oldx=50,oldy=50, speed=3;
	int health = 0;
	
	Player()
	{
		ActionListener lis = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(health<=0)
				{
					isLife=false;
					General.ct.theEnd();
				}
				
				if(isLife ==true)
				{
					oldx=x;
					oldy=y;
					if(moving == true)
					{	
						
						
						double a,b;
						if(General.d.mouseY - y==0)
						{
							a=1;
							b=speed;
						}
						else
						{
							a=Math.abs(General.d.mouseX-x)/Math.abs(General.d.mouseY-y);
							b=Math.sqrt((speed*speed)/(a*a+1));
						}
						

						
						if(Math.abs(General.d.mouseX-x)<b*a)
						{
							x=General.d.mouseX;
						}
						else if(General.d.mouseX>x)
						{
							x=x+b*a;
						}
						else if(General.d.mouseX < x)
						{
							x=x-b*a;
						}
						
						if(Math.abs(General.d.mouseY-y)<b)
						{
							y=General.d.mouseY;
						}
						else if(General.d.mouseY>y)
						{
							y=y+b;
						}
						else if(General.d.mouseY < y)
						{
							y=y-b;
						}
					}
				}
				
				if(x<=General.d.obsize)
				{
					x=General.d.obsize;
				}
				if(y<=General.d.obsize)
				{
					y=General.d.obsize;
				}
				if(x>=General.d.obsize+General.d.mapSize-General.d.playerSize)
				{
					x=General.d.obsize+General.d.mapSize-General.d.playerSize;
				}
				if(y>=General.d.obsize+General.d.mapSize-General.d.playerSize)
				{
					y=General.d.obsize+General.d.mapSize-General.d.playerSize;
				}
			}		
		};
		Timer t = new Timer(1000/60, lis);
		t.start();
	}
}
