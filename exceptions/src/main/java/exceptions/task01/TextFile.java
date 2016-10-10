package exceptions.task01;

import lombok.Getter;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

@SuppressWarnings({"WeakerAccess", "JavaDoc",})
public class TextFile {
    @Getter
    private Path path;

    /**
     * @param folderPath
     * @param fileName
     * @return object of TextFile
     * @throws IOException
     * @throws FileAlreadyExistsException
     * @throws FileNotTxtException
     */
    public static TextFile create(Path folderPath, String fileName) throws IOException {
        return new TextFile(folderPath, fileName, false);
    }

    /**
     * @param folderPath
     * @param fileName
     * @return object of TextFile
     * @throws IOException
     * @throws FileNotFoundException
     * @throws FileNotTxtException
     */
    public static TextFile open(Path folderPath, String fileName) throws IOException {
        return new TextFile(folderPath, fileName, true);
    }

    private TextFile(Path folderPath, String fileName, boolean open) throws IOException {
        if (open) getExistingFile(folderPath, fileName);
        else createNewFile(folderPath, fileName);
    }

    private void getExistingFile(Path folderPath, String fileName) throws IOException {
        File[] filesInDirectory = folderPath.toFile().listFiles();
        if (filesInDirectory == null)
            throw new IOException(fileName);

        for (File f : filesInDirectory) {
            if (f.getName().equals(fileName)) {
                path = f.toPath();
            }
        }
        if (path == null)
            throw new FileNotFoundException(fileName);

        if (!fileName.endsWith(".txt"))
            throw new FileNotTxtException(fileName);
    }

    private void createNewFile(Path folderPath, String fileName) throws IOException {
        if (!fileName.endsWith(".txt"))
            throw new FileNotTxtException(fileName);

        File f = new File(folderPath.toFile(), fileName);
        path = f.toPath();
        Files.createFile(path);
    }

    private void write(String content, boolean append) throws IOException {
        try(FileWriter fw = new FileWriter(path.toFile(), append);
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

    public InputStreamReader read() throws FileNotFoundException {
        return new InputStreamReader(new FileInputStream(path.toFile()));
    }

    public void delete() throws IOException {
        Files.delete(path);
    }
}