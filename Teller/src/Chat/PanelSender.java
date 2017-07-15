package Chat;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelSender extends JPanel
{

	protected JTextField jtf;
	protected JTextField ip;
	private JButton jb;

	private static final long serialVersionUID = 1L;
	private JButton pingbtn;
	private JLabel textlabel;
	private JTextField myip;
	
	InetAddress local;

	PanelSender()
	{
			GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.columnWidths = new int[]{25, 10, 5, 78, 98, 5, 0, 0};
			gridBagLayout.rowHeights = new int[]{5, 23, 0, 5, 0};
			gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			setLayout(gridBagLayout);
			jtf = new JTextField(40);
			jtf.addActionListener(MainClass.actions.send);
			GridBagConstraints gbc_jtf = new GridBagConstraints();
			gbc_jtf.anchor = GridBagConstraints.WEST;
			gbc_jtf.insets = new Insets(0, 0, 5, 5);
			gbc_jtf.gridwidth = 4;
			gbc_jtf.gridx = 1;
			gbc_jtf.gridy = 1;
			add(jtf, gbc_jtf);
			jb = new JButton("Œ ");
			jb.addActionListener(MainClass.actions.send);			
			GridBagConstraints gbc_jb = new GridBagConstraints();
			gbc_jb.anchor = GridBagConstraints.NORTHWEST;
			gbc_jb.insets = new Insets(0, 0, 5, 5);
			gbc_jb.gridx = 5;
			gbc_jb.gridy = 1;
			add(jb, gbc_jb);
			ip = new JTextField();
			ip.setColumns(12);
			GridBagConstraints gbc_ip = new GridBagConstraints();
			gbc_ip.anchor = GridBagConstraints.EAST;
			gbc_ip.insets = new Insets(0, 0, 5, 5);
			gbc_ip.gridx = 1;
			gbc_ip.gridy = 2;
			add(ip, gbc_ip);
			
			pingbtn = new JButton("Ping");
			pingbtn.addActionListener(MainClass.actions.ping);
			GridBagConstraints gbc_pingbtn = new GridBagConstraints();
			gbc_pingbtn.anchor = GridBagConstraints.NORTHWEST;
			gbc_pingbtn.insets = new Insets(0, 0, 5, 5);
			gbc_pingbtn.gridx = 2;
			gbc_pingbtn.gridy = 2;
			add(pingbtn, gbc_pingbtn);
			
			
			
			textlabel = new JLabel("\u0412\u0430\u0448 IP:");
			GridBagConstraints gbc_textlabel = new GridBagConstraints();
			gbc_textlabel.anchor = GridBagConstraints.EAST;
			gbc_textlabel.insets = new Insets(0, 0, 5, 5);
			gbc_textlabel.gridx = 3;
			gbc_textlabel.gridy = 2;
			add(textlabel, gbc_textlabel);
					
			try {
				local = InetAddress.getLocalHost();
			}
			catch (UnknownHostException e) 
			{				
				e.printStackTrace();
			}
			myip = new JTextField();
			myip.setFont(new Font("Consolas", Font.BOLD, 15));
			myip.setText(local.getHostAddress());
			myip.setEditable(false);
			GridBagConstraints gbc_myip = new GridBagConstraints();
			gbc_myip.gridwidth = 2;
			gbc_myip.insets = new Insets(0, 0, 5, 5);
			gbc_myip.fill = GridBagConstraints.HORIZONTAL;
			gbc_myip.gridx = 4;
			gbc_myip.gridy = 2;
			add(myip, gbc_myip);
			myip.setColumns(12);

	}

}
