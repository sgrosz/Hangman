import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Random;


public class Wordhandler {
	private final static String NAME = Wordhandler.class.getName();
    private final static String FILENAME = "Dictionary.txt";
    private static boolean dictionarysize = false;
    private static int sizeOfDictionary = 0;
    private static String[] correctWord;
    
    public Wordhandler(){
    }
    
    public static void main(String[] args) {
    	dictionary();
    }
    
    public int size(){
    	return sizeOfDictionary;
    }
    
	private static void dictionary(){ //TODO

        LineNumberReader file = null;
        try {
            // FileReader uses "the default character encoding".
            file = new LineNumberReader(new FileReader(FILENAME));
            
            //Checks the size of the dictionary iff it has not been checked in the game.
            if(dictionarysize == false){
            	sizeOfDictionary = sizeOfDictionary(file);
            }
            System.out.println(sizeOfDictionary);
            
            readLineInDictionary(file);
            if (file != null) {
                file.close();
            }
            
        } catch (IOException e) {
            System.err.printf("%s: %s%n", NAME, e);
        }
	}
	
	private static int sizeOfDictionary(LineNumberReader file) throws IOException{ //TODO
        String line;
        int numberOfLines = 0;
        while ((line = file.readLine()) != null) {
        }
        dictionarysize = true;
        return file.getLineNumber();
	}
	
	private static void readLineInDictionary(LineNumberReader file) throws IOException{ //TODO
		Random random = new Random();

		file.setLineNumber(2);
		String theLine = file.readLine();
		System.out.println(theLine);
		
		
	}

}
