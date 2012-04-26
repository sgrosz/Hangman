import java.awt.BorderLayout;

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
	
	public GameOptions(JFrame gameWindow, JPanel content){
		GameOptions.gameWindow = gameWindow;
		GameOptions.content = content;
	}
	
	public static void newSinglePlayerGame(){
		content.removeAll();
		new Menu(gameWindow, content);
    	Menu.makeMenuBar();
    	
        wordLabel = new JLabel("", SwingConstants.CENTER);
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
        content.add(wordLabel, BorderLayout.CENTER);
        
        WH = new WordHandlerMultiplayer(wordLabel);
        WH.splitWord();
        
        Keyboard keyboard = new Keyboard(content, WH, wordLabel);
        keyboard.createKeyboard();
        
        content.revalidate();  
	}
	
	//A method which creates the helpwindow
		public static void openHelpWindow(){
			JFrame helpWindow = new JFrame();
			helpWindow.setTitle("Hj�lp");
		    JOptionPane.showMessageDialog(helpWindow, "Insert hj�lptext h�r");
		}
		
		//A method which creates the about window
		public static void openAboutWindow(){
			JFrame aboutWindow = new JFrame();
			aboutWindow.setTitle("Om H�nga gubben");
		    JOptionPane.showMessageDialog(aboutWindow, "Insert info om H�nga gubben h�r");
		}

}
