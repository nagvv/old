package pack1;

public class data 
{
	
	Player player = new Player();
	double mouseX=0, mouseY=0;	
	int playerSize =10,mapSize=500,obsize=10,kolvoentity=2500,time=0;
	boolean playing = false;
	
	Entity arr[] = new Entity[kolvoentity];
	data()
	{
		{
			for(int i=0 ;i<kolvoentity ; i++)		
			{
				arr[i] = new Entity();
			}
		}
	}
}
