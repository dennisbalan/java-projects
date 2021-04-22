import java.util.scanner
import java.io.File
import java.util.Hashmap
import java.util.LinkedList
class Indexer{
	private Hashmap <String, LinkedList<Integer>> index;
	public Indexer(){
	}
	public boolean processFile(String filename){
		
		scanner sc;
		try{
			sc = new Scanner(new File(filename));
		}
		catch(Exception e){
			System.out.println("ERROR");
			return false;
		}
	
		//map = new HashMap <String,LinkedList<Integer>>();
		int num;
		while(sc.hasNext()){
			String temp=sc.next();	
			System.out.println("word" + "num" + " is " + temp);
			addReference(temp,num);
			if(!temp.equals("")){
				num++;
			}
		}
		sc.close();
		return true;
	}
	//-1 not done right now
	public int numberOfInstances(String word){
			if(index.containsKey(word) == true){
				//	if(processFile() == false ){
				
			      //return size of Linked Listi
				LinkedList a = index.get(word);
				return(a.sizeof());				      
			}
			else{
				return(0);
			}
	}
	public int locationOf(String word, int instanceNum){
		
	}
	public int numberOfWords(){
		return(index.size())
	}
	public String toString(){
	}
	private String cleanupWord(String word){
		String out = "";
		for(i = 0; i < word.length();i++){
			char c = word.charAt();
			if(c.isLetter() == true){
				out = out + c.toUpperCase();
			}
		}
		return(out); 
	}
	private void addReference(String word, int location){
		if(numberOfInstances(word) <= 0){
			LinkedList a = new LinkedList<Interger>();
			a.add(location);
			index.put(word,a);
		}
		else{
			index.get(word).add(location);
		}
	}
	


					
