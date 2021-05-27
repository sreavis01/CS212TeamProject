
import java.util.*;

/**
 * Facilitates keyboard input by abstracting details about input parsing,
 * conversions, and exception handling.
 *
 * @author Original Authors: Lewis and Loftus
 * @author Tyler Rose
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
        while (str.equals("\n") || str.equals("")) {
            str = scan.nextLine();
        }
        return str;
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
        char character;
        try {
            character = scan.next().toCharArray()[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("The input did not contain any character");
        }
        return character;
    }

    /**
     * Get an integer read from standard input.
     *
     * @return int the integer read from standard input
     */
    public static int readInt() {
        return scan.nextInt();
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
