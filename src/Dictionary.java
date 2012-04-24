import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 * Handles the dictionary in a file and gets a random word.
 * 
 * @author Sandra Grosz
 * @version 2012-04-16
 *
 */
public class Dictionary {
    private final static String FILENAME = "Dictionary.txt";
    private static boolean dictionarysize = false;
    private static int sizeOfDictionary = 0;
    private static String lastWord = "";
    
    public Dictionary(){
    }

    /**
     * Finds a random word from the dictionary in a file.
     * 
     * @return A random word.
     */
	public String createDictionary(){
        BufferedReader file = null;
        String hangmanWord = lastWord;
        try {            
            //Checks the size of the dictionary iff it has not been checked in the game already.
            if(dictionarysize == false){
            	sizeOfDictionary = sizeOfDictionary(file);
            }
            
            while(hangmanWord.equals(lastWord)){
            	hangmanWord = readLineInDictionary(file);
            }
            
        } catch (IOException e) {
        }
        
        lastWord = hangmanWord;
        return hangmanWord;
	}
	
	/**
	 * Calculates the number of words in the dictionary from an external file.
	 * 
	 * @param file A BufferedReader.
	 * @return The number of words in the dictionary.
	 * @throws IOException If an I/O error occurs
	 */
	private int sizeOfDictionary(BufferedReader file) throws IOException{
		// FileReader uses "the default character encoding".
        file = new BufferedReader(new FileReader(FILENAME));
        
        int numberOfLines = 0;
        while ((file.readLine()) != null) {
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
	private String readLineInDictionary(BufferedReader file) throws IOException{
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
		
		return line.toLowerCase();
	}
}
