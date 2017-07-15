package Main;

import java.util.Random;

public class Generator 
{
	static char a[];
	static StringBuffer out;
	static int l;
	static Random rand = new Random();
	protected static String Generator(String asd)
	{
	
		l = asd.length();
		a= new char[l];
		a =asd.toCharArray();

		out = new StringBuffer();
		for(int i=0;i<l;i++)
		{
		boolean bl=false;
			for(int t=0;t<32;t++)
			{
				if(a[i]==s1[t]||a[i]==s2[t])				
				{
					int temp=rand.nextInt(4);
					switch(temp)
					{
					case 0:
						out.append(b[t]);
						break;
					case 1:
						out.append(c[t]);
						break;
					case 2:
						out.append(d[t]);
						break;
					case 3:
						out.append(e[t]);
						break;
					}
					bl=true;
				}						
			}	
			if(bl==false)
				out.append(a[i]);

		}
		
		
		
		
		
		return out.toString();
	}
	static char s1[] = {'à','á','â','ã','ä','å','¸','æ','ç','è','û','é',
		'ê','ë','ì','í','î','ï','ð','ñ','ò','ó',
		'ô','õ','ö','÷','ø','ù','ü','ý','þ','ÿ'};
	
	static char s2[] = {'À','Á','Â','Ã','Ä','Å','¨','Æ','Ç','È','Û','É',
		'Ê','Ë','Ì','Í','Î','Ï','Ð','Ñ','Ò','Ó',
		'Ô','Õ','Ö','×','Ø','Ù','Ü','Ý','Þ','ß'};
	
	static String b[] = {"a","b","v","g","d","e","e","j","z","i","y","i",
		"k","l","m","n","o","p","r","c","t","u",
		"f","h","c","ch","sh","sh","'","e","u","ja"};
	
	static String c[] = {"A","B","V","G","D","E","E","J","Z","I","Y","I",
		"K","L","M","N","O","P","R","C","T","U",
		"F","H","C","CH","W","W","'","E","U","Ja"};
	
	static String d[] = {"@","l3","\\/","9","cl","3","3","i","2","1","y","1",
		"R","1","l22","&","0","r","P","$","7","a",
		"4","x","I[","4","Lll","LlL","b","&","V","9l"};
	
	static String e[] = {"Q","6","B","r","9","{","{","}|{","3","u","bl","u",
		"I{","/\\","/\\/\\","H","()","I1","p","s","m","y",
		"T","X","u","q","w","w","I>","}","}0","7]"};
	
	
}
