import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/**
 * Creates the on-screen keyboard.
 * 
 * @author Sandra Grosz and Denise Nordlöf
 * @version Version 1
 */
public class Keyboard {
	private static JPanel content;
	private static WordHandler WH;
	private static JLabel wordLabel;
	private static JFrame gameWindow;
	private static JLabel picLabel = new JLabel("", SwingConstants.CENTER);
	private static int i=0;
	private static BufferedImage myPicture;
	private static JButton[] buttons;
	private static String[] charachters = {"q","w","e","r","t","y","u","i","o","p","å","a","s","d","f","g","h","j","k","l","ö","ä","z","x","c","v","b","n","m"};
	
	public Keyboard(JPanel content, WordHandler WH, JLabel wordLabel, JFrame gameWindow){ //TODO VINST TEXT
		Keyboard.content = content;
		Keyboard.WH = WH;
		Keyboard.wordLabel = wordLabel;
		Keyboard.gameWindow = gameWindow;
		picLabel.setSize(800,250);
		i = 0;
	}

	/**
	 * Creates the keyboard.
	 */
	public void createKeyboard(){
		final JPanel panel = new JPanel(new GridLayout(3,11));
		
    	Font f = new Font("SansSerif", Font.PLAIN, 15);
        UIManager.put("Button.font", f);
    	
        buttons = new JButton[33];
    	for(int i = 0; i < buttons.length; i++){
    		if(i >= 29){
    			buttons[i] = new JButton(" ");
    			buttons[i].setEnabled(false);
    			buttons[i].setBackground(Color.lightGray);
    		}else{
    	     buttons[i] = new JButton(charachters[i].toUpperCase());
    		}
    		final String temp = buttons[i].getText().toLowerCase();
    		final int placement = i;
    		buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                	checkLetter(temp, placement);
                }
            }); 
    	    panel.add(buttons[i]);
    	}
    	panel.setPreferredSize(new Dimension(600,120));
    	panel.setBackground(Color.LIGHT_GRAY);
    	content.add(panel, BorderLayout.SOUTH);
	}
	
	/**
	 * Gets the buttons in the String-array.
	 * @return A string-array of the letters of the keyboard.
	 */
	public static String[] getButtons(){
		return charachters;
	}
	
	/**
	 * Checks if the letter typed/pressed matches the word or not. When a letter is used it
	 * makes it unusable later in the same game.
	 * @param temp A string of the guessed letter
	 * @param placement A int containing the placement of the button containing the letter.
	 */
	public static void checkLetter(String temp, int placement){
		if(buttons[placement].isEnabled()){
			if(WH.guessLetter(temp)){
	    		wordWriter();
	    		if(WH.matchingWords()){
	    			for(int a = 0; a < buttons.length; a++){
	    				buttons[a].setEnabled(false);
	    				buttons[a].setBackground(Color.lightGray);
	    			}
	    		}
	    	}else{
	    		if(!manPainter()){
	    			for(int a = 0; a < buttons.length; a++){
	    				buttons[a].setEnabled(false);
	    				buttons[a].setBackground(Color.lightGray);
	    			}
	    			wordLabel.setText(WH.getCorrectWord());
	    		}
	    	}
	    	
	    	buttons[placement].setEnabled(false);
	    	buttons[placement].setBackground(Color.lightGray);
	    	//Shifts focus back on the JFrame so that the KeyListener still works.
	    	gameWindow.requestFocusInWindow();
		}
	}
	
	/**
	 * Updates the text showing the correct guessed letters.
	 */
	private static void wordWriter(){
		wordLabel.setText(WH.getGuessedLetters());
	}
	
	/**
	 * Sets the start picture.
	 */
	public void startPicture(){
		try {
			myPicture = ImageIO.read(new File("hangman0.jpg"));
			picLabel.setIcon(new ImageIcon( myPicture));
			content.add( picLabel , BorderLayout.NORTH);
		} catch (IOException e) {
		}
	}
	
	/**
	 * Changes the 
	 * @return
	 */
	private static boolean manPainter(){
			 
		String[] stringList = {"hangman1.jpg", "hangman2.jpg", "hangman3.jpg", "hangman4.jpg", "hangman5.jpg", "hangman6.jpg", "hangman7.jpg", "hangman8.jpg", "hangman9.jpg", "hangman10.jpg"};
		
		
			try {
				myPicture = ImageIO.read(new File(stringList[i]));
				picLabel.setIcon(new ImageIcon( myPicture));
				content.add( picLabel , BorderLayout.NORTH);
				content.revalidate();
				i++;
				
				if(i > 9){
					JFrame loseWindow = new JFrame();
					loseWindow.setTitle("Titel");
				    JOptionPane.showMessageDialog(loseWindow, "Du dödade honom!! :'(");
				    return false;
				}
			} catch (IOException e) {
		}	
			
		return true;
	}
}

