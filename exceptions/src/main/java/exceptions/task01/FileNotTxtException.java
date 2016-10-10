package exceptions.task01;

import java.io.IOException;

@SuppressWarnings("WeakerAccess")
public class FileNotTxtException extends IOException {
    public FileNotTxtException() {
        super();
    }

    public FileNotTxtException(String message) {
        super(message);
    }
}
