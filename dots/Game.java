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

public class Game extends JFrame {

	private JPanel contentPane;
	private MyPanel panel;
	private MyPanel board;
	public Player player1;
	public Player player2;
	private JTextField textField;
	private JTextField textField_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game frame = new Game();
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
	public Game() {
		player1 = new Player();
		player2 = new Player();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 687, 577);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = e.getX();
				int b = e.getY();
				System.out.println(e.getX() + "," +  e.getY());
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
								trackTurn(player1,player2,board.board.play_area[input2][input1]);
								repaint();
								break;
							}
							
						}
						break;
					}
				}
			}				
				
			
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		board = new MyPanel();
		board.setBounds(114, 41, 477, 477);
		contentPane.add(board);
		
		JButton btnNewButton = new JButton("Restart");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(10, 107, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Player 1");
		lblNewLabel.setBounds(32, 141, 48, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(10, 166, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Player 2");
		lblNewLabel_1.setBounds(32, 197, 48, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(8, 215, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Score 1");
		lblNewLabel_2.setBounds(10, 325, 48, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(String.valueOf(player1.score));
		lblNewLabel_3.setBounds(10, 350, 48, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Score 2");
		lblNewLabel_4.setBounds(10, 375, 48, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(String.valueOf(player2.score));
		lblNewLabel_5.setBounds(10, 400, 48, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton_1 = new JButton("Play");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				char a = textField.getText().charAt(0);
				char b = textField_1.getText().charAt(0);
				Board area = new Board();
				player1 = new Player(a,0,true);
				player2 = new Player(b,0,false);
			}
		});
		btnNewButton_1.setBounds(10, 267, 89, 23);
		contentPane.add(btnNewButton_1);
		
	}
	public void trackTurn(Player a,Player b,Box c) {
		if(a.check == true) {
			c.owner = a.identifier;
			b.check = true;
			a.check = false;
		}
		else if(b.check == true) {
			c.owner = b.identifier;
			b.check = false;
			a.check = true;
		}
	}
}
