import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Random;


public class Wordhandler {
    private static String[] correctWord;
    
    public Wordhandler(){
    }
    
    public static void main(String[] args) {
    	Dictionary dictionary = new Dictionary();
    	String temp = dictionary.createDictionary();
    	System.out.println(temp);
    }
    
}
