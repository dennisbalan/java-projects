
public class Board {
	public Box [][] play_area =new Box[8][8];
	public Board() {
			play_area = new Box[8][8];
			for(int i = 0; i < 8; i++) {
				for(int u = 0; u < 8; u++) {
					play_area[i][u] = new Box();
				}
			}
	}
}
