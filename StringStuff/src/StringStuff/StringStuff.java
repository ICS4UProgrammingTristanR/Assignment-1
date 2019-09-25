/*
 * Created by: Tristan Royer
 * Created on: 24-09-19
 * Created for: ICS4U Programming
 * Assignment #1 - String Stuff
 * This program assesses an array and both checks the max run and can also duplicate letters.
*https://javarevisited.blogspot.com/2015/06/3-ways-to-find-duplicate-elements-in-array-java.html
*/
package StringStuff;
import java.io.*;
import java.util.HashMap; 
import java.util.HashSet; 
import java.util.Map; 
import java.util.Map.Entry; 
import java.util.Set;
import javax.xml.stream.events.Namespace;


public class StringStuff {
	// The name of the file to open.
	public static String fileName = "input.txt";	
	
public char[] toCharArray() {  
	    // Cannot use Arrays.copyOf because of class initialization order issues  
	    char[] result = new char[fileName.length()];  
	    System.arraycopy(fileName, 0, result, 0, fileName.length());  
	    return result;  
	}  
			


	public static void main(String args[]) {
		
		
		

        // This will reference one line at a time
        String line = null;	
        int run = 0;
        int maxRun;
        String maxRunLetter;
		
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        
        char[] ch = fileName.toCharArray();
        
        for (int count = 0; count < ch.length; count++) ch[count] = count;
        
        for (int e : ch) 
        	
        System.out.println();
        
        

        
        
        //Map<String, Integer> nameAndCount = new HashMap<>();

  
		// build hash table with count
       // for (String name : ch) {
           // Integer count = nameAndCount.get(name);
            //if (count == null) {
               // nameAndCount.put(name, 1);
            //} else {
               // nameAndCount.put(name, ++count);
            //}
       // }

        // Print duplicate elements from array in Java
        //Set<Entry<String, Integer>> entrySet = nameAndCount.entrySet();
        //for (Entry<String, Integer> entry : entrySet) {
            //if (entry.getValue() > 1) {
               // System.out.printf("duplicate element '%s' and count '%d' :", entry.getKey(), entry.getValue());
         //   }
      //  }
        
        
        
        
        
        
    }
}