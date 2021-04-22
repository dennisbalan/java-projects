import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
class Indexer{
	private HashMap <String, LinkedList<Integer>> index;
	private boolean Flag;
	public Indexer(){
	}
	public boolean processFile(String filename){
		
		Scanner sc;
		try{
			sc = new Scanner(new File(filename));
		}
		catch(Exception e){
			System.out.println("ERROR");
			Flag = false;
			return false;
		}
	
		//map = new HashMap <String,LinkedList<Integer>>();
		int num = 0;
		while(sc.hasNext()){
			String temp=sc.next();	
			temp = cleanupWord(temp);
			System.out.println("word" + "is " + temp + "num is" + num);
			if(!temp.equals("")){
				num++;
			}
			addReference(temp,num);
		}
		sc.close();
		Flag = true;
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
				return(a.size());				      
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
		return(a);
		
	}
	public int numberOfWords(){
		if(Flag == false){
			return -1;
		}
		return(index.size());
	}
	public String toString(){
		if(Flag == false){
			return null;
		}
		return(index.toString());
	}
	private String cleanupWord(String word){
		String out = "";
		int i;
		for(i = 0; i < word.length();i++){
			char c = word.charAt(i);
			if(Character.isLetter(c)){
				out = out + word.charAt(i);
			}
		}
		return(out); 
	}
	private void addReference(String word, int location){
		if(numberOfInstances(word) <= 0){
			LinkedList a = new LinkedList<Integer>();
			a.add(location);
			index.put(word,a);
			System.out.println("Success");
		}
		else{
			index.get(word).add(location);
		}
	}
}
	


					
