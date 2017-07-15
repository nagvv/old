package pack1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Entity 
{
	boolean isLife = false;
	double x=0,y=0;
	double speed = 1;
	
	Entity()
	{
		AI();
	}
	
	void AI()
	{
		ActionListener lis = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(isLife ==true)
				{
					if(x >= General.d.player.x-10 && x <=General.d.player.x+10 && y >= General.d.player.y-10 && y <=General.d.player.y+10 && General.d.player.isLife)
					{
						isLife = false;
						General.ct.attack(9);
					}
					
					for(int i=0;i<General.d.kolvoentity;i++)
					{
						if(x >= General.d.arr[i].x-General.d.playerSize && x <=General.d.arr[i].x+General.d.playerSize && y >= General.d.arr[i].y-General.d.playerSize && y <=General.d.arr[i].y+General.d.playerSize && General.d.arr[i].isLife)
						{
							double a,b;
							if(General.d.arr[i].y - y==0)
							{
								a=1;
								b=1.5;
							}
							else
							{
								a=Math.abs(General.d.arr[i].x-x)/Math.abs(General.d.arr[i].y-y);
								b=Math.sqrt((2.25)/(a*a+1));
							}
							
							if(General.d.arr[i].x>x)
							{
								x=x-b*a;
							}
							else if(General.d.arr[i].x < x)
							{
								x=x+b*a;
							}
							
							if(General.d.arr[i].y>y)
							{
								y=y-b;
							}
							else if(General.d.arr[i].y < y)
							{
								y=y+b;
							}
							
							
						}
					}
					
					double a,b;
					if(General.d.player.y - y==0)
					{
						a=1;
						b=speed;
					}
					else
					{
						a=Math.abs(General.d.player.x-x)/Math.abs(General.d.player.y-y);
						b=Math.sqrt((speed*speed)/(a*a+1));
					}
					

					
					if(Math.abs(General.d.player.x-x)<b*a)
					{
						x=General.d.player.x;
					}
					else if(General.d.player.x>x)
					{
						x=x+b*a;
					}
					else if(General.d.player.x < x)
					{
						x=x-b*a;
					}
					
					if(Math.abs(General.d.player.y-y)<b)
					{
						y=General.d.player.y;
					}
					else if(General.d.player.y>y)
					{
						y=y+b;
					}
					else if(General.d.player.y < y)
					{
						y=y-b;
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
