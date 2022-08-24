package takeHomeExam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReadingProgram {


	public static void main(String[] args) throws FileNotFoundException  {
		
		
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter file path as String in Java format (exclude quotes, include double slashes):");
	    //Sample path where I actually stored file below
	    //C:\\Users\\Apoorv\\Desktop\\filetakehomexam.txt

	    String filePath = myObj.nextLine();  // Read user input
	    System.out.println("File Path in Java format you entered: " + filePath);  // Output user input
	
		doesFileExist(filePath);
		try {
		if(doesFileExist(filePath)==true) {
			System.out.println("success-file was found and read");
		}
		else if(doesFileExist(filePath)==false){
			System.out.println("fail-file was not found");
		}
		}
		catch (FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}	
		}

	
	   //Method doesFileExist will return true if file exists, and if it's a regular file.
		public static boolean doesFileExist(String path)throws FileNotFoundException 
		{
			File file = new File(path);
			
			if (!file.exists() || !file.isFile())
			{
				return false;
				
			}
			else 
			{
				System.out.println("File exists");
			    System.out.println("File exists and will be read by this program.");
				System.out.println();
				printDictionary(file);
				return true;
			}
			
		}
		
		public static void printDictionary(File f) 
		{
			try
			{
				Scanner sc = new Scanner(f);
				String line;
				int i =1;

				while (sc.hasNextLine())
				{
					line = sc.nextLine();
	        
					String[] splitLine = line.split("-");
	       	 		String[] meaning = splitLine[1].split(",");
	        		System.out.println("Word" + i + ": " + splitLine[0].trim());
					i++;
			
	        		for(int j=0; j < meaning.length; j++)
					{
	            		System.out.println("Meaning" + (j + 1) + ": " + meaning[j].trim());
	        		}
			
					System.out.println();
				}
				sc.close();			
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}

}
