package DateiServer_Klausur.textfile;

import java.io.IOException;

public class TextFileLoadException extends Exception {
    public TextFileLoadException(IOException e) {
    }

    public TextFileLoadException(String message) {
        super(message);
    }

    public TextFileLoadException(String message, Throwable cause) {
        super(message, cause);
    }
}
