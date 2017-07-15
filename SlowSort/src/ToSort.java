import java.util.Random;

import javax.swing.table.DefaultTableModel;

public class ToSort 
{

	Random r = new Random();
	static int[][] m;
	int[][] s = new int[6][2];
	int i,j;
	
	ToSort()
	{
		
	}
	
	public void ToSort(boolean ispv, int size)
	{
		m =new int[size][3];
		for(i=0; i<size; i++)
		{
			m[i][0]=r.nextInt(30)+1;
			m[i][1]=r.nextInt(12)+1;
			m[i][2]=r.nextInt(100);
		}
		General.cont=true;
		if(ispv)
		{
			int[] t= new int[3];	  
			s[3] = General.sort1.SortThis(size,m);
		  	  
			s[0] = General.sort1.SortThis(size,m);

			for(i=0;i<size/2;i++)
			{
				t= m[i];
			 	m[i]=m[size-i-1];
			 	m[size-i-1]=t;
			}
			s[1] = General.sort1.SortThis(size,m);
			  
			for(i=0;i<size/4;i++)
			{
				t= m[2*i+1];
				m[2*i+1]=m[(size/2)*2-1-2*i];
				m[(size/2)*2-1-2*i]=t;
			}
			s[2] = General.sort1.SortThis(size,m);
			  
			for(i=0; i<size; i++)
			{
				m[i][0]=r.nextInt(30)+1;
				m[i][1]=r.nextInt(12)+1;
				m[i][2]=r.nextInt(100);
			}
			s[4] = General.sort1.SortThis(size,m);
			
			s[5][0]=(s[0][0]+s[1][0]+s[2][0]+s[3][0]+s[4][0])/5;
			s[5][1]=(s[0][1]+s[1][1]+s[2][1]+s[3][1]+s[4][1])/5;
			
			General.s.table.setModel(new DefaultTableModel(
			new Object[][] {
				{"перемещений", s[0][0], s[1][0], s[2][0], s[3][0], s[4][0] ,s[5][0]},
				{"сравнений", s[0][1], s[1][1], s[2][1], s[3][1], s[4][1], s[5][1]},
			},
			new String[] {
				"", "1", "2", "3", "4", "5", "средняя"
			}
			
			));
			
		}
		else
		{
		
			int[] t= new int[3];	  
			s[3] = General.sort2.SortThis(size,m);
		  	  
			s[0] = General.sort2.SortThis(size,m);

			for(i=0;i<size/2;i++)
			{
				t= m[i];
			 	m[i]=m[size-i-1];
			 	m[size-i-1]=t;
			}
			s[1] = General.sort2.SortThis(size,m);
			  
			for(i=0;i<size/4;i++)
			{
				t= m[2*i+1];
				m[2*i+1]=m[(size/2)*2-1-2*i];
				m[(size/2)*2-1-2*i]=t;
			}
			s[2] = General.sort2.SortThis(size,m);
			  
			for(i=0; i<size; i++)
			{
				m[i][0]=r.nextInt(30)+1;
				m[i][1]=r.nextInt(12)+1;
				m[i][2]=r.nextInt(100);
			}
			s[4] = General.sort2.SortThis(size,m);
			
			s[5][0]=(s[0][0]+s[1][0]+s[2][0]+s[3][0]+s[4][0])/5;
			s[5][1]=(s[0][1]+s[1][1]+s[2][1]+s[3][1]+s[4][1])/5;
			
			General.s.table.setModel(new DefaultTableModel(
			new Object[][] {
				{"перемещений", s[0][0], s[1][0], s[2][0], s[3][0], s[4][0] ,s[5][0]},
				{"сравнений", s[0][1], s[1][1], s[2][1], s[3][1], s[4][1], s[5][1]},
			},
			new String[] {
				"", "1", "2", "3", "4", "5", "средняя"
			}
			
			));
		}
	}
	public void ToSort(boolean ispv, final int size, boolean isotl)
	{
		m =new int[size][3];
		for(i=0; i<size; i++)
		{
			char[] s = General.dbpnl.lm.getElementAt(i).toCharArray();
			int t=0;
			int k=0;
			for(int j=0;j<s.length;j++)
			{
				
				if(s[j]=='.')
				{
					m[i][t]=Integer.valueOf(String.copyValueOf(s, k, j-k));
					t++;
					k=j+1;
				}
				
			}
			m[i][2] = Integer.valueOf(String.copyValueOf(s, k, s.length-k));
		}
		
		if(ispv)
		{
			General.dbpnl.newlm.clear();
			General.dbpnl.oldlm.clear();
			for(int i=0;i<size;i++)
			{
				General.dbpnl.newlm.addElement(0+"."+0+"."+0);
			}
			General.cont=false;
			new Thread()
			{
				public void run()
				{
					
					General.sort1.SortThisDebug(size, m);
				}
			}.start();
			
			
		}
		else
		{
			General.dbpnl.newlm.clear();
			General.dbpnl.oldlm.clear();
			for(int i=0;i<size;i++)
			{
				General.dbpnl.newlm.addElement(0+"."+0+"."+0);
			}
			General.cont=false;
			new Thread()
			{
				public void run()
				{
					
					General.sort2.SortThisDebug(size, m);
				}
			}.start();
		}
	}

	public void step() 
	{
		General.cont=true;
		General.dbpnl.oldlm.clear();
		for(int j=0;j<General.dbpnl.newlm.getSize();j++)
				General.dbpnl.oldlm.addElement(General.dbpnl.newlm.getElementAt(j));
		General.dbpnl.newlm.clear();
		
		if(General.w.rbpv.isSelected())
		{
			for(int j=0;j<General.dbpnl.oldlm.getSize();j++)
				General.dbpnl.newlm.addElement(General.sort1.b[j][0]+"."+General.sort1.b[j][1]+"."+General.sort1.b[j][2]);
			General.dbpnl.srav.setText(General.sort1.srv+"");
			General.dbpnl.perem.setText(General.sort1.prm+"");
		}
		else
		{
			for(int j=0;j<General.dbpnl.oldlm.getSize();j++)
				General.dbpnl.newlm.addElement(General.sort2.d[j][0]+"."+General.sort2.d[j][1]+"."+General.sort2.d[j][2]);
			General.dbpnl.srav.setText(General.sort2.srv+"");
			General.dbpnl.perem.setText(General.sort2.prm+"");
		}
	}
	
	public void end()
	{
		step();
		General.dbpnl.nextbtn.setEnabled(false);
		
	}
	
}

