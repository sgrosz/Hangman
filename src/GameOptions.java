import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GameOptions {
	private static JFrame gameWindow;
	private static JPanel content;
	private static WordHandler WH;
	private static JLabel wordLabel;
	private static String multiplayerWord;
	
	public GameOptions(JFrame gameWindow, JPanel content){
		GameOptions.gameWindow = gameWindow;
		GameOptions.content = content;
	}
	
	public static void newSinglePlayerGame(){
		content.removeAll();
		new Menu(gameWindow, content);
    	Menu.makeMenuBar();
    	
        wordLabel = new JLabel("", SwingConstants.CENTER);
        wordLabel.setFont(new Font("Sansserif", Font.PLAIN, 25));
        wordLabel.setSize(800, 50);
        content.add(wordLabel, BorderLayout.CENTER);
        
        WH = new WordHandlerComputer(wordLabel);
        WH.splitWord();
        
        Keyboard keyboard = new Keyboard(content, WH, wordLabel);
        keyboard.createKeyboard();
        
        content.revalidate();
        
	}
	
	public static void newMultiplayerGame(){
		content.removeAll();
		new Menu(gameWindow, content);
    	Menu.makeMenuBar();
    	
        wordLabel = new JLabel("", SwingConstants.CENTER);
        wordLabel.setFont(new Font("Sansserif", Font.PLAIN, 25));
        wordLabel.setSize(800, 50);
        content.add(wordLabel, BorderLayout.CENTER);
        
        enterMultiplayerWord();
        WH = new WordHandlerMultiplayer(wordLabel, multiplayerWord);
        WH.splitWord();
        
        Keyboard keyboard = new Keyboard(content, WH, wordLabel);
        keyboard.createKeyboard();
        
        content.revalidate();  
	}
	
	//A method which creates the helpwindow
		public static void openHelpWindow(){
			JFrame helpWindow = new JFrame();
			helpWindow.setTitle("Hjälp");
		    JOptionPane.showMessageDialog(helpWindow, "Insert hjälptext här");
		}
		
		//A method which creates the about window
		public static void openAboutWindow(){
			JFrame aboutWindow = new JFrame();
			aboutWindow.setTitle("Om Hänga gubben");
		    JOptionPane.showMessageDialog(aboutWindow, "Insert info om Hänga gubben här");
		}
		
		//A method which creates the about window
		public static void enterMultiplayerWord(){
			JFrame enterWordWindow = new JFrame();
			enterWordWindow.setTitle("Välj gissningsord");
		    String temp = JOptionPane.showInputDialog(enterWordWindow, "Vilket ord vill ni spela hänga gubben med?" +
		    		"\n(Se till att inte din medspelare ser vad du fyller i!) \n ", "Välj gissningsord", 3);
		    multiplayerWord = temp;
		}

}
