package singleton;

import java.io.PrintWriter;

public class Logger {

    // The single Logger instance
    private static Logger instance;

    // Used for writing log messages into a file
    private PrintWriter writer;

    // Private constructor prevents creating Logger with new
    private Logger() {
        setFileName("log.txt");
    }

    // Returns the only Logger object
    public static Logger getInstance() {

        if (instance == null) {
            instance = new Logger();
        }

        return instance;
    }

    // Changes the log file
    public void setFileName(String fileName) {

        // Close the current file first
        if (writer != null) {
            writer.close();
        }

        try {
            writer = new PrintWriter(fileName);
        } catch (Exception e) {
            System.out.println(
                    "Error opening log file: " + e.getMessage()
            );
        }
    }

    // Writes one message per line
    public void write(String message) {

        try {
            if (writer != null) {
                writer.println(message);
                writer.flush();
            }
        } catch (Exception e) {
            System.out.println(
                    "Error writing log message: " + e.getMessage()
            );
        }
    }

    // Closes the logger
    public void close() {

        try {
            if (writer != null) {
                writer.close();
            }
        } catch (Exception e) {
            System.out.println(
                    "Error closing logger: " + e.getMessage()
            );
        }
    }
}