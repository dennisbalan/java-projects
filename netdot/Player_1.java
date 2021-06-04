import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Player_1 extends JFrame {

	private JPanel contentPane;
	private MyPanel panel;
	private MyPanel board;
	boolean server;
	boolean client;
	public JTextField textField;
	public JTextField textField_1;
	private JTextField textField_2;
	public String name1 = "server";
	public  String name2 = "client";
	public Player h;
	int quit = 0;
	Server netThread;
	Client intThread;
	public boolean turn;
	public JLabel turn_indicator;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Player_1 frame = new Player_1();
					frame.setVisible(true);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Player_1() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 577);
		contentPane = new JPanel();
		name1 = "server";
		name2 = "client";
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = e.getX();
				int b = e.getY();
				System.out.println(e.getX() + "," +  e.getY());
				if(turn == true) {
					
					get_coordinates(a,b);
					change_turn();
					if(server == true) {
						netThread.send_coord(a,b);
					}
					if(client == true) {
						intThread.send_coord(a,b);
					}
					
					turn = false;
				}
			}
				
			
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		board = new MyPanel();
		board.setBounds(114, 41, 477, 477);
		contentPane.add(board);
		
		JLabel lblNewLabel = new JLabel("Player 1");
		lblNewLabel.setBounds(32, 141, 48, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField("Server");
		textField.setBounds(10, 166, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		name1 = textField.getText().toString();
	
		
		
		JLabel lblNewLabel_1 = new JLabel("Player 2");
		lblNewLabel_1.setBounds(32, 197, 48, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField("Client");
		textField_1.setEditable(true);
		textField_1.setBounds(8, 215, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		name2 = textField_1.getText().toString();
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Score 1");
		lblNewLabel_2.setBounds(32, 283, 48, 14);
		contentPane.add(lblNewLabel_2);
		
	
		
		JLabel lblNewLabel_4 = new JLabel("Score 2");
		lblNewLabel_4.setBounds(32, 361, 48, 14);
		contentPane.add(lblNewLabel_4);
		//Start Button
		JButton btnNewButton = new JButton("Start");
		Player_1 a = this;
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			
			public void mouseClicked(MouseEvent e) {
				
				if(server == true) {
					/*server open*/
					turn = true;
					change_turn();
					quit++;
					btnNewButton.setText("Quit");
					netThread = new Server(a);
					netThread.start();
				}
				if(client == true) {
					/*net thread*/
					turn = false;
					change_turn();
					quit++;
					btnNewButton.setText("Quit");
					intThread = new Client(a);
					intThread.start();
				}
				if(quit == 2) {
					if(client == true) {
						intThread.send_q();
					}
					if(server == true) {
						netThread.send_q();
					}
					dispose();
					System.exit(0);
				}
			}
		});
		
		btnNewButton.setBounds(10, 504, 89, 23);
		contentPane.add(btnNewButton);
		
		
		//Server click
		JRadioButton rdbtnNewRadioButton = new JRadioButton(name1);
		rdbtnNewRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_1.setEditable(false);
				server = true;
				
			}
		});
		rdbtnNewRadioButton.setBounds(-1, 41, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton(name2);
		rdbtnNewRadioButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				client = true;
				textField.setEditable(false);
				btnNewButton.setText("Connect");
				textField_2.setEditable(true);
			}
		});
		rdbtnNewRadioButton_1.setBounds(-1, 86, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		
		textField_2 = new JTextField("localhost");
		textField_2.setEditable(false);
		textField_2.setBounds(10, 465, 96, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Host ID");
		lblNewLabel_5.setBounds(32, 440, 48, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_3 = new JLabel("Turn");
		lblNewLabel_3.setBounds(601, 90, 48, 14);
		contentPane.add(lblNewLabel_3);
		
		turn_indicator = new JLabel("Undefined");
		turn_indicator.setBounds(601, 141, 48, 14);
		contentPane.add(turn_indicator);
		
		if(turn == true) {
			turn_indicator.setText(name1);
			
		}
		if(turn == false) {
			turn_indicator.setText(name2);
		
		}
		
		
	}
	
	
	/*get x and y method*/
	public void get_coordinates(int a, int b) {
		
		
		int width = 114+477;
		int i;
		int input1 = -1;
		for(i = 114;i < width; i+=50) {
			int c = a-i;
			input1++;
			if(c < 50) {
				
				int height = 41+477;
				int input2 = -1;
				int s;
				for(s = 41;s < height; s+=50) {
					int u = b-s;
					
					input2++;
					if(u < 50) {
						System.out.println(input2 + "," + input1);
						//draw line
						board.board.play_area[input2][input1].draw_line(input2,input1,a,b);
						repaint();
						break;
					}
					
				}
				break;
			}
		}
		
	}
	public void change_turn() {
		if(turn == true) {
			turn_indicator.setText(name1);
			
		}
		else if(turn == false){
			turn_indicator.setText(name2);
		
		}
	}
	public void change_name_1() {
		textField.setText(name1);
	}
	public void change_name_2() {
		textField_1.setText(name2);
	}
}
