package randomtest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.Timer;



public class Asd 
{
	static JFrame jfrm;
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JTextField textField_4;
	private static JTextField textField_5;
	
	private static JProgressBar progressBar;
	private static JProgressBar progressBar_1;
	private static JProgressBar progressBar_2;
	private static JProgressBar progressBar_3;
	private static JProgressBar progressBar_4;
	private static JProgressBar progressBar_5;
	static Random r = new Random();
	static int i;
	static int n=0;
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void main(String args[])
	{
		
		jfrm = new JFrame();
		jfrm.setResizable(false);
		jfrm.setSize(511,477);
		jfrm.getContentPane().setLayout(null);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(12, 61, 380, 31);
		jfrm.getContentPane().add(progressBar);
		
		progressBar_1 = new JProgressBar();
		progressBar_1.setBounds(12, 115, 380, 31);
		jfrm.getContentPane().add(progressBar_1);
		
		progressBar_2 = new JProgressBar();
		progressBar_2.setBounds(12, 178, 380, 31);
		jfrm.getContentPane().add(progressBar_2);
		
		progressBar_3 = new JProgressBar();
		progressBar_3.setBounds(12, 254, 380, 31);
		jfrm.getContentPane().add(progressBar_3);
		
		progressBar_4 = new JProgressBar();
		progressBar_4.setBounds(12, 310, 380, 31);
		jfrm.getContentPane().add(progressBar_4);
		
		progressBar_5 = new JProgressBar();
		progressBar_5.setBounds(12, 375, 380, 31);
		jfrm.getContentPane().add(progressBar_5);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(404, 61, 89, 31);
		jfrm.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText("0");
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(404, 115, 89, 31);
		jfrm.getContentPane().add(textField_1);
		textField_1.setText("0");
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(404, 178, 89, 31);
		jfrm.getContentPane().add(textField_2);
		textField_2.setText("0");
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(404, 254, 89, 31);
		jfrm.getContentPane().add(textField_3);
		textField_3.setText("0");
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(404, 310, 89, 31);
		jfrm.getContentPane().add(textField_4);
		textField_4.setText("0");
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(404, 375, 89, 31);
		textField_5.setText("0");
		jfrm.getContentPane().add(textField_5);
		jfrm.setVisible(true);
		
		
		
		ActionListener lis = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				i= r.nextInt(6);
				n++;
				if(i==0)
				{
				
					textField.setText(Integer.toString(Integer.valueOf(textField.getText())+1));	
				}
					progressBar.setValue(100*Integer.valueOf(textField.getText())/n);
				
				if(i==1)
				{
					
					textField_1.setText(Integer.toString(Integer.valueOf(textField_1.getText())+1));	
				}
					progressBar_1.setValue(100*Integer.valueOf(textField_1.getText())/n);
				
				if(i==2)
				{
					
					textField_2.setText(Integer.toString(Integer.valueOf(textField_2.getText())+1));	
				}
					progressBar_2.setValue(100*Integer.valueOf(textField_2.getText())/n);
				
				if(i==3)
				{
				
					textField_3.setText(Integer.toString(Integer.valueOf(textField_3.getText())+1));
				}
					progressBar_3.setValue(100*Integer.valueOf(textField_3.getText())/n);
				
				if(i==4)
				{
					
					textField_4.setText(Integer.toString(Integer.valueOf(textField_4.getText())+1));	
				}
					progressBar_4.setValue(100*Integer.valueOf(textField_4.getText())/n);
				
				if(i==5)
				{
					
					textField_5.setText(Integer.toString(Integer.valueOf(textField_5.getText())+1));
				}
					progressBar_5.setValue(100*Integer.valueOf(textField_5.getText())/n);
				

				
				
				
				
			}		
		};
		Timer t = new Timer(10, lis);
		t.start();
		
	}
}
