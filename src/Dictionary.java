import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;


public class Dictionary {
    private final static String FILENAME = "Dictionary.txt";
    private static boolean dictionarysize = false;
    private static int sizeOfDictionary = 0;
    
    public Dictionary(){
    	
    }

	public static String createDictionary(){
        BufferedReader file = null;
        String hangmanWord = "";
        try {            
            //Checks the size of the dictionary iff it has not been checked in the game already.
            if(dictionarysize == false){
            	sizeOfDictionary = sizeOfDictionary(file);
            }
            
            hangmanWord = readLineInDictionary(file);
            
        } catch (IOException e) {
        }
        
        return hangmanWord;
	}
	
	/**
	 * Calculates the number of words in the dictionary from an external file.
	 * 
	 * @param file A BufferedReader.
	 * @return The number of words in the dictionary.
	 * @throws IOException If an I/O error occurs
	 */
	private static int sizeOfDictionary(BufferedReader file) throws IOException{ //TODO
		// FileReader uses "the default character encoding".
        file = new BufferedReader(new FileReader(FILENAME));
        
        String line;
        int numberOfLines = 0;
        while ((line = file.readLine()) != null) {
        	numberOfLines++;
        }
        
        if (file != null) {
            file.close();
        }
        
        dictionarysize = true;
        return numberOfLines;
	}
	
	/**
	 * Finds a random word in the dictionary from an external file.
	 * 
	 * @param file A BufferedReader.
	 * @return A random word in the dictionary.
	 * @throws IOException
	 */
	private static String readLineInDictionary(BufferedReader file) throws IOException{
		// FileReader uses "the default character encoding".
        file = new BufferedReader(new FileReader(FILENAME));
		
		Random random = new Random();
		String line;
		int correctLine = 0;
		int randomNumber = random.nextInt(sizeOfDictionary);
		
		while ((line = file.readLine()) != null && correctLine != randomNumber) {
			correctLine++;
        }
		
		if (file != null) {
            file.close();
        }
		
		return line;
	}
}
