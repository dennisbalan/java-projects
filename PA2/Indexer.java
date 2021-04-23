/*
	Dennis Balan 4/22/2021, CSE 223 PA3 
      	Indexer scans a textfile and creates a hashMap that stores a string (that stores a word), and a Linked List(that stores the loocations of the word). The Indexer uses a processFile() along with the private cleanupWord() and addReference turns a textfile stores the input of word, as well as their index(es) in the scanned file into  the hashmap called index with two fields <string word>(where the cleaned, capitilized word is stored) and <LinkedList<int>> (where the locations of the indexes are stored). The class has public methods toString() (converts index to word),numberOfWords(total number of words in the Linked List), numberOfInstances() (the number of ttimes a word appears in index), locationOf() (finds the n (int input) instance of a word in the linked list the word is a key to)
*/

//import Scanner, File, HashMap and LinkedList classes 
import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
//class here 
class Indexer{
	//Hashmap called index created to store the word as a key, and locations in index in the linked list
	private HashMap <String, LinkedList<Integer>> index;
	//Flag to check if scanning has been done. Flase if scanning has not been done or is not finished, true if finnished
	private boolean Flag;
	//constructor, constructs the Indexer
	public Indexer(){
	}
	//processes a File inputi(String filename) and turns that input into a string, and uses a for loop to create to send the file content to the Hashmap. Uses other methods in this class to clean up the word from non-characters(claenupWord) and add the linked list with the index number of the word. Return true for success and false for failure. Flag is false for not being done or for errors, true for being done in this function. The class has public methods toString() (converts index to word),numberOfWords(total number of words in the Linked List 
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
	//cleanupWord takes an input of String word to clean it up from non-Letters and returns the cleaned String
	private String cleanupWord(String word){
		//create empty string called output
		String out = "";
		//create iterator int i
		int i;
		//for loop that traverses that the length of the word to clean the word
		for(i = 0; i < word.length();i++){
			//set char c to character at position i
			char c = word.charAt(i);
			//if c is a letter, add an uppercaseversion of it to the the empty string
			if(Character.isLetter(c)){
				out = out + Character.toUpperCase(c);
			}
		}
		//return output
		return(out); 
	}
	//adds 2 inputs,char word and int location into index. Flag is temporarily set to help access some other functions. If the word has not been caught in the file yet, a Linked List is created, and the location is added to the Linked list. The Linked List and word are added into index, word is the key and the Linked List is the value. If a word has already been used in index,the linked list keyed by word recieves location, which is added to the Linked List, after addReference is done, Flag is set to false
	private void addReference(String word, int location){
		//Flag set to true temporarily
		Flag = true;
		//If there is no instance of the word in index, a new Linked List is created. The Linked List is loaded with the location and is added to the hash along with the word. 
		if(numberOfInstances(word) < 1){
			//Initialaize new Linked List of integers a
			LinkedList a = new LinkedList<Integer>();
			//add location to a
			a.add(location);
			//add word as key,a as location
			index.put(word,a);
		}
		//Otherwise,if word has apperared already in the index, use word as a key in index to access the Linked List needed to add location into the Linked list
		else if(numberOfInstances(word) > 0){
			index.get(word).addLast(location);
		}
		//set Flag to false
		Flag = false;
	}
}
	


					
