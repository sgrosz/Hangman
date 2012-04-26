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
        
    	//Creates the menus "Spel" and "Hjälp" and adds them to the menubar
        JMenu gameMenu = new JMenu("Spel");
        JMenu helpMenu = new JMenu("Hjälp");
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
        
        //Creates the menus called "Hjälp" and "Om Hänga gubben"
        JMenuItem helpItem = new JMenuItem("Visa Hjälp");
        helpMenu.add(helpItem);
        
        JMenuItem aboutItem = new JMenuItem("Om Hänga gubben");
        helpMenu.add(aboutItem);
        
        //Creates the action for when you click the menu "Visa hjälp"
        helpItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {GameOptions.openHelpWindow();
            }
        });
        
      //Creates the action for when you click the menu "Om Hänga gubben"
        aboutItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {GameOptions.openAboutWindow();
            }
        });
        
        JMenuItem endGame = new JMenuItem("Avsluta spelet");
        gameMenu.add(endGame);
        
        endGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	System.exit(1);
            }
        });
        
        gameWindow.setJMenuBar(menuBar);
	}
}
