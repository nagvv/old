import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Window extends JFrame
{
	JPanel pnl1;
	JRadioButton rbpv;
	JRadioButton rbes;
	ButtonGroup bg;
	JSlider slider;
	JCheckBox isotl;
	JButton startBtn;
	Debugpnl dbpnl = General.dbpnl;
	Sortpnl sortpnl = new Sortpnl();
	public Window() 
	{
		
			try {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
		setResizable(false);
		setSize(new Dimension(600, 294));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SlowSort v0.1");
		bg = new ButtonGroup();
		
		pnl1 = new JPanel();
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(pnl1);
		
		{
		textField = new JTextField();
		textField.setBounds(207, 23, 182, 32);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBorder(null);
		textField.setFocusable(false);
		textField.setEditable(false);
		textField.setText("Выберите тип сортировки");
		textField.setColumns(10);
		}
		pnl1.setLayout(null);
		pnl1.add(textField);
		rbpv = new JRadioButton("Простыми вставками",true);
		rbpv.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbpv.setBounds(133, 62, 143, 23);
		bg.add(rbpv);
		pnl1.add(rbpv);
		rbes = new JRadioButton("Естественным слиянием");
		rbes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbes.setBounds(298, 62, 167, 23);
		bg.add(rbes);
		pnl1.add(rbes);
		
		textField_1 = new JTextField();
		textField_1.setBounds(170, 92, 259, 23);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setText("Выберите длину последовательности");
		textField_1.setFocusable(false);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		pnl1.add(textField_1);
		
		slider = new JSlider();
		slider.setMinimum(1);
		slider.setBounds(57, 177, 486, 32);
		slider.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent e) 
			{
				txtAuto.setText(Integer.toString(slider.getValue()));
				if(slider.getValue()==slider.getMinimum())
					button.setEnabled(false);
				else
					button.setEnabled(true);
				if(slider.getValue()==slider.getMaximum())
					button_1.setEnabled(false);
				else
					button_1.setEnabled(true);
			}
			
		});
			
		
		pnl1.add(slider);
		
		startBtn = new JButton("Далее");
		startBtn.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e)
            {
            	if(isotl.isSelected())
            	{
            		getContentPane().remove(pnl1);
            		getContentPane().add(dbpnl);
            		repaint();
            		revalidate();
            	}
            	else
            	{
            		General.ts.ToSort(rbpv.isSelected(), slider.getValue());
            		getContentPane().remove(pnl1);
            		getContentPane().add(sortpnl);
            		repaint();
            	}

            }
        });
		startBtn.setBounds(296, 220, 107, 23);
		pnl1.add(startBtn);
		
		isotl = new JCheckBox("Режим отладки");
		isotl.setBounds(159, 220, 131, 23);
		pnl1.add(isotl);
		
		txtAuto = new JTextField();
		txtAuto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAuto.setText("50");
		txtAuto.setBorder(null);
		txtAuto.setEditable(false);
		txtAuto.setBounds(286, 156, 25, 20);
		pnl1.add(txtAuto);
		txtAuto.setColumns(10);
		
		JLabel label = new JLabel("100");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(549, 177, 35, 32);
		pnl1.add(label);
		
		JLabel label_1 = new JLabel("1");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(29, 177, 18, 32);
		pnl1.add(label_1);
		
		button = new JButton("-");
		button.setBounds(237, 155, 39, 23);
		button.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent e) 
			{
				slider.setValue(slider.getValue()-1);	
			}			
		});
		pnl1.add(button);
		
		button_1 = new JButton("+");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				slider.setValue(slider.getValue()+1);
			}
		});
		button_1.setBounds(313, 155, 43, 23);
		pnl1.add(button_1);
		setVisible(true);
		
	}


	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtAuto;
	private JButton button;
	private JButton button_1;
}
