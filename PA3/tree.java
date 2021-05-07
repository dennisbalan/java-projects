public class Tree{
	Node root;

	public Tree(){
		root = null;
	}
	
	void print() {
		if(root == null) return;
		root.print();
	}
	void add_question(string question){
		if(root == null) return;
		root.add(n);
	}
	Node ingest(String filename){
		string text;
		Scanner sc;
		try{
			Scanner sc = new Scanner(new File(filename));
		}
		catch(Exception e){
			System.out.println("ERROR");
		}
		while(sc.hasNext()){
			text = sc.next();
			if(text == "Q:"){
				text = sc.next();
				Node question = new Node(text,true);
				question.yes = ingest(sc);
				question.no = ingest(sc);
				return Node;				
			}
			else if(text == "A"){
				text = sc.next();
				Node answer = new Node(text,false);
				answwer.yes = answer.no = null;
				return answer;
			}
		}		
		sc.close();
	}	
	boolean game(Tree tree){
		while(tree != null){
			System.out.println(tree.text);
			Scanner sc = new Scanner(system.in);
			String input = user.nextline();
			if(input == 'Y'){
				tree = tree.yes;
						
			}	
			else if(input == 'N'){
				tree = tree.no;
			}
			else{	
				System.out.println("Wrong format");
			}
		}
	}
		
		
}
