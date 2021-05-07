//	Dennis Balan CSE223 PA3 5/7/2021   Node is just class that more like a C struct. It exists soleley as a way to store information. It is a node in the Tree object and stores the text, the flag on whether it is a question or answer (question true, answer false) and left and right subtrees and yes and no rspecyively. Constructors for no inputs and variants with text and flag are the only things inside
class Node{
	//string text stores the question answer
	String text;
	//flag indicates what kind a question or answer is, true is question, false is answer
	boolean flag;	
	//yes is left sub tree
	Node yes;
	//no is right sub tree
	Node no;
	//constructor for no inputs sets left and right childs (yes and no) to null
	public Node(){
		yes=no=null;
	}
	//constructor fpr a new Node with info. // takes inputs strings new_text and boolean new_flag and assigns them to text and flag respectivelyt
	public Node(String new_text,boolean new_flag){
		text = new_text;
		flag = new_flag;
	}
		

}
