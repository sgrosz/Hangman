import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;


public class Keyboard {
	private static JPanel content;
	private static WordHandler WH;
	private static JLabel wordLabel;
	
	public Keyboard(JPanel content, WordHandler WH, JLabel wordLabel){
		Keyboard.content = content;
		Keyboard.WH = WH;
		Keyboard.wordLabel = wordLabel;
	}

	public void createKeyboard(){
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
    		final String temp = buttons[i].getText().toLowerCase();
    		final int placement = i;
    		buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                	if(WH.guessLetter(temp)){
                		wordWriter();
                		System.out.println(WH.matchingWords());
                	}
                	
                	buttons[placement].setEnabled(false);
                }
            }); 
    	    panel.add(buttons[i]);
    	}
    	
    	panel.setPreferredSize(new Dimension(600,120));
    	panel.setBackground(Color.LIGHT_GRAY);
    	content.add(panel, BorderLayout.SOUTH);
	}
	
	private static void wordWriter(){
		wordLabel.setText(WH.getGuessedLetters());
	}
}
