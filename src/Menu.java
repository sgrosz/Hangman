import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class Menu {
	private static JFrame gameWindow;
	private static JPanel content;
	
	public Menu(JFrame gameWindow, JPanel content){
		Menu.gameWindow = gameWindow;
		Menu.content = content;
	}

	public static void makeMenuBar(){
		//Creates the menubar at the top of the window
    	JMenuBar menuBar = new JMenuBar();        
        
    	//Creates the menus "Spel" and "Hj�lp" and adds them to the menubar
        JMenu gameMenu = new JMenu("Spel");
        JMenu helpMenu = new JMenu("Hj�lp");
        menuBar.add(gameMenu);
        menuBar.add(helpMenu);
        
        //Creates the menu "Nytt spel" with a submenu containing singleplayer and multiplayer choices
        JMenu newGame = new JMenu("Nytt spel");
        
        JMenuItem singlePlayerItem, multiPlayerItem;
        newGame.add(singlePlayerItem = new JMenuItem("1 spelare"));
        newGame.add(multiPlayerItem = new JMenuItem("2 spelare"));
        gameMenu.add(newGame);
        
        //Creates the action for when you click any of the submenus
        singlePlayerItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	new GameOptions(gameWindow, content);
				GameOptions.newSinglePlayerGame();
            }
        });
        
        multiPlayerItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	new GameOptions(gameWindow, content);
				GameOptions.newMultiplayerGame();
            }
        });
        
        //Creates the menus called "Hj�lp" and "Om H�nga gubben"
        JMenuItem helpItem = new JMenuItem("Visa Hj�lp");
        helpMenu.add(helpItem);
        
        JMenuItem aboutItem = new JMenuItem("Om H�nga gubben");
        helpMenu.add(aboutItem);
        
        //Creates the action for when you click the menu "Visa hj�lp"
        helpItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {GameOptions.openHelpWindow();
            }
        });
        
      //Creates the action for when you click the menu "Om H�nga gubben"
        aboutItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {GameOptions.openAboutWindow();
            }
        });
        
        gameWindow.setJMenuBar(menuBar);
	}
}
