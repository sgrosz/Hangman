
public interface WordHandler {
	
	/**
     * Splits the chosen word into letters.
     */
	public void splitWord();
	
	/**
     * Gets the updated word with the correctly guessed word.
     * 
     * @return A array with the word.
     */
	public String getGuessedLetters();
	
	/**
     * Checks if the guessed letter exists in the word. 
     * 
     * @param guessedLetter
     * @return True if the word contains the guessed letter, else it returns false.
     */
	public boolean guessLetter(String guessedLetter);
	
	
	

}
