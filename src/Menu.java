import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class Menu {
	private static JFrame gameWindow;
	
	public Menu(JFrame gameWindow){
		this.gameWindow = gameWindow;
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
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        
        multiPlayerItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        
        //Creates the menus called "Hjälp" and "Om Hänga gubben"
        JMenuItem helpItem = new JMenuItem("Visa Hjälp");
        helpMenu.add(helpItem);
        
        JMenuItem aboutItem = new JMenuItem("Om Hänga gubben");
        helpMenu.add(aboutItem);
        
        //Creates the action for when you click the menu "Visa hjälp"
        helpItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {openHelpWindow();
            }
        });
        
      //Creates the action for when you click the menu "Om Hänga gubben"
        aboutItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {openAboutWindow();
            }
        });
        
        gameWindow.setJMenuBar(menuBar);
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
}
