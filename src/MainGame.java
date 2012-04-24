import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class MainGame {

	public static void main(String[] args) {
    	JFrame gameWindow = new JFrame();
    	gameWindow.setSize(800, 600);
    	
    	gameWindow.setTitle("H�nga gubben");
    	
    	//Centers the frame in the screen
    	gameWindow.setLocationRelativeTo(null);
    	    	
    	//Creates the menubar at the top of the window
    	JMenuBar menuBar = new JMenuBar();        
        
    	//Creates the menus "Spel" and "Hj�lp" and adds them to the menubar
        JMenu gameMenu = new JMenu("Spel");
        JMenu helpMenu = new JMenu("Hj�lp");
        menuBar.add(gameMenu);
        menuBar.add(helpMenu);
       
        
      //Creates the menu "Nytt spel" with a submenu containing singleplayer and multiplayer choices
        JMenu newGame = new JMenu("Nytt spel");
        
        JMenuItem singlePlayer, multiPlayer;
        newGame.add(singlePlayer = new JMenuItem("1 spelare"));
        newGame.add(multiPlayer = new JMenuItem("2 spelare"));
        gameMenu.add(newGame);
        
        
        //Creates the action for when you click any of the submenus
        singlePlayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Du har klickat p� 1 spelare");
            }
        });
        
        multiPlayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Du har klickat p� 2 spelare");
            }
        });
        
        
        //Creates a menu called "Hj�lp"
        JMenuItem extra = new JMenuItem("Visa Hj�lp");
        helpMenu.add(extra);
        
        //Creates the action for when you click the menu "extra"
        extra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {openHelpWindow();
            }
        });
             
                                
        //creates and shows the menubar and the window
        gameWindow.setJMenuBar(menuBar);
        gameWindow.setVisible(true);
        }
	
	public static void openHelpWindow(){
		JFrame helpWindow = new JFrame();
		helpWindow.setTitle("Hj�lp");
	    JOptionPane.showMessageDialog(helpWindow, "Insert hj�lptext h�r");
}
	
	public static void drawImage(){
	}
	}
