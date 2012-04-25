import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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
    	
    	new Menu(gameWindow, WH, wordLabel);
    	Menu.makeMenuBar();
    	
        wordLabel = new JLabel("", SwingConstants.CENTER);
        content.add(wordLabel, BorderLayout.CENTER);
        
        Keyboard keyboard = new Keyboard(content, WH, wordLabel);
        keyboard.createKeyboard();
        
		gameWindow.getContentPane().add(content);
        //creates and shows the menubar and the window
        gameWindow.setResizable(false);
        //content.setVisible(false);
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
