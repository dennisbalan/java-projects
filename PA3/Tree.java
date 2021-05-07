import java.util.Scanner;
import java.io.File;
public class Tree{
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
			//create a new node question
			Node question = new Node();
			//set question to root
			question = root;
			//initialize string to "sample to avoid errors")
			String text = "sample";
			//test is actually to the line the scanner sc reads
			text = sc.nextLine();
			//execute if line read is "Q:" or question. add children to node recuresively and return qiestion
                        if(text.equals("Q:")){
				//set question to  new Node object, include sc line and boolean true to indicate question
				question = new Node(sc.nextLine(),true);
				//recursive ingest on left sub tree
			 	question.yes = ingest(sc);
				//recuresive ingest on right sub tree
				question.no = ingest(sc);
				//return question
				return question;
                        }
			//execute if line read is "A:" or answer
                        else if(text.equals("A:")){
                              	text = sc.nextLine();
				Node answer = new Node(text,false);
                                answer.yes = answer.no = null;
                                return answer;
                        }
                
		return question;
        }
        public void game(){
	 	Node temp = new Node();
		temp = root;
                while(temp != null){
                        System.out.println(temp.text);
                        Scanner sc = new Scanner(System.in);
                        String input = sc.next();
                        if(input.equals("y")){
                                temp = temp.yes;

                        }
                        else if(input.equals("n")){
                                temp = temp.no;
			}
                        else{
                                System.out.println("Wrong format");
                        }
                }
        }


}

