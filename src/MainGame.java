import java.awt.BorderLayout;
<<<<<<< HEAD
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
=======
import java.awt.Color;
import java.awt.List;
>>>>>>> 2e0d5133e6bcdaa56fa22ed6345e81e07f8c302a
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
<<<<<<< HEAD

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
=======
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
>>>>>>> 2e0d5133e6bcdaa56fa22ed6345e81e07f8c302a


public class MainGame {
	private static JFrame gameWindow;
	private static JPanel content;
	private static WordHandler WH;
	private static JLabel wordLabel;

	private static JFrame gameWindow;
	private static JPanel panel;
	private static WordHandler WH;
	private static JLabel wordLabel;

	public static void main(String[] args) {
    	gameWindow = new JFrame();
    	gameWindow.setSize(800, 600);
    	   	
    	gameWindow.setTitle("Hänga gubben");
    	
    	
    	//Centers the frame in the screen
    	gameWindow.setLocationRelativeTo(null);

    	
<<<<<<< HEAD
=======
    	    	
>>>>>>> 2e0d5133e6bcdaa56fa22ed6345e81e07f8c302a
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
        
        //målar ut bilden 
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
        wordLabel = new JLabel("");
<<<<<<< HEAD
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
    			buttons[i] = new JButton("Å");
    		} else if(i == 27){
    			buttons[i] = new JButton("Ä");
    		} else if(i == 28){
    			buttons[i] = new JButton("Ö");
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
=======
        panel.add(wordLabel, BorderLayout.CENTER);
        WH = new WordHandlerComputer();
        WH.splitWord();
        wordWriter();
>>>>>>> 2e0d5133e6bcdaa56fa22ed6345e81e07f8c302a
        //creates and shows the menubar and the window
        gameWindow.setJMenuBar(menuBar);
        gameWindow.setResizable(false);
        gameWindow.setVisible(true);
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
<<<<<<< HEAD
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
=======
>>>>>>> 2e0d5133e6bcdaa56fa22ed6345e81e07f8c302a
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
		panel = new JPanel();
		try {
			
			myPicture = ImageIO.read(new File("ful.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon( myPicture ));
			panel.add( picLabel, BorderLayout.NORTH );
		} catch (IOException e) {
		}
		gameWindow.getContentPane().add(panel);
	}
	}
