import java.util.Arrays;

public class Wordhandler {
    private static String[] correctWord;
    private static String[] drawWord;
    private static Dictionary dictionary;
    
    public Wordhandler(){
    	dictionary = new Dictionary();
    }
    
    public static void main(String[] args) {
    	Wordhandler wordhandler = new Wordhandler();
    	for(int a = 0; a < 20; a++){
    	splitWord();
    	
    	System.out.println(guessLetter("a"));
    	System.out.println(guessLetter("b"));
    	
    	System.out.println(Arrays.toString(correctWord));
    	System.out.println(Arrays.toString(drawWord));
    	}
    }
    
    /**
     * Splits the chosen word into letters.
     */
    private static void splitWord(){
    	String temp = dictionary.createDictionary();
    	
    	correctWord = (temp.trim().split("\\B"));
    	drawWord = new String[correctWord.length];
    	Arrays.fill(drawWord, "__");
    }
    
    /**
     * Gets the updated word with the correctly guessed word.
     * 
     * @return A array with the word.
     */
    private static String[] getGuessedLetters(){
    	return drawWord;
    }
    
    /**
     * Checks if the guessed letter exists in the word. 
     * 
     * @param guessedLetter
     * @return True if the word contains the guessed letter, else it returns false.
     */
    private static boolean guessLetter(String guessedLetter){
    	if(Arrays.asList(correctWord).contains(guessedLetter)){
    		updateGuessedLetter(guessedLetter);
    		return true;
    	}
    	
    	return false;
    }
    
    /**
     * Updates with the letters the user guessed iff the user guessed
     * a letter the word contains.
     * 
     * @param guessedLetter A string containing the guessed letter.
     */
    private static void updateGuessedLetter(String guessedLetter){
    	
    	for(int a = 0; a < correctWord.length; a++){
    		
    		if(correctWord[a].equals(guessedLetter)){
    			drawWord[a] = guessedLetter;
    		}
    	}
    }
    
}
