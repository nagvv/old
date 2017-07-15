import javax.swing.JPanel;
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ListSelectionModel;

public class Debugpnl extends JPanel
{
	
	MaskFormatter  form ;
	JList<String> list;
	DefaultListModel<String> lm;
	DefaultListModel<String> oldlm = new DefaultListModel<String>();;
	DefaultListModel<String> newlm = new DefaultListModel<String>();;
	JTextField ftf;
	JButton backbtn;
	JButton addbtn;
	JLabel num;
	JButton startbtn;
	JButton nextbtn;
	JLabel perem;
	JLabel srav;
	
	public Debugpnl() 
	{
		setSize(new Dimension(594, 265));
		try {
			form = new MaskFormatter("##.##.##");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		setLayout(null);
		
		ftf = new JTextField();
		ftf.setToolTipText("\u0414\u043B\u044F \u0432\u0432\u043E\u0434\u0430 \u043D\u0430\u0436\u043C\u0438 Enter");
		ftf.setBounds(30, 213, 77, 20);
		
		add(ftf);
		ftf.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				add();
			} });	
			
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 11, 77, 198);
		
		lm = new DefaultListModel<String>();
		list = new JList<String>(lm);
		scrollPane.setViewportView(list);
		
		add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(224, 11, 77, 198);
		add(scrollPane_1);
		
		JList old = new JList(oldlm);
		old.setEnabled(false);
		scrollPane_1.setViewportView(old);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(431, 11, 77, 198);
		add(scrollPane_2);
		
		JList news = new JList(newlm);
		news.setEnabled(false);
		scrollPane_2.setViewportView(news);
		
		nextbtn = new JButton("\u0421\u043B\u0435\u0434\u0443\u044E\u0449\u0438\u0439");
		nextbtn.setEnabled(false);
		nextbtn.setBounds(311, 163, 110, 46);
		nextbtn.addActionListener(new ActionListener()
		{
		
			public void actionPerformed(ActionEvent e) 
			{
				General.ts.step();
				
			}
		});
		add(nextbtn);
		
		startbtn = new JButton("Старт");
		startbtn.setBounds(117, 163, 97, 46);
		startbtn.addActionListener(new ActionListener()
		{
		
			public void actionPerformed(ActionEvent e) 
			{
				nextbtn.setEnabled(true);
				General.ts.ToSort(General.w.rbpv.isSelected(),lm.getSize(),true);
				General.dbpnl.srav.setText("0");
				General.dbpnl.perem.setText("0");
			}
		});
		add(startbtn);
		
		backbtn = new JButton("Назад");
		backbtn.setBounds(495, 231, 89, 23);
		backbtn.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) 
		{
			General.w.getContentPane().remove(General.dbpnl);
            General.w.getContentPane().add(General.w.pnl1);
            General.w.getContentPane().repaint();
		}
		});
		add(backbtn);
		
		JLabel label = new JLabel("\u0414\u0414.\u041C\u041C.\u0413\u0413");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(30, 234, 77, 20);
		add(label);
		
		JLabel lblNewLabel = new JLabel("\u0421\u0440\u0430\u0432\u043D\u0435\u043D\u0438\u0439:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(311, 13, 77, 20);
		add(lblNewLabel);
		
		srav = new JLabel("0");
		srav.setFont(new Font("Tahoma", Font.PLAIN, 14));
		srav.setBounds(386, 12, 35, 22);
		add(srav);
		
		JLabel label_1 = new JLabel("\u041F\u0435\u0440\u0435\u043C.:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(311, 44, 60, 20);
		add(label_1);
		
		perem = new JLabel("0");
		perem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		perem.setBounds(363, 44, 45, 20);
		add(perem);
		
		JLabel lblNewLabel_3 = new JLabel("\u041A\u043E\u043B-\u0432\u043E \u044D\u043B\u0435\u043C.:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(117, 18, 97, 23);
		add(lblNewLabel_3);
		
		num = new JLabel("0");
		num.setFont(new Font("Tahoma", Font.PLAIN, 14));
		num.setBounds(117, 44, 60, 20);
		add(num);
		
		addbtn = new JButton("Добавить");
		addbtn.setBounds(117, 212, 97, 23);
		
		addbtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				add();
			}
		});	
		add(addbtn);
		
		JButton button = new JButton("\u041E\u0447\u0438\u0441\u0442\u0438\u0442\u044C");
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				lm.clear();
				num.setText(Integer.toString(lm.size()));
			}
		});
		button.setBounds(117, 75, 97, 29);
		add(button);
		
		repaint();
	}
	
	void add()
	{
		if(ftf.getText().length() != 0)
		{
			boolean bl =true;
			int[] b = new int[3];
			char[] a;
			a = ftf.getText().toCharArray();
			int t=0;
			for(int i=0;i<ftf.getText().length();i++)
			{
				if(a[i]=='.')
				{				
					try
					{
						b[(t>0)? 1 : 0]=Integer.valueOf(String.copyValueOf(a, t, i-t));
					}
					catch(NumberFormatException e)
					{
						JOptionPane.showMessageDialog(General.w, "Допустимы только числа(дд.мм.гг)","Введены буквы", JOptionPane.WARNING_MESSAGE);
						bl=false;
					}
					t=i+1;
				}				
			}
			try
			{
				b[2]=Integer.valueOf(String.copyValueOf(a, t, ftf.getText().length()-t));			
			}
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(General.w, "Допустимы только числа(дд.мм.гг)","Введены буквы", JOptionPane.WARNING_MESSAGE);
				bl=false;
				
			}
			if(b[0]<=31 && b[1]<=12 && b[2]<=99 && b[0]>0 && b[1]>0 && b[2]>=0 && bl)
			{
				lm.addElement(ftf.getText());
				num.setText(Integer.toString(lm.size()));
			}
			else
			{
				JOptionPane.showMessageDialog(General.w, "Неверный формат(дд.мм.гг)","Неверный формат", JOptionPane.WARNING_MESSAGE);
			}
			
		}
		ftf.setText(null);
	}
}
