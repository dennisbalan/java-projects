import javax.swing.JPanel;
import java.awt.Graphics;

public class MyPanel extends JPanel {
	public Board board;
	public MyPanel() {
		super();
		board = new Board();
	}
	public void paint(Graphics g) {
			
			super.paint(g);
			
			
			for(int x = 0; x < 401; x+=50) {
				for(int y = 0; y < 401; y+=50) {
					g.fillOval(x,y,5,5);
					}
			}
			if(board == null) {
				return;
			}
			for(int i = 0;i < 8; i++) {
					for(int u = 0; u < 8; u++) {
						if(board.play_area[i][u].check_box() == true) {
							g.drawString(String.valueOf('a'), u * 50 + 15, i * 50 + 15);
						}
						if(board.play_area[i][u].top == true) {
							System.out.println("MyPanel method i is " + i + ", u is " + u);
							int x_cord1 = u * 50;
							int y_cord = i * 50;
							int x_cord2 = u * 50 + 50;
							System.out.println("X cord 1 is " + x_cord1 + "x 2 is " + x_cord2 + "y_cord is " +  y_cord);
							g.drawLine(x_cord1, y_cord, x_cord2, y_cord);
							if(i != 0) {
								board.play_area[i-1][u].bottom = true;
							}
						}
						if(board.play_area[i][u].left == true) {
							int x_cord1 = u * 50;
							int y_cord1 = i * 50;
							int y_cord2 = i * 50 + 50;
							g.drawLine(x_cord1, y_cord1, x_cord1, y_cord2);
							if(u != 0) {
								board.play_area[i][u-1].right = true;
							}
						}
						if(board.play_area[i][u].right == true) {
								int x_cord = u * 50 + 50;
								int y_cord1 = i * 50;
								int y_cord2 = i * 50 + 50;
								g.drawLine(x_cord,y_cord1,x_cord,y_cord2);
								if(u != 7) {
									board.play_area[i][u+1].left = true;
								}
						}
						if(board.play_area[i][u].bottom == true){
							int x_cord1 = u * 50;
							int x_cord2 = u * 50 + 50;
							int y_cord = i * 50 + 50;
							g.drawLine(x_cord1, y_cord, x_cord2, y_cord);
							if(i != 7) {
								board.play_area[i+1][u].top = true;
							}
								
						}
					}
			} 
			
			
	}
}
