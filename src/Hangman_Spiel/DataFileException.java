package Hangman_Spiel;

import java.io.FileNotFoundException;

public class DataFileException extends Exception {
    private Exception cause;

    public DataFileException(String message, Exception cause) {
        super(message);
        this.cause = cause;
    }

    public DataFileException(FileNotFoundException message) {
        super(message);
    }

    public Exception getCause() {
        return cause;
    }

}
