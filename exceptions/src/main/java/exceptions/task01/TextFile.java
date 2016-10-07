package exceptions.task01;

import lombok.Getter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class TextFile {
    @Getter
    private String name;
    @Getter
    private Path fullPath;
    @Getter
    private boolean accessible;

    TextFile(String name, String path) throws IOException{
        accessible = false;

        String fullPath;
        if (path.endsWith("\\"))
            fullPath = path + name + ".txt";
        else fullPath = path + "\\" + name + ".txt";

        this.fullPath = Files.createFile(Paths.get(fullPath));

        if (Files.exists(this.fullPath)) {
            accessible = true;
        }
    }

    private void write(String content, boolean append) throws IOException{
        if (!accessible)
            throw new TextFileNotAccessibleException("File do not accessible");

        try(FileWriter fw = new FileWriter(fullPath.toFile(), append);
            BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(content);
        }
    }

    public void wtiteToEnd(String content) throws IOException {
        write(content, true);
    }

    public void reWrite(String content) throws IOException {
        write(content, false);
    }
}
