import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
class Indexer{
	//Hashmap called index created to store the word as a key, and locations in index in the linked list
	private HashMap <String, LinkedList<Integer>> index;
	//Flag to check if scanning has been done. Flase if scanning has not been done or is not finished, true if finnished
	private boolean Flag;
	//constructor, constructs the Indexer
	public Indexer(){
	}
	//processes a File inputi(String filename) and turns that input into a string, and uses a for loop to create to send the file content to the Hashmap. Uses other methods in this class to clean up the word from non-characters(claenupWord) and add the linked list with the index number of the word. Return true for success and false for failure. Flag is false for not being done or for errors, true for being done in this function
	public boolean processFile(String filename){
		//create Scanner object sc
		Scanner sc;
		//sc is set to the scanned file/input in the try statement
		try{
			sc = new Scanner(new File(filename));
		}
		//for any errors (Exception e, return an error by seeting Flag false, print an error statement to the screen and return false
		catch(Exception e){
			//print error
			System.out.println("ERROR");
			//Flag is set to false and false is returned
			Flag = false;
			return false;
		}
	
		//initialize num to 0. num is going to be the index of items
		int num = 0;
		//initialize index as a HashMap with String as key and LinkedList of Intergers as value
		index = new HashMap<String, LinkedList<Integer>>();
		//iterate while there is stuff in sc to check if there is a statement after
		while(sc.hasNext()){
			//set String temp equal sc.next(), the next word in the sc 
			String temp = sc.next();	
			//clean up temp in CleanupWord()
			//IMPORTANT cleanupWord is a function only for this class and is not global
			temp = cleanupWord(temp);
			//if temp is not an empty string, increment index and add both temp and num to index 
			if(!temp.equals("")){
				num++;
				//addReference adds temp and num to HashMap.
				//IMPORTANT addReference() is a function for this class only. It is not global
				addReference(temp,num);
			}
		}
		//clse the scanner
		sc.close();
		//set Flag to true for success
		Flag = true;
		//return true for success
		return true;
	}
	//number OfInstances returns the number of times a single word appears in index. uses the input String word as a key in index to access the Linked List stored as a value, and returns the size of the Linked List as an int. If Flag is false, returns -1, returns 0 if word is not in the Hashmap
	public int numberOfInstances(String word){
			//if Flag is false, return -1
			if(Flag == false){
				return -1;
			}
			//check to see if word is in the Hashmap, else return 0
			if(index.containsKey(word) == true){
			      //create a new Linked List of Integers a 
				LinkedList a = new LinkedList<Integer>();
				//set a to the Linked List word is a key to 
				a = index.get(word);
				//return size of a
				return(a.size());				      
			}
			//return 0, if word not in hash
			else{
				return(0);
			}
	}
	//locationOf returns an int and takes an input of String word and int instanceNum.It uses word as a key in index to access the linked list word is a key to, and uses InstanceNum as a the nth the number in the Linked list the user wants to find. returns -1 if Flag is false,instanceNum is negative or bigger than the size of the linked list
	public int locationOf(String word, int instanceNum){
		//check is Flag is false. if false return -1
		if(Flag == false){
			return -1;
		}
		//checks to sees if 2 more conditions are satisfied for locationOf() to return -1. check to see if instanceNum is negative or larger than the linked list word is a key to in index
		if((instanceNum < 0) || instanceNum >= index.get(word).size()){
			return -1;
		}
		//else. set a to the "instanceNum"th element in the Linked List which word ekys to in index
		int a = index.get(word).get(instanceNum);
		//return a, the location of "InstanceNum"th instance of a word in the file
		return(a);
		
	}
	//returns the number of words in the hashmap as an int, returns -1 if Flag is false
	public int numberOfWords(){
		//return -1 if Flag is false
		if(Flag == false){
			return -1;
		}
		//return the size of index as an int using the .size() method
		return(index.size());
	}
	//convert hashmap index to String and return a String. return null if Flag is false
	public String toString(){
		//return null if Flag is false
		if(Flag == false){
			return null;
		}
		//use the .toStrung() method to convert index to string and return it
		return(index.toString());
	}
	private String cleanupWord(String word){
		String out = "";
		int i;
		for(i = 0; i < word.length();i++){
			char c = word.charAt(i);
			if(Character.isLetter(c)){
				out = out + Character.toUpperCase(c);
			}
		}
		return(out); 
	}
	private void addReference(String word, int location){
		Flag = true;
		if(numberOfInstances(word) < 1){
			LinkedList a = new LinkedList<Integer>();
			a.add(location);
			index.put(word,a);
		}
		else if(numberOfInstances(word) > 0){
			index.get(word).addLast(location);
		}
		Flag = false;
	}
}
	


					
