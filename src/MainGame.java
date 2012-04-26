import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainGame {
	private static JFrame gameWindow;
	private static JPanel content;

	public static void main(String[] args) {
    	gameWindow = new JFrame();
    	gameWindow.setSize(800, 600);
    	gameWindow.setTitle("Hänga gubben");
    	
    	//Centers the frame in the screen
    	gameWindow.setLocationRelativeTo(null);
    	
    	content = new JPanel(new BorderLayout(1,3));
        
		gameWindow.getContentPane().add(content);
        //creates and shows the menubar and the window
        gameWindow.setResizable(false);
        //content.setVisible(false);
        gameWindow.setVisible(true);
        
        new GameOptions(gameWindow, content);
		GameOptions.newSinglePlayerGame();
	}	
}
