import java.util.Arrays;

public class Sort2
{
	int size;
	int prm, srv;
	Thread t;
	int[][] d;
	Sort2()
	{
		t = General.th;
	}
	
	int[] SortThis(int size, int[][] m)
	{
		prm=0;
		srv=0;
		this.size=size;
		d =m;
		m = sortThiss(m);
		d=m;
		/*for(int i=0;i<size;i++)
			System.out.print(m[i][2] +" ");
		System.out.println("; 2");	*/

		return new int[]{prm,srv};
	}
	
	void SortThisDebug(int size, int[][] m)
	{
		prm=0;
		srv=0;
		this.size=size;
		d =m;
		m = sortThiss2(m);
		for(int i=0;i<size;i++)
			System.out.print(m[i][2] +" ");
		System.out.println("; 2");	
		d=m;
			
		General.ts.end();
	}
	
	int[][] sortThiss(int[][] m) 
	{
		
		int len = m.length;		
		if (len < 2) return m;
		int middle = len / 2;
		int[][] m1 = new int[middle][3],m2 = new int[len-middle][3];
		for(int i=0;i<middle;i++)
			put(m1[i],m[i]);
		for(int i=0;i<len-middle;i++)
			put(m2[i],m[i+middle]);
		System.out.println(middle+" "+len);
		return merge(sortThiss(m1),
		             sortThiss(m2));
	}
	
	int[][] merge(int[][] arr_1, int[][] arr_2) {
		int len_1 = arr_1.length, len_2 = arr_2.length;
		int a = 0, c = 0, len = len_1 + len_2; // a, b - счетчики в массивах
		int[][] b = new int[len][3];
		for (int i = 0; i < len; i++) 
		{
			srv++;
			if (c < len_2 && a < len_1) 
			{
				if (equal(arr_1[a],arr_2[c]))
					put(b[i],arr_2[c++]);
					
				else 
					put(b[i],arr_1[a++]);
			} 
			else if (c < len_2) 
			{
				put(b[i],arr_2[c++]);
			} 
			else 
			{
				put(b[i],arr_1[a++]);
			}
		}
		return b;
	}
	
	int[][] sortThiss2(int[][] m) 
	{
		
		int len = m.length;		
		if (len < 2) return m;
		int middle = len / 2;
		int[][] m1 = new int[middle][3],m2 = new int[len-middle][3];
		for(int i=0;i<middle;i++)
			put(m1[i],m[i]);
		for(int i=0;i<len-middle;i++)
			put(m2[i],m[i+middle]);
		return merge2(sortThiss2(m1),
		             sortThiss2(m2));
	}
	
	int[][] merge2(int[][] arr_1, int[][] arr_2) {
		int len_1 = arr_1.length, len_2 = arr_2.length;
		int a = 0, c = 0, len = len_1 + len_2; // a, b - счетчики в массивах
		int[][] b = new int[len][3];
		for (int i = 0; i < len; i++) 
		{
			srv++;
			if (c < len_2 && a < len_1) 
			{
				if (equal(arr_1[a],arr_2[c]))
					putd(b[i],arr_2[c++]);
					
				else 
					putd(b[i],arr_1[a++]);
			} 
			else if (c < len_2) 
			{
				putd(b[i],arr_2[c++]);
			} 
			else 
			{
				putd(b[i],arr_1[a++]);
			}
		}
		return b;
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