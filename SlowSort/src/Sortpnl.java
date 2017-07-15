import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.BorderLayout;

public class Sortpnl extends JPanel
{
	General g;
	String[] str = {"el1","el2"};

	private static final long serialVersionUID = 1L;
	JTable table;
	
	public Sortpnl() 
	{
		setSize(new Dimension(594, 265));
		g.s = this;
		setAutoscrolls(true);
		setLayout(null);
		
		JButton button = new JButton("\u041D\u0430\u0437\u0430\u0434");
		button.setBounds(29, 203, 89, 23);
		
		button.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
               g.w.getContentPane().remove(g.s);
               g.w.getContentPane().add(g.w.pnl1);
               g.w.getContentPane().repaint();


            }
        });
		add(button);
		
		
		
		
		table = new JTable(2,6);
		table.setEnabled(false);
		table.setBackground(Color.WHITE);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setRowHeight(25);
		
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setRowSelectionAllowed(false);
		table.getTableHeader().setEnabled(false);	
		
		
		
		JScrollPane panel = new JScrollPane(table);
		panel.setBounds(29, 44, 532, 73);
		add(panel);
		
		
	}
}
