package DateiServer_Klausur.textfile;

import java.io.IOException;

public class TextFileSaveException extends Exception {
    public TextFileSaveException(IOException e) {
    }

    public TextFileSaveException(String message) {
        super(message);
    }

    public TextFileSaveException(Throwable cause, String message) {
        super(message, cause);
    }
}
