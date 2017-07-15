public class Sort1 
{
	int size;
	int prm, srv;
	Thread t;
	int[][] b;
	Sort1()
	{
		t = General.th;
	}
	
	int[] SortThis(int size, int[][] m)
	{
		prm=0;
		srv=0;
		this.size=size;
		b = new int[size][3];
		int j,t,i;	
		for(i=0; i<size; i++)	
			b[i][2]=100;
		put(b[0],m[0]);
		
		for(i=1; i<size; i++)
		{
			j=i;
			while(j>=1 && equal(b[j-1],m[i]))
				j=j-1;
			for(t=i; t>j; t--)			
				put(b[t] ,b[t-1]);

			put(b[j],m[i]);	
		}
		put(m,b);	
	
		return new int[]{prm,srv};
	}
	
	void SortThisDebug(int size, int[][] m)
	{
		
		General.sort1.size=size;
		b = new int[size][3];
		int j,t,i;	
		for(i=0; i<size; i++)	
			b[i][2]=100;
		putd(b[0],m[0]);
		
		for(i=1; i<size; i++)
		{
			j=i;
			while(j>=1 && equal(b[j-1],m[i]))
				j=j-1;
			for(t=i; t>j; t--)	
			{
				putd(b[t] ,b[t-1]);
			}
		
			putd(b[j],m[i]);	
		}
		putd(m,b);	
			
		General.ts.end();
		
	
	}
	

	void put(int[] a, int[] e) 
	{
		for(int i=0;i<3;i++)
			a[i]=e[i];
		prm++;
	}
	void put(int[][] a, int[][] e) 
	{
		for(int i=0;i<size;i++)
			put(a[i],e[i]);
		
	}

	void putd(int[] a, int[] e) 
	{
		for(int i=0;i<3;i++)
			a[i]=e[i];
		prm++;
		General.cont = false;
		while(!General.cont)
		{
			try {
				t.sleep(10);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	void putd(int[][] a, int[][] e) 
	{
		for(int i=0;i<size;i++)
			putd(a[i],e[i]);
		
	}
	boolean equal(int[] a,int[] b)
	{
		srv++;
		if(a[2]==b[2])
			if(a[1]==b[1])
				return a[0]>=b[0];
			else
				return a[1]>b[1];
		else
			return a[2]>b[2];	
	}


}
