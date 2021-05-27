
import java.util.*;

/**
 * Facilitates keyboard input by abstracting details about input parsing,
 * conversions, and exception handling.
 *
 * @author Original Authors: Lewis and Loftus
 * @author Tyler Rose
 */
public class Keyboard {

    private static Scanner scan = new Scanner(System.in);
    /*
    
        This is the error handling section of the Keyboard class
    
     */
    private static boolean printErrors = true;
    private static int errorCount = 0;

    /**
     * The current error count
     *
     * @return int the number of errors
     */
    public static int getErrorCount() {
        return errorCount;
    }

    /**
     * Resets the current error count
     *
     * @param count a useless and misleading parameter that really just needs to
     * be removed since this is setting the count to zero anyways...
     */
    public static void resetErrorCount(int count) {
        errorCount = 0;
    }

    /**
     * Indicates whether input errors are currently printed to standard output.
     *
     * @return boolean True if they are printed to standard output, False if not
     */
    public static boolean getPrintErrors() {
        return printErrors;
    }

    /**
     * Sets whether input errors are to be printed to standard output.
     *
     * @param flag a boolean value where true will print to standard output
     */
    public static void setPrintErrors(boolean flag) {
        printErrors = flag;
    }

    /**
     * Increments the error count and prints the error message if appropriate.
     *
     * @param str the error message
     */
    private static void error(String str) {
        errorCount++;
        if (printErrors) {
            System.out.println(str);
        }
    }

    /*
    
        This is the reading section of the Keyboard class
    
     */
    /**
     * Get a string read from standard input.
     *
     * @return String the string read from standard input
     */
    public static String readString() {
        String str = "";
        if (scan.hasNextLine()) {
            str = scan.nextLine();
        } else {
            error("The input didn't receive a valid line");
        }
        scan.reset();
        return str;
    }

    /**
     * Get a space-delimited substring (a word) read from standard input.
     *
     * @return String the word read from the standard input
     */
    public static String readWord() {
        String str = "";
        if (scan.hasNextLine()) {
            str = scan.next();
        } else {
            error("The input didn't receive a valid word");
        }
        scan.reset();
        return str;
    }

    /**
     * Get a boolean read from standard input.
     *
     * @return boolean a boolean read from standard input
     */
    public static boolean readBoolean() {
        Boolean bool = false;
        if (scan.hasNextBoolean()) {
            bool = scan.nextBoolean();
        } else {
            error("The input didn't receive a valid boolean");
        }
        scan.reset();
        return bool;
    }

    /**
     * Get a character read from standard input.
     *
     * @return char the character read from standard input
     */
    public static char readChar() {
        char character = 'x';
        if (scan.hasNext()) {
            character = scan.next().toCharArray()[0];
        } else {
            error("The input didn't receive a valid character");
        }
        scan.reset();
        return character;
    }

    /**
     * Get an integer read from standard input.
     *
     * @return int the integer read from standard input
     */
    public static int readInt() {
        int num = -1;
        if (scan.hasNextInt()) {
            num = scan.nextInt();
        } else {
            error("The input didn't receive a valid character");
        }
        scan.reset();
        return num;
    }

    /**
     * Get a long integer read from standard input.
     *
     * @return long the long read from standard input
     */
    public static long readLong() {
        long num = -1L;
        if (scan.hasNextLong()) {
            num = scan.nextLong();
        } else {
            error("The input didn't receive a valid long");
        }
        scan.reset();
        return num;
    }

    /**
     * Get a float read from standard input.
     *
     * @return the float read from standard input
     */
    public static float readFloat() {
        float num = -1L;
        if (scan.hasNextFloat()) {
            num = scan.nextFloat();
        } else {
            error("The input didn't receive a valid float");
        }
        scan.reset();
        return num;
    }

    /**
     * Get a double read from standard input.
     *
     * @return double the double read form standard input
     */
    public static double readDouble() {
        double num = -1L;
        if (scan.hasNextDouble()) {
            num = scan.nextDouble();
        } else {
            error("The input didn't receive a valid double");
        }
        scan.reset();
        return num;
    }
}
