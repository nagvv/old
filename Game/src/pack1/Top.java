package pack1;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;


public class Top extends JDialog 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Top() {
		
		setVisible(true);
		setTitle("Рекорды");
		setResizable(false);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setToolTipText("");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener()
	  	{
			public void actionPerformed(ActionEvent e) 
			{
				
				setVisible(false);
			} 		
	  	});
		getContentPane().add(btnNewButton, BorderLayout.SOUTH);
		String[] str = new String[100];

		try
		{
			FileReader fr = new FileReader("stats.txt");
			int i,t=0,y=0;
			char[] ch = new char[30];
			do
			{
				i = fr.read();
				if(i != -1 && i != 10 && i!=13)
				{
					ch[t] = (char)i;
					t++;
				}		
				
				if(i == 10 || i==-1)
				{
					
					str[y]=String.valueOf(ch);
					y+=1;
					t=0;
				}		
			}
			while(i != -1);
			fr.close();		
		} 
		catch (Exception e1)
		{
			str[0]="Не удалось загрузить топ";
		}
		JList<String> list = new JList<String>();
		list.setListData(str);
		getContentPane().add(list, BorderLayout.CENTER);
		setSize(new Dimension(270, 390));
	}

}
