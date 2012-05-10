import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Handles the options in the game such as single and multiplayeraction and the different windowoptions. 
 * @author Sandra Grosz and Denise Nordl�f
 * @version Version 1
 */
public class GameOptions implements KeyListener{
	private static JFrame gameWindow;
	private static JPanel content;
	private static WordHandler WH;
	private static JLabel wordLabel;
	private static Keyboard keyboard;
	private static String multiplayerWord = "";
	
	public GameOptions(JFrame gameWindow, JPanel content){
		GameOptions.gameWindow = gameWindow;
		GameOptions.content = content;
        gameWindow.addKeyListener(this);
	}
	
	/**
	 * Starts a new single player game.
	 */
	public static void newSinglePlayerGame(){
		content.removeAll();
		new Menu(gameWindow);
    	Menu.makeMenuBar();
    	
    	wordLabel = new JLabel("", SwingConstants.CENTER);
        wordLabel.setFont(new Font("Sansserif", Font.PLAIN, 25));
        wordLabel.setSize(800, 50);
        content.add(wordLabel, BorderLayout.CENTER);
        
        WH = new WordHandlerComputer(wordLabel);
        WH.splitWord();
        
        keyboard = new Keyboard(content, WH, wordLabel, gameWindow);
        keyboard.createKeyboard();
        
        keyboard.startPicture();               
        content.revalidate();
        
	}
	
	/**
	 * Starts an new multiplayer game.
	 */
	public static void newMultiplayerGame(){
		content.removeAll();
		new Menu(gameWindow);
    	Menu.makeMenuBar();
    	
        wordLabel = new JLabel("", SwingConstants.CENTER);
        wordLabel.setFont(new Font("Sansserif", Font.PLAIN, 25));
        wordLabel.setSize(800, 50);
        content.add(wordLabel, BorderLayout.CENTER);
        
        boolean badCharacters = true;
        while(badCharacters){
        	enterMultiplayerWord();
        	if(multiplayerWord.matches("^[a-zA-Z������]+$")){
        		badCharacters = false;
        	}
        }
        
        WH = new WordHandlerMultiplayer(wordLabel, multiplayerWord);
        WH.splitWord();
        
        keyboard = new Keyboard(content, WH, wordLabel, gameWindow);
        keyboard.createKeyboard();
        
        keyboard.startPicture(); 
        content.revalidate();  
	}
	
	/**
	 * Creates the helpwindow.
	 */
		public static void openHelpWindow(){
			JFrame helpWindow = new JFrame();
			helpWindow.setTitle("Hj�lp");
		    JOptionPane.showMessageDialog(helpWindow, "Insert hj�lptext h�r");
		}
		
		/**
		 * Creates the about game window.
		 */
		public static void openAboutWindow(){
			JFrame aboutWindow = new JFrame();
			aboutWindow.setTitle("Om H�nga gubben");
		    JOptionPane.showMessageDialog(aboutWindow, "Insert info om H�nga gubben h�r");
		}
		
		/**
		 * Creates the window so the player can write their own game-word.
		 */
		public static void enterMultiplayerWord(){
			JFrame enterWordWindow = new JFrame();
			enterWordWindow.setTitle("V�lj gissningsord");
		    String temp = JOptionPane.showInputDialog(enterWordWindow, "Vilket ord vill ni spela h�nga gubben med?" +
		    		"\n(Se till att inte din medspelare ser vad du fyller i!) \n ", "V�lj gissningsord", 3);
		    if(temp != null){
		    	multiplayerWord = temp;
		    } else{
		    	WordHandler temporary = new WordHandlerComputer(wordLabel);
		        temporary.splitWord();
		        multiplayerWord = temporary.getCorrectWord();
		    }
		}

		/**
		 * When a key is pressed it does nothing.
		 */
		@Override
		public void keyPressed(KeyEvent e) {
			//Do noting
		}

		/**
		 * When a key is released it does nothing.
		 */
		@Override
		public void keyReleased(KeyEvent e) {
			//Do nothing
			
		}

		/**
		 * When a key is typed it checks if the letter has been typed. If not then it adds the
		 * letter to the correct guessed letter or the wrong guessed letter.
		 */
		@Override
		public void keyTyped(KeyEvent e) {
			String guessedLetter = Character.toString(e.getKeyChar());
			if(guessedLetter.matches("^[a-zA-Z������]+$")){
				Keyboard.checkLetter(guessedLetter, Arrays.asList(Keyboard.getButtons()).indexOf(guessedLetter));
			}
		}
}
