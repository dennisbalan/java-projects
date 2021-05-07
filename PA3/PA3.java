//Dennis Balan CSE 223 5/7/2021 PA3 main program with command line arguements for the assignment that that plays a guessing game takes an input of file "/tmp/20Q/txt" or input from command line. Creates a mew Tree object called tree to created a binary tree needed to play a guessing game. Inputs from teither the command or the default file "/tmp/20!.txt" is tored in the string sc which is then scanned(and ingested to create the binary tree. tree.game() finally plays the game, preced by some instructions 
public class PA3{
	public static void main (String[] args){
		//create new Tree object tree
		Tree tree = new Tree();
		//initialize strubg sc to random value init
		String sc = "init";
		//check for command line args
		if(args.length > 0){	
			//if command line args exist set to sc to args[0]
			sc = args[0];
		}	
		//otherwise set sc tp default file "/tmp/20Q.txt"
		else{
			sc = "/tmp/20Q.txt";
		}
		//scan the file
		tree.root = tree.scan(sc);
		//instructions for the game in 3 lines
		System.out.println("Hello. Wanna play a game. Of course you do");
		System.out.println("When you get a question answer yes or no");
		System.out.println("answer 'y' for yes and 'n' for no");
		//game function. Plays once
		tree.game();
	}
}
	
