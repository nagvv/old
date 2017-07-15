package buildertest;

import java.awt.SystemColor;

public class Gnrl 
{
	static Tester test = new Tester();
	/*static int[][] sudoku =  {{6,0,2, 7,5,8, 0,0,0},
							  {0,8,0, 0,1,0, 9,6,0},
							  {0,0,0, 0,0,0, 0,0,0},
							  
							  {0,0,0, 0,3,9, 0,0,0},
							  {8,4,6, 0,0,0, 0,0,5},
							  {0,3,9, 8,0,6, 0,0,0},
							  
							  {0,0,0, 9,8,0, 6,0,0},
							  {0,5,8, 1,0,0, 0,0,0},
							  {9,0,0, 3,0,0, 8,4,1}};*/
	
	static int[][] sudoku =  {{4,0,6, 8,0,1, 0,3,2},
							  {1,0,0, 0,2,3, 6,0,9},
							  {0,2,7, 0,9,4, 0,0,0},
							  
							  {0,0,5, 0,8,2, 0,0,6},
							  {6,3,2, 0,0,0, 8,7,5},
							  {8,0,0, 5,7,0, 9,0,0},
							  
							  {0,0,0, 2,6,0, 1,9,0},
							  {2,0,9, 1,4,0, 0,0,7},
							  {7,6,0, 9,0,8, 2,0,4}};
	
	static int[][] resh = new int[9][9];	
	static int nuli =0;
	static int[][] var = new int [81][2];
	static int n=0;
	
	static void copy()
	{
		for (int t = 0; t < 9; ++t)
			for (int y = 0; y < 9; ++y)
				resh[t][y] = sudoku[t][y];
	}
	
	static void initVar()
	{
		int asd=0;
		for (int t = 0; t < 9; ++t)
			for (int y = 0; y < 9; ++y)
				if(resh[t][y]==0)
				{
					var[asd][0] = t;
					var[asd][1] = y;
					asd++;
				}
		nuli=asd;
	}
	static void reshit()
	{
		n=0;
		
		initVar();					
	
		{
			int n2;			
			do{
				n2=n;
				n+=test.test1(resh, var, nuli);
				n+=test.test2(resh);
				initVar();
			}while((n2-n)!=0);
		}

		initVar();
		System.out.println("ѕустых €чеек осталось: "+nuli+". ¬сего заполнено €чеек: "+n+".");
		for (int t = 0; t < 9; ++t)
		{
			for (int y = 0; y < 9; ++y)
			{
				System.out.print(resh[t][y]+" ");
				if(y==2||y==5)
					System.out.print("| ");
			}
			System.out.println();
			if(t==2||t==5)
			{
				for(int i=0;i<11;i++)
					System.out.print("--");
				System.out.println();
			}
		}
	}
	static Gui gui;
	public static void main(String[] args) 
	{
		copy();
		 gui = new Gui();
		reshit();
	}
}
