import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.PrintWriter;
public class Server extends Thread{
		public ServerSocket ss;
		public Socket sock;
		PrintWriter pw;
		Scanner sc;
		Player_1 frame;
		
		public Server(Player_1 a) {
			this.frame = a;
			//create a server
			try {
				ss = new ServerSocket(1234);
			}catch(IOException e){
				System.out.println(e);
				return;
			}
			System.out.println("Create a server");
			//accept connection
			try {
				sock = ss.accept();
			}
			catch(IOException e) {
				System.out.println(e);
				return;
			}
			System.out.println("Waiting for connection");
			//pw created
			try{
				pw = new PrintWriter(sock.getOutputStream());
			}
			catch(Exception e){
				return;
			}
			System.out.println("pw");
			//scanner created
			try {
				sc = new Scanner(sock.getInputStream());
			}catch(Exception e) {
				return;
			}
			System.out.println("sc");
		}
			
		
		public void run() {
			send_name(frame.textField.getText());
			rec_name();
			String c;
			while(sc.hasNextLine()) {
				c = sc.nextLine();
				if(c.charAt(0) == 'C') {
					frame.change_turn();
					String[] array = c.split(" ",3);
					frame.turn = false;
					int x = Integer.parseInt(array[1]);
					int y = Integer.parseInt(array[2]);
					frame.get_coordinates(x,y);
					frame.turn = true;
					frame.change_turn();
					
				}
				else if(c == "Q") {
					System.exit(0);
				}
			}
		
		}
		public void send_coord(int x, int y) {
			String string = "C " + x + " " + y;
			pw.println(string);
			pw.flush();
			
		}
		
		public void send_name(String name) {
			try {
				pw.println(name);
				pw.flush();
			}
			catch(Exception e) {
				return;
			}
		}
		public void rec_name() {
			String name;
			try{
				name = sc.nextLine();
				frame.textField_1.setText(name);
			}
			catch(Exception e) {
				return;
			}
			frame.name2 = name;
			frame.change_name_2();
		}
		public void send_q() {
			try {
			pw.println("Q");
			pw.flush();
			}
			catch(Exception e) {
				return;
			}
		}
}
