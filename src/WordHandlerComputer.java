import java.util.Arrays;

public class WordHandlerComputer implements WordHandler{
    private static String[] correctWord;
    private static String[] drawWord;
    private static Dictionary dictionary;
    
    public WordHandlerComputer(){
    	dictionary = new Dictionary();
    }
    
    /**
     * Splits the chosen word into letters.
     */
    @Override
    public void splitWord(){
    	String temp = dictionary.createDictionary();
    	
    	correctWord = (temp.toLowerCase().split("(?<=\\G.{1})"));
    	drawWord = new String[correctWord.length];
    	Arrays.fill(drawWord, "__ ");
    	
    	if(Arrays.asList(correctWord).contains(" ")){
    		updateGuessedLetter("    ");
    	}
    }
    
    /**
     * Gets the updated word with the correctly guessed word.
     * 
     * @return A array with the word.
     */
    public String[] getGuessedLetters(){
    	return drawWord;
    }
    
    /**
     * Checks if the guessed letter exists in the word. 
     * 
     * @param guessedLetter
     * @return True if the word contains the guessed letter, else it returns false.
     */
    public boolean guessLetter(String guessedLetter){
    	guessedLetter = guessedLetter.toLowerCase();
    	if(Arrays.asList(correctWord).contains(guessedLetter)){
    		updateGuessedLetter(guessedLetter);
    		return true;
    	}
    	
    	return false;
    }
    
    /**
     * Updates with the letters the user guessed if the user guessed
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
