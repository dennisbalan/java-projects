import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.io.PrintWriter;
public class Client extends Thread{
	public Socket sock;
	public PrintWriter pw;
	public Scanner sc;
	public Player_1 frame;
	public Client(Player_1 a) {
		frame = a;
		try {
			sock = new Socket("localhost",1234);
		
		}
		catch(Exception e){
			System.out.println(e);
			return;
		}
		System.out.println("Connection created");
		try{
			pw = new PrintWriter(sock.getOutputStream());
		}
		catch(Exception e){
			return;
		}
		//scanner created
		try {
			sc = new Scanner(sock.getInputStream());
			System.out.println("Sc created" + sc);
		}catch(Exception e) {
			return;
		}
	}
	public void run() {
		send_name(frame.textField_1.getText());
		rec_name();
		String c;
		while(sc.hasNextLine()) {
			c = sc.nextLine();
			if(c.charAt(0) == 'C') {
				frame.change_turn();
				String[] array = c.split(" ",3);
				
				int x = Integer.parseInt(array[1]);
				int y = Integer.parseInt(array[2]);
				frame.get_coordinates(x, y);
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
			frame.textField.setText(name);
		}
		catch(Exception e) {
			return;
		}
		frame.name1 = name;
		frame.change_name_1();
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
