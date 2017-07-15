package Chat;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.UIManager;
import java.awt.Dimension;

public class PInformer extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	
	public PInformer(String text) 
	{
		setLocation(Toolkit.getDefaultToolkit().getScreenSize().width-150,10);
		setFocusCycleRoot(false);
		setFocusTraversalKeysEnabled(false);
		setFocusableWindowState(false);
		setFocusable(false);
		setUndecorated(true);
		setAlwaysOnTop(true);
		setSize(new Dimension(140, 60));
		getContentPane().setBackground(SystemColor.activeCaption);
		textField = new JTextField();
		textField.setAutoscrolls(false);
		textField.setFocusable(false);
		if(text.length() <= 10)
		{
			textField.setText(text);
		}
		else
		{
			textField.setText(text.substring(0,9)+"...");
		}
		textField.setBorder(UIManager.getBorder("InternalFrame.border"));
		textField.setEditable(false);
		textField.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));		
		textField.setBackground(SystemColor.activeCaption);
		getContentPane().add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);	
		setVisible(true);
	}
}
