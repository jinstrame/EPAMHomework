package exceptions.task01;

import java.io.IOException;

@SuppressWarnings("WeakerAccess")
public class TextFileNotAccessibleException extends IOException {
    public TextFileNotAccessibleException() {
        super();
    }

    public TextFileNotAccessibleException(String message) {
        super(message);
    }
}
