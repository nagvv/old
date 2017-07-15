package pack1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.Random;
import javax.swing.Timer;

public class Control 
{	
	Random rand = new Random();
	
	void attack(int i)
	{
		General.d.player.health-=i;
	}
	
	void spawn(int id, int posX, int posY)
	{
		if(General.d.arr[id].isLife == false)
		{
			General.d.arr[id].x = posX;
			General.d.arr[id].y = posY;
			General.d.arr[id].isLife = true;
		}
	}
	
	void die(int id)
	{
		General.d.arr[id].isLife = false;
	}

	void starGame() 
	{

		General.d.player.isLife = false;
		for(int i=0; i<General.d.kolvoentity; i++)
		{
			General.d.arr[i].isLife = false;
		}
		
		
		General.d.player.isLife = true;
		General.d.player.health = 100;
		General.d.time = 0;
		General.d.playing = true;
		
		ActionListener lis = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				for(int i=0; i<General.d.kolvoentity; i++)
				{
					if(General.d.arr[i].isLife == false)
					{
						spawn(i, General.d.obsize+rand.nextInt(General.d.mapSize+General.d.obsize-General.d.playerSize),General.d.obsize+rand.nextInt(General.d.mapSize+General.d.obsize-General.d.playerSize));
						break;
					}
				}
			}		
		};
		Timer t = new Timer(200, lis);
		t.start();
		
		ActionListener lis2 = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(General.d.player.isLife)
				{
					General.d.time++;
				}
			}		
		};
		Timer t2 = new Timer(1000, lis2);
		t2.start();
	}
	
	void theEnd()
	{	
		if(General.d.playing)
		{
			new playerName();
			General.d.playing = false;
		}
	}
	
	void theEnd(String str)
	{
		try 
		{
			{				
				FileWriter fw = new FileWriter("stats.txt",true);
			     fw.append(System.getProperty("line.separator"));
			     if(str != "")
			     {
			    	 fw.write(Integer.toString(General.d.time)+" --- "+str);
			     }
			     else
			     {
			    	 fw.write(Integer.toString(General.d.time)+" --- Unknown");
			     }
				 
			     fw.close();
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}		
	}
}
