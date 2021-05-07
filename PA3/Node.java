class Node{
	String text;
	boolean flag;	
	Node yes;
	Node no;

	public Node(){
		yes=no=null;
	}
	public Node(String new_text,boolean new_flag){
		text = new_text;
		flag = new_flag;
	}
		

}
