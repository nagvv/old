package Chat;

public class MainClass
{
	static PanelSender sender;
	static PanelChat chat;
	static Window frame;
	static Client client;
	static Actions actions;
	
	
	public static String version ="IPtell v1.0.5";
	
	public static void main(String args[])
	{		
		actions = new Actions();
		sender = new PanelSender();
		chat = new PanelChat();
		client = new Client();
		frame = new Window();
	}

}