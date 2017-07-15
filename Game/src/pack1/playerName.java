package pack1;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

public class playerName extends JDialog
{
	  private static final long serialVersionUID = 1L;
	  private JTextField txtPlayer;
	  
	  public playerName()
	  {
	  	setResizable(false);
		setLocation(200, 400);
	  	setVisible(true);
	  	setTitle("Ñ÷¸ò");
	  	setDefaultCloseOperation(HIDE_ON_CLOSE);
	  	getContentPane().setLayout(new BorderLayout(0, 0));
	  	
	  	txtPlayer = new JTextField();
	  	txtPlayer.setText("Player");
	  	getContentPane().add(txtPlayer);
	  	txtPlayer.setColumns(10);
	  	
	  	JButton btnOk = new JButton("OK");
	  	btnOk.setToolTipText("");
	  	btnOk.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	  	btnOk.addActionListener(new ActionListener()
	  	{
			public void actionPerformed(ActionEvent e) 
			{				
				setVisible(false);
				General.ct.theEnd(txtPlayer.getText());
				new Top();
			}  		
	  	});
	  	getContentPane().add(btnOk, BorderLayout.SOUTH);
	  	
	  	setSize(156,103);
	  }
}