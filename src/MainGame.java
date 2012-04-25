import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;


public class MainGame {

	public static void main(String[] args) {
		final WordHandler WH = new WordHandlerComputer();
		WH.splitWord();
    	JFrame gameWindow = new JFrame();
    	gameWindow.setSize(800, 600);
    	
    	gameWindow.setTitle("Hänga gubben");
    	
    	//Centers the frame in the screen
    	gameWindow.setLocationRelativeTo(null);
    	
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
    	JPanel content = new JPanel(new BorderLayout());
    	content.add(panel, BorderLayout.SOUTH);
    	gameWindow.getContentPane().add(content, BorderLayout.CENTER);
    	
    	gameWindow.setVisible(true);
    	
    }
}
