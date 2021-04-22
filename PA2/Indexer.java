import java.util.scanner
import java.io.File
import java.util.Hashmap
import java.util.LinkedList
class Indexer{
	private Hashmap <String, LinkedList<Integer>> index;
	private boolean Flag;
	public Indexer(){
	}
	public boolean processFile(String filename){
		
		scanner sc;
		try{
			sc = new Scanner(new File(filename));
		}
		catch(Exception e){
			System.out.println("ERROR");
			Flag == false;
			return false;
		}
	
		//map = new HashMap <String,LinkedList<Integer>>();
		int num;
		while(sc.hasNext()){
			String temp=sc.next();	
			System.out.println("word" + "num" + " is " + temp);
			temp = cleanupWord(temp);
			if(!temp.equals("")){
				num++;
			}
			addReference(temp,num);
		}
		sc.close();
		Flag == true;
		return true;
	}
	//-1 not done right now
	public int numberOfInstances(String word){
			if(Flag == false){
				return -1;
			}
			if(index.containsKey(word) == true){
			      //return size of Linked Listi
				LinkedList a = index.get(word);
				return(a.sizeof());				      
			}
			else{
				return(0);
			}
	}
	public int locationOf(String word, int instanceNum){
		if(Flag == false){
			return -1;
		}
		int a = index.get(word).get(instanceNum);
		
	}
	public int numberOfWords(){
		return(index.size())
	}
	public String toString(){
		return(index.toString());
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
	


					
