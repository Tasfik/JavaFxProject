import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client 
{
	public static void main(String [] args) throws UnknownHostException, IOException
	{
		Socket socket=new Socket("localhost",9999); 
		
		InputStream in=socket.getInputStream();
		OutputStream out= socket.getOutputStream();
		String s1=new String();
		while(!s1.equals("-1"))
		{
			Scanner sc= new Scanner(System.in);
			s1=sc.nextLine();
			out.write(s1.getBytes());
			byte[]msg=new byte[1024];
			in.read(msg);
			System.out.println("		server sent :: "+new String(msg).trim()); 
		}
		 
		
		socket.close();
		
	}
	
}
