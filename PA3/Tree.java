/*
	Dennis Balan CSE 223 5/27/2021 PA3
	Tree class that stores a binary tree for a game. Includes scanning method scan to scan a file, ingest (clalled in scan) to create a search tree, and a method called game to utilize the buinary tree in a game
*/
//impported File amd Scanner classes
import java.util.Scanner;
import java.io.File;
public class Tree{
	//root/sentinel of the binary tree for the game
        public Node root;
	//methods returns Node and scans file with the input of string filename used to create questions and answers. While scanning ingests file to create binary tree and stores said binary tree in root
	public Node scan(String filename){
		//create Scanner var sc
		Scanner sc;
		//try catch here. if success, create new Scanner object form filename and store the file in sc 
		try{
			sc = new Scanner(new File(filename));		
		}
		//if fail, just return root 
		catch(Exception e){
			return root;
		}
		//while, there is stuff in a file, ingest sc to create binary tree 
		while(sc.hasNext()){
			root = ingest(sc);
		}
		//close scanner and return root
		sc.close();
		return root;
	}	 
	//Ingest takes the input of scanner sc and returns a Node objedt to build a binary tree for the game. It takes the scanner object create a new node based on information from the file, and create children of the node, and more children of the node. Nodes come in 2 shapes "question" which are the quesions the program will ask the user, and answers, the guesses	
        private Node ingest(Scanner sc){
			//create new node question
			Node question = new Node();
			//set question to root
			question = root;
			//initialize string to "sample to avoid error
			String text = "sample";
			//test is actually to the line the scanner sc reads
			text = sc.nextLine();
			//execute if line read is "Q:" or question. add children to node recuresively and return qiestion/
                        if(text.equals("Q:")){
				//set question to  new Node object, include sc line and boolean true to indicate question
				question = new Node(sc.nextLine(),true);
				//recursive ingest on left sub sub trees
			 	question.yes = ingest(sc);
				//recursive ingest on right sub tree
				question.no = ingest(sc);
				//return question for recursiom
				return question;
                        }
			//execute if line read is "A:" or answer.children are null
                        else if(text.equals("A:")){
				//text is next line is scnanner
                              	text = sc.nextLine();
				//answer.flag set to false to inidicate answer, text added as answer, new object answer created
				Node answer = new Node(text,false);
				//sub trees set to null
                                answer.yes = answer.no = null;
				//recursive return
                                return answer;
                        }
                //return final product
		return question;
        }
	//Actually plays thegame. Traverses the tree and asks the user questions until it gets to the answer
        public void game(){
		//initialise new Node temp
	 	Node temp = new Node();
		//temp set to root
		temp = root;
		//works while temp is not null, does not get to the answer
                while(temp != null){
			//print out the question
                        System.out.println(temp.text);
			//scan for user input
                        Scanner sc = new Scanner(System.in);
			//save input
                        String input = sc.next();
			//if yes, set to temp.yes, or left traversal
                        if(input.equals("y")){
                                temp = temp.yes;
                        }
			//else if no, set to temp.no, or roght traversal
                        else if(input.equals("n")){
                                temp = temp.no;
			}
			//error message
                        else{
                                System.out.println("Wrong format");
                        }
                }
        }


}

