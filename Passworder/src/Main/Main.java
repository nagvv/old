package Main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.Scrollbar;
import java.awt.SystemColor;

public class Main 
{
	static JFrame jfrm;
	private static JButton btn;
	private static JTextField input;
	private static JTextField pass;
	private static JScrollPane scroll;
	//private static JScrollBar scroll;
	private static JTextPane info;
	public static void main(String arg[]) throws ParseException
	{
		
		jfrm = new JFrame("Генератор");
		jfrm.setResizable(false);
		jfrm.setLocationByPlatform(true);
		jfrm.setAlwaysOnTop(true);
		jfrm.setSize(380,400);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		input = new JTextField();
		input.setColumns(10);
		
		

		
		pass = new JTextField();
		pass.setToolTipText("");
		pass.setEditable(false);
		pass.setColumns(10);
		

		
		info = new JTextPane();
		info.setBackground(SystemColor.control);
		info.setDisabledTextColor(Color.RED);
		info.setFont(new Font("Tahoma", Font.PLAIN, 14));
		info.setEnabled(false);
		info.setEditable(false);
		info.setFocusable(false);
		info.setText("\u0414\u043B\u044F \u043F\u0440\u0435\u043E\u0431\u0430\u0437\u043E\u0432\u0430\u043D\u0438\u044F \u0432\u0441\u0442\u0430\u0432\u044C\u0442\u0435 \u0442\u0435\u043A\u0441\u0442 \r\n\u0432 \u044D\u0442\u043E \u0433\u0435\u043D\u0435\u0440\u0430\u0442\u043E\u0440 (\u043E\u0442\u043D\u043E\u0441\u0438\u0442\u0435\u043B\u044C\u043D\u043E) \u043B\u0435\u0433\u043A\u043E\u0437\u0430\u043F\u043E\u043C\u0438\u043D\u0430\u044E\u0449\u0435\u0433\u043E\u0441\u044F \u043D\u0430\u0434\u0435\u0436\u043D\u043E\u0433\u043E \u043F\u0430\u0440\u043E\u043B\u044F.\r\n \u0414\u043B\u044F \u0441\u043E\u0437\u0434\u0430\u043D\u0438\u044F \u043F\u0430\u0440\u043E\u043B\u044F \u0432\u0430\u0436\u043D\u043E \u043F\u043E\u043C\u043D\u0438\u0442\u044C: \r\n 1. \u041D\u0435\u043B\u044C\u0437\u044F \u0438\u0441\u043F\u043E\u043B\u044C\u0437\u043E\u0432\u0430\u0442\u044C \u0441\u043B\u043E\u0432\u0430 \u0438\u043C\u0435\u044E\u0449\u0438\u0435 \u043F\u0440\u044F\u043C\u0443\u044E \u0441\u0432\u044F\u0437\u044C \u043A \u0442\u0435\u0431\u0435 (\u0424\u0430\u043C\u0438\u043B\u0438\u044E, \u0438\u043C\u044F, \u043F\u0440\u043E\u0437\u0432\u0438\u0449\u0435) \r\n 2. \u0420\u0435\u043A\u043E\u043C\u0435\u043D\u0434\u0443\u0435\u0442\u0441\u044F \u0434\u0435\u043B\u0430\u0442\u044C \u043F\u0430\u0440\u043E\u043B\u0438 \u0431\u043E\u043B\u044C\u0448\u0435 8 \u0441\u0438\u043C\u0432\u043E\u043B\u043E\u0432 \r\n 3. \u041C\u043E\u0436\u0435\u0442\u0435 \u0438\u0441\u043F\u043E\u043B\u044C\u0437\u043E\u0432\u0430\u0442\u044C \u0432 \u043A\u0430\u0447\u0435\u0441\u0442\u0432\u0435 \u043F\u0430\u0440\u043E\u043B\u044F \u043F\u0440\u043E\u0441\u0442\u044B\u0435 \u043F\u0440\u0435\u0434\u043B\u043E\u0436\u0435\u043D\u0438\u044F (\u043C\u044B\u0438\u0434\u0435\u043C\u0432\u0448\u043A\u043E\u043B\u0443) \r\n 4. \u0414\u043B\u044F \u0441\u043E\u0437\u0434\u0430\u043D\u0438\u044F \u0431\u043E\u043B\u0435\u0435 \u043D\u0430\u0434\u0435\u0436\u043D\u043E\u0433\u043E \u043F\u0430\u0440\u043E\u043B\u044F \u0438\u0441\u043F\u043E\u043B\u044C\u0437\u0443\u0439\u0442\u0435 \u0446\u0438\u0444\u0440\u044B (\u043D\u0430\u043F\u0440\u0438\u043C\u0435\u0440: \u0434\u0430\u0442\u0430 \u0440\u043E\u0436\u0434\u0435\u043D\u0438\u044F \u043C\u0430\u043C\u044B \u0442\u0432\u043E\u0435\u0433\u043E \u043A\u0443\u043C\u0438\u0440\u0430) \r\n 5. \u0421\u043E\u0437\u0434\u0430\u043D\u043D\u044B\u0439 \u0432 \u044D\u0442\u043E\u0439 \u043F\u0440\u043E\u0433\u0440\u0430\u043C\u043C\u0435 \u043F\u0430\u0440\u043E\u043B\u044C \u0440\u0435\u043A\u043E\u043C\u0435\u043D\u0434\u0443\u0435\u0442\u0441\u044F \u0438\u0441\u043F\u043E\u043B\u044C\u0437\u043E\u0432\u0430\u0442\u044C \u0432 \u0441\u043E\u0446. \u0441\u0435\u0442\u044F\u0445, \u0444\u043E\u0440\u0443\u043C\u0430\u0445, \u0440\u0430\u0437\u0432\u043B\u0435\u043A\u0430\u0442\u0435\u043B\u044C\u043D\u044B\u0445 \u0441\u0430\u0439\u0442\u0430\u0445. \r\n 6. \u041D\u0435 \u0440\u0435\u043A\u043E\u043C\u0435\u043D\u0434\u0443\u0435\u0442\u0441\u044F \u0438\u0441\u043F\u043E\u043B\u044C\u0437\u043E\u0432\u0430\u0442\u044C \u0432 \u0431\u0430\u043D\u043A\u043E\u0432\u0441\u043A\u0438\u0445 \u0441\u0447\u0435\u0442\u0430\u0445, \u0438\u043D\u0442\u0435\u0440\u043D\u0435\u0442 \u0431\u0430\u043D\u043A\u0430\u0445 \u0438 \u0442. \u0434. \r\n \u0432\u0435\u0440\u0445\u043D\u0435\u0435 \u043F\u043E\u043B\u0435 \u0438 \u043D\u0430\u0436\u043C\u0438\u0442\u0435 \u043A\u043D\u043E\u043F\u043A\u0443 \r\n!\u043F\u0440\u0435\u043E\u0431\u0440\u0430\u0437\u043E\u0432\u044B\u0432\u0430\u0435\u0442 \u0442\u043E\u043B\u044C\u043A\u043E \u043A\u0438\u0440\u0438\u043B\u043B\u0438\u0446\u0443!");
		
		scroll = new JScrollPane(info);
		//scroll = new JScrollBar();
		scroll.setVisible(true);
		scroll.setBounds(50,100,100,100);
		
		btn = new JButton("Генерировать");
		btn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				  				
				pass.setText(Generator.Generator(input.getText()));
				
			}
		});
	
	
		
		
		
		GroupLayout groupLayout = new GroupLayout(jfrm.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(137)
					.addComponent(btn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(122))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(pass, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
						.addComponent(scroll, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
						.addComponent(input, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE))
					.addGap(38))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scroll, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(input, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btn, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(pass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(26))
		);
		
		jfrm.getContentPane().setLayout(groupLayout);
		
		jfrm.setVisible(true);	
	}
}
