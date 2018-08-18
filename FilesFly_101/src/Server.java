import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;



public class Server 
{
	public static void main(String[] args) throws IOException
	{
		ServerSocket serSocket=new ServerSocket(9999);
		System.out.println("waiting for client...");
		Socket socket=serSocket.accept();
		System.out.println("client connected...");
		
		InputStream in=socket.getInputStream();
		OutputStream out=socket.getOutputStream();
		
		byte []msg=new byte[1024];
		
		String s2=new String();
		
		while(!s2.equals("-1"))
		{
			in.read(msg);
			System.out.println("		client sent :: "+ new String(msg).trim()); 
			Scanner sc=new Scanner(System.in);
			s2=sc.nextLine();
			out.write(s2.getBytes());
		}
		
		socket.close();
		serSocket.close();
	}
}
