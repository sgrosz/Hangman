import java.util.Arrays;


public class WordHandlerMultiplayer implements WordHandler{
	private static String[] correctWord;
    private static String[] drawWord;

    @Override
	public void splitWord() {
    	String temp = "Jag �r glad"; //TODO
    	
    	correctWord = (temp.split("(?<=\\G.{1})"));
    	drawWord = new String[correctWord.length];
    	Arrays.fill(drawWord, "__");
    	System.out.println(Arrays.asList(correctWord).toString());
    	if(Arrays.asList(correctWord).contains(" ")){
    		updateGuessedLetter(" ");
    	}
	}
    
	/**
     * Gets the updated word with the correctly guessed word.
     * 
     * @return A array with the word.
     */
    @Override
    public String[] getGuessedLetters(){
    	return drawWord;
    }
    
    /**
     * Checks if the guessed letter exists in the word. 
     * 
     * @param guessedLetter
     * @return True if the word contains the guessed letter, else it returns false.
     */
    @Override
    public boolean guessLetter(String guessedLetter){
    	if(Arrays.asList(correctWord).contains(guessedLetter)){
    		updateGuessedLetter(guessedLetter);
    		System.out.println(Arrays.asList(drawWord).toString());
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
