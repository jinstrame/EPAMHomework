package exceptions.task01;

import java.io.IOException;

public class FileNotOpenedException extends IOException {
    public FileNotOpenedException() {
        super();
    }

    public FileNotOpenedException(String message) {
        super(message);
    }
}
