import java.util.Arrays;

import javax.swing.JLabel;

public class WordHandlerComputer implements WordHandler{
    private static String[] correctWord;
    private static String[] drawWord;
    private static Dictionary dictionary;
    private static JLabel wordLabel;
    
    public WordHandlerComputer(JLabel wordLabel){
    	dictionary = new Dictionary();
    	WordHandlerComputer.wordLabel = wordLabel;
    }
    
    /**
     * Splits the chosen word into letters.
     */
    @Override
    public void splitWord(){
    	String temp = dictionary.createDictionary();
    	
    	correctWord = (temp.toUpperCase().split("(?<=\\G.{1})"));
    	drawWord = new String[correctWord.length];
    	Arrays.fill(drawWord, "__ ");
    	
    	if(Arrays.asList(correctWord).contains(" ")){
    		updateGuessedLetter("    ");
    	}
    	wordLabel.setText(getGuessedLetters());
    }
    
    /**
     * Gets the updated word with the correctly guessed word.
     * 
     * @return A array with the word.
     */
    @Override
    public String getGuessedLetters(){
    	String temp = "";
    	for(int i = 0; i < drawWord.length; i++){
    		temp += drawWord[i];
    	}
    	return temp;
    }
    
    /**
     * Checks if the guessed letter exists in the word. 
     * 
     * @param guessedLetter
     * @return True if the word contains the guessed letter, else it returns false.
     */
    @Override
    public boolean guessLetter(String guessedLetter){
    	guessedLetter = guessedLetter.toUpperCase();
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
    			if(guessedLetter.equals(" ")){
    				drawWord[a] = "   ";
    			} else{
    				drawWord[a] = guessedLetter;
    			}
    		}
    	}
    }

	@Override
	public boolean matchingWords() {
		return drawWord.equals(correctWord);
	}
    
}
