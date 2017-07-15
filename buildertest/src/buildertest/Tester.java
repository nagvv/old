package buildertest;

public class Tester 
{
	
	boolean proverka(int[][] resh)
	{
		boolean norm = true;
		//проверка строк
		for (int t = 0; t < 9; ++t)
			for (int y = 0; y < 8; ++y)
				for (int u = y+1; u < 9; ++u)
					if(resh[t][y]==resh[t][u] && resh[t][y]!=0 )
					{
						norm=false;
						//System.out.println(resh[t][y] + " 1 " + resh[t][u]);
					}
		
		//проверка столбцов
		if(norm)
		for (int t = 0; t < 9; ++t)
			for (int y = 0; y < 8; ++y)
				for (int u = y+1; u < 9; ++u)
					if(resh[y][t]==resh[u][t] && resh[y][t]!=0)
					{
						norm =false;
						//System.out.println(resh[y][t] + " 2 " + resh[u][t]);
					}
		//проверка цекторов
		if(norm)
		for	(int q = 0; q < 7; q+=3)
			for(int w = 0; w < 7; w+=3)
				for (int t = q; t < q+3; ++t)
					for (int y = w; y < w+3; ++y)
						for (int u = q; u < q+3; ++u)
							for (int i = w; i < w+3; ++i)
								if(resh[t][y]==resh[u][i] && (t!=u || y!=i)  && resh[t][y]!=0)
								{
									norm =false;
									//System.out.println(resh[t][y] + " 3 " + resh[u][i]);
								}
		return norm;
	}
	
	int test1(int[][] resh, int[][] var, int nuli)
	{
		int n=0;
		for(int i=0;i<nuli;i++)
		{
			
			int temp =0;
			int kolvo =0;
			for(int t=1;t<10;t++)
			{
				resh[var[i][0]][var[i][1]]=t;
				if(proverka(resh))
				{
					++kolvo;
					temp = t;
				}
			}
			//System.out.print(kolvo + " ");
			
			if(kolvo==1)
			{
				resh[var[i][0]][var[i][1]] = temp;
				n++;
			}
			else
				resh[var[i][0]][var[i][1]] = 0;

			
		}
		return n;
	}
	
	int test2(int[][] resh)
	{
		int n =0;
		n+=test2stroki(resh);
		n+=test2stolbcu(resh);
		n+=test2sectora(resh);
		return n;
	}
	
	int test2sectora(int[][] resh)
	{
		int n=0;
		for	(int q = 0; q < 7; q+=3)
			for(int w = 0; w < 7; w+=3)
				for	(int t = 1; t < 10;++t)
				{
					boolean net=true;
					for (int a = q; a < q+3; ++a)
						for (int b = w; b < w+3; ++b)
							if(resh[a][b]==t)
								net=false;
					if(net)
					{
						int n1=0;
						int temp1=0;
						int temp2=0;
						for (int a = q; a < q+3; ++a)
							for (int b = w; b < w+3; ++b)
								if(resh[a][b]==0)
								{
									resh[a][b]=t;
									if(proverka(resh))
									{
										n1++;
										temp1=a;
										temp2=b;
									}
									resh[a][b]=0;	
								}
						if(n1==1)
						{
							resh[temp1][temp2]=t;
							n++;
						}
					}							
				}
		return n;
	}

	int test2stolbcu(int[][] resh) 
	{
		int n=0;		
		for(int s=0;s<9; ++s)
			for(int t =1; t<10; ++t)
			{
				boolean net=true;
				for(int i=0; i<9;++i)
					if(resh[i][s]==t)
						net=false;	
				
				
				
				if(net)
				{
					int n1=0;
					int temp=0;
					for(int i=0; i<9;++i)
					{
						if(resh[i][s]==0)
						{
							resh[i][s]=t;
							if(proverka(resh))
							{
								
								n1++;
								temp=i;
							}
							resh[i][s]=0;	
						}
					}

					if(n1==1)
					{
						
						resh[temp][s]=t;
						n++;
					}
				}
					
			}
				
					
		return n;
	}

	int test2stroki(int[][] resh)
	{
		int n=0;		
		for(int s=0;s<9; ++s)
			for(int t =1; t<10; ++t)
			{
				boolean net=true;
				for(int i=0; i<9;++i)
					if(resh[s][i]==t)
						net=false;	
				
				
				
				if(net)
				{
					int n1=0;
					int temp=0;
					for(int i=0; i<9;++i)
					{
						if(resh[s][i]==0)
						{
							resh[s][i]=t;
							if(proverka(resh))
							{
								n1++;
								temp=i;
							}
							resh[s][i]=0;	
						}
					}
					if(n1==1)
					{
						resh[s][temp]=t;
						n++;
					}
				}
					
			}
				
					
		return n;
	}
	
}
