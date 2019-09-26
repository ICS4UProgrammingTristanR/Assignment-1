package StringSt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import java.io.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class StringStuffGui {
	// The name of the file to open.
		public static String fileName = "input.txt";
		public char[] toCharArray() {  
		    // Cannot use Arrays.copyOf because of class initialization order issues  
		    char[] result = new char[characters.length()];  
		    System.arraycopy(characters, 0, result, 0, characters.length());  
		    return result;  
		}
		public static String otherFileName = "output.txt";	
	    public static int run ;
	    public static int maxRun;
	    public static char maxRunLetter;
	    public static String characters;
		
		
	protected Shell shlRun;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			StringStuffGui window = new StringStuffGui();
			window.open();
			
			 // This will reference one line at a time
	         String line = null;	
	    
			
	        try {
	            // FileReader reads text files in the default encoding.
	            FileReader fileReader = new FileReader(fileName);
	          

	            // Always wrap FileReader in BufferedReader.
	            BufferedReader bufferedReader = 
	                new BufferedReader(fileReader);
	            
	        

	            while((line = bufferedReader.readLine()) != null) {
	                
	            	
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlRun.open();
		shlRun.layout();
		while (!shlRun.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlRun = new Shell();
		shlRun.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		shlRun.setSize(450, 300);
		shlRun.setText("String Stuff");
		
		Button btnCheckMaxRun = new Button(shlRun, SWT.NONE);
		btnCheckMaxRun.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
					
					
					

			       
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
			        	if (ch[count] == ch[countHigher]) {
			        		
			        		run ++;
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
			 		
			}
		});
		btnCheckMaxRun.setBounds(39, 116, 95, 25);
		btnCheckMaxRun.setText("Check Max Run");
		
		Label lblInput = new Label(shlRun, SWT.NONE);
		lblInput.setBounds(171, 10, 55, 15);
		lblInput.setText("--");
		
		Label lblOutput = new Label(shlRun, SWT.NONE);
		lblOutput.setBounds(171, 217, 55, 15);
		lblOutput.setText("--");

	}
}
