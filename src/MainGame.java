import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;


public class MainGame {
	private static JFrame gameWindow;
	private static JPanel content;
	private static WordHandler WH;
	private static JLabel wordLabel;

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
        
        JMenuItem singlePlayerItem, multiPlayerItem;
        newGame.add(singlePlayerItem = new JMenuItem("1 spelare"));
        newGame.add(multiPlayerItem = new JMenuItem("2 spelare"));
        gameMenu.add(newGame);
        
        //m�lar ut bilden 
        drawImage();
        
        //Creates the action for when you click any of the submenus
        singlePlayerItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                WH = new WordHandlerComputer();
            }
        });
        
        multiPlayerItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	WH = new WordHandlerComputer();
            }
        });
        
        
        //Creates the menus called "Hj�lp" and "Om H�nga gubben"
        JMenuItem helpItem = new JMenuItem("Visa Hj�lp");
        helpMenu.add(helpItem);
        
        JMenuItem aboutItem = new JMenuItem("Om H�nga gubben");
        helpMenu.add(aboutItem);
        
        //Creates the action for when you click the menu "Visa hj�lp"
        helpItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {openHelpWindow();
            }
        });
        
      //Creates the action for when you click the menu "Om H�nga gubben"
        aboutItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {openAboutWindow();
            }
        });
        wordLabel = new JLabel("");
        content.add(wordLabel, BorderLayout.CENTER);
        WH = new WordHandlerComputer();
        WH.splitWord();
        wordWriter();
        
        JPanel panel = new JPanel();
    	panel.setLayout(new GridLayout(3, 10, 5 ,5));
    	
    	Font f = new Font("SansSerif", Font.PLAIN, 15);
        UIManager.put("Button.font", f);
    	
    	final JButton[] buttons = new JButton[29];
    	for(int i = 0; i < buttons.length; i++){
    		if(i < 26){
    	     buttons[i] = new JButton(((char)(i + 'A')) + "");
    		} else if(i == 26){
    			buttons[i] = new JButton("�");
    		} else if(i == 27){
    			buttons[i] = new JButton("�");
    		} else if(i == 28){
    			buttons[i] = new JButton("�");
    		}
    		final String temp = buttons[i].getText();
    		final int placement = i;
    		buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                	WH.guessLetter(temp);
                	buttons[placement].setEnabled(false);
                }
            }); 
    	    panel.add(buttons[i]);
    	}
    	
    	panel.setPreferredSize(new Dimension(600,120));
    	content.add(panel, BorderLayout.SOUTH);
		gameWindow.getContentPane().add(content);
        //creates and shows the menubar and the window
        gameWindow.setJMenuBar(menuBar);
        gameWindow.setResizable(false);
        gameWindow.setVisible(true);
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
	
	private static void wordWriter(){
		String [] word = WH.getGuessedLetters();
		String temp = "";
		for(int i = 0; i < word.length; i++){
			temp += word[i];
		}
		wordLabel.setText(temp);
	}
	
	//A method which draws an image
	public static void drawImage(){
		BufferedImage myPicture;
		content = new JPanel();
		try {
			
			myPicture = ImageIO.read(new File("ful.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon( myPicture ));
			content.add( picLabel, BorderLayout.NORTH );
		} catch (IOException e) {
		}
	} 	
}
