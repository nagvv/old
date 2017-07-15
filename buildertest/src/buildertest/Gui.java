package buildertest;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Gui extends JFrame
{
	private static final long serialVersionUID = 322671386016207709L;
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	
	Gui()
	{
		setTitle("\u0420\u0435\u0448\u0430\u0442\u0435\u043B\u044C \u0441\u0443\u0434\u043E\u043A\u0443 9\u04459");
		setSize(305,498);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JButton button = new JButton("–ешить");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				for(int i=0;i<9;i++)
					for(int o=0;o<9;o++)
					{
						if(table.getValueAt(i, o)==null)
							Gnrl.resh[i][o]=0;
						else
							Gnrl.resh[i][o]= (int) table.getValueAt(i, o);
					}
				Gnrl.reshit();
				for(int i=0;i<9;i++)
					for(int o=0;o<9;o++)
						table_1.setValueAt(Gnrl.resh[i][o], i, o);
				textField.setText("ѕустых €чеек осталось: "+Gnrl.nuli+". ¬сего заполнено €чеек: "+Gnrl.n+".");
			}
		});
		getContentPane().add(button, BorderLayout.SOUTH);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) 
			{
				if(e.getKeyChar()>='0' && e.getKeyChar()<='9')
					table.setValueAt(null, table.getSelectedRow(), table.getSelectedColumn());
			}
		});

		table.setRowHeight(20);
		table.setModel(new DefaultTableModel(
			new Integer[][] {
				{6,0,2, 7,5,8, 0,0,0},
				  {0,8,0, 0,1,0, 9,6,0},
				  {0,0,0, 0,0,0, 0,0,0},
				  
				  {0,0,0, 0,3,9, 0,0,0},
				  {8,4,6, 0,0,0, 0,0,5},
				  {0,3,9, 8,0,6, 0,0,0},
				  
				  {0,0,0, 9,8,0, 6,0,0},
				  {0,5,8, 1,0,0, 0,0,0},
				  {9,0,0, 3,0,0, 8,4,1},
			},
			new String[] {
					"", "", "", "", "", "", "", "", ""
			}
		) {
		
			private static final long serialVersionUID = -147317972016780794L;
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		getContentPane().add(table, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		table_1 = new JTable();
		table_1.setEnabled(false);
		table_1.setModel(new DefaultTableModel(
			new Integer[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"", "", "", "", "", "", "", "", ""
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_1.setRowHeight(20);
		panel.add(table_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		panel.add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u0421\u0432\u0435\u0440\u0445\u0443 - \u0423\u0441\u043B\u043E\u0432\u0438\u0435. \u0421\u043D\u0438\u0437\u0443 \u0431\u0443\u0434\u0435\u0442 \u0440\u0435\u0448\u0435\u043D\u0438\u0435");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(label, BorderLayout.NORTH);
		setVisible(true);
	}
}
