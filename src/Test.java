import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Test {

	public static void main(String[] args) {
		HashTable dict=new HashTable(1000);
		HashTable counter=new HashTable(111);
		
		try (BufferedReader br = new BufferedReader(new FileReader("word.txt"))) {
		    String line;
		    while ((line = br.readLine()) != null)
				dict.add(line.toLowerCase());//Adds each word to the dictionary
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		
		try (BufferedReader br = new BufferedReader(new FileReader("Comp 2071 - 2016-1sp -- Project 5 - Hash Tables -- DMR -- 2015-07-14 01.txt"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	String[] currWords = line.split(" ");
		    	for(int i=0;i<currWords.length;++i){
		    		String curr=currWords[i].toLowerCase();
		    		curr=curr.trim();
		    		curr=curr.replaceAll("[^a-zA-Z ]", "");
			    	if(dict.contains(curr)){//the word is found in the dictionary, and it is time to increment the counter or add it to the counter hashtable
			    		if(counter.contains(curr))
			    			counter.incValue(curr);
			    			//counter.setValue(curr,counter.getValue(curr)+1);
			    		else
			    			counter.add(curr);
				    	
			    	}else{
			    		if(curr.equals(""))
			    			;
			    		else
			    			;//System.out.println(curr + " Was not found in the dictionary");		
			    	}
			    	
		    
		    	}
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		counter.printall();
	}
}

