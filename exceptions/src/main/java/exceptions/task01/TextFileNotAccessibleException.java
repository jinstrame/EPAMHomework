package exceptions.task01;

import java.io.IOException;

@SuppressWarnings("WeakerAccess")
public class TextFileNotAccessibleException extends IOException {
    /**
     * Constructs an {@code IOException} with {@code null}
     * as its error detail message.
     */
    public TextFileNotAccessibleException() {
        super();
    }

    /**
     * Constructs an {@code IOException} with the specified detail message.
     *
     * @param message The detail message (which is saved for later retrieval
     *                by the {@link #getMessage()} method)
     */
    public TextFileNotAccessibleException(String message) {
        super(message);
    }
}
