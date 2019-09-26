package StringStuff2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//https://stackoverflow.com/questions/15466246/multiplying-all-values-of-an-array-using-an-enhanced-loop-java
//https://www.sanfoundry.com/java-program-insert-element-specified-position-given-array/
public class StringStuff2 {
	// The name of the file to open.
		public static String fileName = "input2.txt";	
		public static String otherFileName = "output2.txt";	

	    public static int run ;
	    public static int maxRun;
	    public static char maxRunLetter;
	    public static String characters;
	    public static int duplications;
		
	public char[] toCharArray() {  
		    // Cannot use Arrays.copyOf because of class initialization order issues  
		    char[] result = new char[characters.length()];  
		    System.arraycopy(characters, 0, result, 0, characters.length());  
		    return result;  
		}  
				


		public static void main(String args[]) {
			
			
			

	        // This will reference one line at a time
	         String line = null;	
	         //String[] characters = line;
	    
			
	        try {
	            // FileReader reads text files in the default encoding.
	            FileReader fileReader = new FileReader(fileName);
	          

	            // Always wrap FileReader in BufferedReader.
	            BufferedReader bufferedReader = 
	                new BufferedReader(fileReader);
	            
	        

	            while((line = bufferedReader.readLine()) != null) {
	                
	            	System.out.println(line);
	            	characters = line;
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
	        
	        // converts the string characters to an array 
	        char[] ch = characters.toCharArray();
	        // variables to assess the contents of the array
	        int count;
	        int countHigher;
	        
	        
	        // creates a loop which evaluates the contents of the array
	        for ( count = 0; count < ch.length; count++) 
	        {
	        for ( countHigher = count + 1; countHigher < ch.length;countHigher++) 
	        { 
	        	if (ch [count] == 1-10) {
	        		duplications = ch [count];
	        		if (ch[count] == ch[countHigher]) {
	        		
	        		run ++;
	        	}
	        	}
	        	// if the current run is higher than that of the previous one update the max run
	        	if (run > maxRun) {
	        	maxRun = run + 1;
	        	maxRunLetter = ch[ count ];

	        	}
	        	 if ( ch[count] != ch[countHigher] ) 
	        	{
	        		run = 0;
	        		
	        	}
	        	
	        }
	        	


		}
	 		System.out.println("The max run is:" + maxRun + "," + maxRunLetter);
	 		  try {
	 	            // Assume default encoding.
	 	            FileWriter fileWriter =
	 	                new FileWriter(otherFileName);

	 	            // Always wrap FileWriter in BufferedWriter.
	 	            BufferedWriter bufferedWriter =
	 	                new BufferedWriter(fileWriter);

	 	            // Note that write() does not automatically
	 	            // append a newline character.
	 	            bufferedWriter.write("The max run is:" + maxRun + "," + maxRunLetter);
	 	            ProcessBuilder pb = new ProcessBuilder("Notepad.exe","output.txt");
	 	            pb.start();
	 	   
	 	            // Always close files.
	 	            bufferedWriter.close();
	 	        }
	 	        catch(IOException ex) {
	 	            System.out.println(
	 	                "Error writing to file '"
	 	                + fileName + "'");
	 	            // Or we could just do this:
	 	            // ex.printStackTrace();
	 	        }


	}
		}
}
