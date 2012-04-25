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
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class MainGame {
	private static JFrame gameWindow;
	private static JPanel content;
	private static WordHandler WH;
	private static JLabel wordLabel;

	public static void main(String[] args) {
    	gameWindow = new JFrame();
    	gameWindow.setSize(800, 600);
    	gameWindow.setTitle("Hänga gubben");
    	
    	//Centers the frame in the screen
    	gameWindow.setLocationRelativeTo(null);
    	
    	content = new JPanel(new BorderLayout(1,3));
    	
    	Menu menu = new Menu(gameWindow);
    	menu.makeMenuBar();
    	
        wordLabel = new JLabel("", SwingConstants.CENTER);
        content.add(wordLabel, BorderLayout.CENTER);
        WH = new WordHandlerMultiplayer();
        WH.splitWord();
        
        Keyboard keyboard = new Keyboard(content, WH, wordLabel);
        keyboard.createKeyboard();
        
		gameWindow.getContentPane().add(content);
        //creates and shows the menubar and the window
        gameWindow.setResizable(false);
        gameWindow.setVisible(true);
}
	
	//A method which draws an image
	public static void drawImage(){
		BufferedImage myPicture;
		try {
			
			myPicture = ImageIO.read(new File("ful.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon( myPicture ));
			content.add( picLabel, BorderLayout.NORTH );
		} catch (IOException e) {
		}
	} 	
	
	
	}
