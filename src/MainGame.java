import javax.swing.JFrame;


public class MainGame {

	public static void main(String[] args) {
    	JFrame gameWindow = new JFrame();
    	gameWindow.setSize(800, 600);
    	
    	gameWindow.setTitle("Hänga gubben");
    	
    	//Centers the frame in the screen
    	gameWindow.setLocationRelativeTo(null);
    	
    	gameWindow.setVisible(true);
    }
}
