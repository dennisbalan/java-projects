import java.util.Scanner;
public class PA3{
	public static void main (String[] args){
		Tree tree = new Tree();	
		String sc = args[0];
		tree.root = tree.scan(sc);
		tree.game();
	}
}
	
