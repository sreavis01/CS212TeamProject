
import java.util.*;

/**
 * Facilitates keyboard input by abstracting details about input parsing,
 * conversions, and exception handling.
 *
 * @author Original Authors: Lewis and Loftus
 * @author Tyler Rose, Sarah Reavis 
 */
public  class Keyboard {

    private static Scanner scan = new Scanner(System.in);

    /**
     * Get a string read from standard input.
     *
     * @return String the string read from standard input
     */
    public  static String readString() {
        String str = "\n";
        
        //if the string is empty, \n, or just blank spaces, we will wait for a new line
        while (str.isBlank() || str.isEmpty()) {
            str = scan.nextLine();
        }
        
        //remove leading and trailing blank spaces and return
        return str.trim();
    }

    /**
     * Get a space-delimited substring (a word) read from standard input.
     *
     * @return String the word read from the standard input
     */
    public static String readWord() {
        return scan.next();
    }

    /**
     * Get a boolean read from standard input.
     *
     * @return boolean a boolean read from standard input
     */
    public static boolean readBoolean() {
        return scan.nextBoolean();
    }

    /**
     * Get a character read from standard input.
     *
     * @return char the character read from standard input
     */
    public static char readChar() {
        char character=0;
        boolean error = false;
        
        //check if the input is valid, if it's not an acceptable char then we reprompt user
        do {
        	
        	 try {
                 character = scan.next().toCharArray()[0];
                 
            	 //invalid input
            	 if(!(Character.toString(character).equalsIgnoreCase("Y")) && 
                  	!(Character.toString(character).equalsIgnoreCase("N")) &&
                	!(Character.toString(character).equalsIgnoreCase("Q"))) {
            		 error = true;
            		 
            		 //print to screen error
            		 System.out.println("Your selection, \'" + character + "\' is not valid. Please try again.");
            		 
            	 }else { error = false;}
            	 
             } catch (ArrayIndexOutOfBoundsException e) {
                 throw new ArrayIndexOutOfBoundsException("The input did not contain any character");
             }
        	 
        }while(error);
        
        return character;
    }

    /**
     * Get an integer read from standard input.
     *
     * @return int the integer read from standard input
     */
    public static int readInt() {
    	int input=0;
    	boolean error = false;
    	
    	do {
    		try {
    			//try to get an integer from the user
    			input = scan.nextInt();
    			
    			// restrict the input to be between 1-3 inclusive
    			if(input>3 || input <1) {error = true;}
    			else {error = false;}
    			
    		}catch(InputMismatchException e) {
    			//if the value entered is not strictly an integer we will prompt the user again
    			System.out.println(e);
    			error = true;
    			scan.nextLine();
    		}
    		if(error) {System.out.println("Invalid input. Please try again. ");}
    		 
    	}while(error); 
    	
        return input;
        
    }

    /**
     * Get a long integer read from standard input.
     *
     * @return long the long read from standard input
     */
    public static long readLong() {
        return scan.nextLong();
    }

    /**
     * Get a float read from standard input.
     *
     * @return the float read from standard input
     */
    public static float readFloat() {
        return scan.nextFloat();
    }

    /**
     * Get a double read from standard input.
     *
     * @return double the double read form standard input
     */
    public static double readDouble() {
        return scan.nextDouble();
    }
}
