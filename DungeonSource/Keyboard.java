
import java.io.*;
import java.util.*;

/**
 * Facilitates keyboard input by abstracting details about input parsing,
 * conversions, and exception handling.
 *
 * @author Original Authors: Lewis and Loftus
 * @author Tyler Rose
 */
public class Keyboard {

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
    
        This is the tokanized input stream section of the Keyboard class
    
     */
    private static String current_token = null;
    private static StringTokenizer reader;

    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Gets the next input token assuming it may be on subsequent input lines.
     *
     * @return String the next input token
     */
    private static String getNextToken() {
        return getNextToken(true);
    }

    /**
     * Gets the next input token, which may already have been read.
     *
     * @param skip boolean value that determines if subsequent liens are used
     * @return String the next input token
     */
    private static String getNextToken(boolean skip) {
        String token;

        if (current_token == null) {
            token = getNextInputToken(skip);
        } else {
            token = current_token;
            current_token = null;
        }

        return token;
    }

    /**
     * Gets the next token from the input, which may come from the current input
     * line or a subsequent one. The parameter determines if subsequent lines
     * are used.
     *
     * @param skip boolean value that determines if subsequent liens are used
     * @return String the next input token
     */
    private static String getNextInputToken(boolean skip) {
        final String delimiters = " \t\n\r\f";
        String token = null;

        try {
            if (reader == null) {
                reader = new StringTokenizer(in.readLine(), delimiters, true);
            }

            while (token == null
                    || ((delimiters.indexOf(token) >= 0) && skip)) {
                while (!reader.hasMoreTokens()) {
                    reader = new StringTokenizer(in.readLine(), delimiters, true);
                }

                token = reader.nextToken();
            }
        } catch (Exception exception) {
            token = null;
        }

        return token;
    }

    //-----------------------------------------------------------------
    //  Returns true if there are no more tokens to read on the
    //  current input line.
    //-----------------------------------------------------------------
    /**
     * Check if there are no more tokens to read on the current input line.
     *
     * @return boolean True if there are no more tokens, False if not
     */
    public static boolean endOfLine() {
        return !reader.hasMoreTokens();
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
        String str;

        try {
            str = getNextToken(false);
            while (!endOfLine()) {
                str = str + getNextToken(false);
            }
        } catch (Exception exception) {
            error("Error reading String data, null value returned.");
            str = null;
        }
        return str;
    }

    /**
     * Get a space-delimited substring (a word) read from standard input.
     *
     * @return String the word read from the standard input
     */
    public static String readWord() {
        String token;
        try {
            token = getNextToken();
        } catch (Exception exception) {
            error("Error reading String data, null value returned.");
            token = null;
        }
        return token;
    }

    /**
     * Get a boolean read from standard input.
     *
     * @return boolean a boolean read from standard input
     */
    public static boolean readBoolean() {
        String token = getNextToken();
        boolean bool;
        try {
            if (token.toLowerCase().equals("true")) {
                bool = true;
            } else if (token.toLowerCase().equals("false")) {
                bool = false;
            } else {
                error("Error reading boolean data, false value returned.");
                bool = false;
            }
        } catch (Exception exception) {
            error("Error reading boolean data, false value returned.");
            bool = false;
        }
        return bool;
    }

    /**
     * Get a character read from standard input.
     *
     * @return char the character read from standard input
     */
    public static char readChar() {
        String token = getNextToken(false);
        char value;
        try {
            if (token.length() > 1) {
                current_token = token.substring(1, token.length());
            } else {
                current_token = null;
            }

            value = token.charAt(0);
        } catch (Exception exception) {
            error("Error reading char data, MIN_VALUE value returned.");
            value = Character.MIN_VALUE;
        }

        return value;
    }

    /**
     * Get an integer read from standard input.
     *
     * @return int the integer read from standard input
     */
    public static int readInt() {
        String token = getNextToken();
        int value;
        try {
            value = Integer.parseInt(token);
        } catch (Exception exception) {
            error("Error reading int data, MIN_VALUE value returned.");
            value = Integer.MIN_VALUE;
        }
        return value;
    }

    /**
     * Get a long integer read from standard input.
     *
     * @return long the long read from standard input
     */
    public static long readLong() {
        String token = getNextToken();
        long value;
        try {
            value = Long.parseLong(token);
        } catch (Exception exception) {
            error("Error reading long data, MIN_VALUE value returned.");
            value = Long.MIN_VALUE;
        }
        return value;
    }

    /**
     * Get a float read from standard input.
     *
     * @return the float read from standard input
     */
    public static float readFloat() {
        String token = getNextToken();
        float value;
        try {
            value = (new Float(token)).floatValue();
        } catch (Exception exception) {
            error("Error reading float data, NaN value returned.");
            value = Float.NaN;
        }
        return value;
    }

    /**
     * Get a double read from standard input.
     *
     * @return double the double read form standard input
     */
    public static double readDouble() {
        String token = getNextToken();
        double value;
        try {
            value = (new Double(token)).doubleValue();
        } catch (Exception exception) {
            error("Error reading double data, NaN value returned.");
            value = Double.NaN;
        }
        return value;
    }
}
