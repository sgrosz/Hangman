import java.util.Arrays;

import javax.swing.JLabel;


public class WordHandlerMultiplayer implements WordHandler{
	private static String[] correctWord;
    private static String[] drawWord;
    private static JLabel wordLabel;
    private static String multiplayerWord;
    
    public WordHandlerMultiplayer(JLabel wordLabel, String multiplayerWord){
    	WordHandlerMultiplayer.wordLabel = wordLabel;
    	WordHandlerMultiplayer.multiplayerWord = multiplayerWord;
    }
    
    @Override
    public void splitWord(){
    	splitWordMultiplayer(multiplayerWord);
    }

    public void splitWordMultiplayer(String multiPlayerWord) {
    	String temp = multiplayerWord;
    	
    	correctWord = (temp.toUpperCase().split("(?<=\\G.{1})"));
    	drawWord = new String[correctWord.length];
    	Arrays.fill(drawWord, "__ ");
    	if(Arrays.asList(correctWord).contains(" ")){
    		updateGuessedLetter(" ");
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
     * Updates with the letters the user guessed iff the user guessed
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
		String correct = "";
		String guessedWord = "";
    	for(int i = 0; i < drawWord.length; i++){
    		if(drawWord[i].equals("   ")){
    			guessedWord += " ";
    		} else{
    			guessedWord += drawWord[i];
    		}
    		correct += correctWord[i];
    	}
		return guessedWord.equals(correct);
	}

}
