import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.PrintWriter;
public class NetThread extends Thread{
	Socket sock;
	PrintWriter pw;
	Scanner sc;
	
	public NetThread(Socket sock) {
		this.sock = sock;
		try{
			
		}catch(Exception e) {
			return;
		}
	}
}
