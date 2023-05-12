package TransactionManager_Klausur;

public class DataFileException extends Exception {

    private Exception cause;

    public DataFileException(String message, Exception cause) {
        super(message);
        this.cause = cause;
    }

    public DataFileException(String message) {
        super(message);
    }

    public Exception getCause() {
        return cause;
    }
}

