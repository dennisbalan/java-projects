
public class Player {
	public char identifier;
	public int score;
	public boolean check;
	public Player(char a, int b,boolean c) {
		identifier = a;
		score = b;
		check = c;
		
		
	}
	public Player() {
		identifier = 'a';
		score = 0;
		check = true;
	}
}
