package exceptions.task01;


import lombok.Getter;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;

@SuppressWarnings("WeakerAccess")
public class FileSystemBrowser {

    private Iterable<Path> rootDirectories;

    @Getter
    private Path currentPath;

    private File[] currentDirContent;

    FileSystemBrowser() {
        rootDirectories = FileSystems.getDefault().getRootDirectories();
        currentPath = rootDirectories.iterator().next();
        currentDirContent = currentPath.toFile().listFiles();
    }

    public void ls() {
        if (currentPath == null || currentDirContent == null) {
            for (Path p : rootDirectories) {
                System.out.println(p.toString());
            }
            return;
        }

        for (File f : currentDirContent) {
            System.out.print("\t");
            System.out.println(f.getName());
        }
    }

    public void cd(String to) throws NotDirectoryException, FileNotFoundException {
        boolean found = false;

        if (to.equals("../")) {
            Path tmpPath = currentPath.getParent();
            if (tmpPath != null) {
                currentPath = tmpPath;
                currentDirContent = currentPath.toFile().listFiles();
            }
            return;
        }

        for (File f : currentDirContent) {
            if (!f.getName().equals(to))
                continue;

            if (!f.isDirectory()) {
                throw new NotDirectoryException(to);
            }

            currentPath = f.toPath();
            currentDirContent = f.listFiles();
            found = true;
        }
        if (!found)
            throw new FileNotFoundException(to);
    }

    public TextFile openTextFile(String fileToOpen) throws FileNotOpenedException {
        for (File f : currentDirContent) {
            if (!f.getName().equals(fileToOpen))
                continue;
            if (!f.isFile())
                System.out.println(fileToOpen + "is not a file");

            if (!f.getName().endsWith(".txt"))
                System.out.println(fileToOpen + " is not a txt file");

            try {
                return new TextFile(fileToOpen, currentPath.toAbsolutePath().toString());
            }
            catch (Exception e) {
                throw new FileNotOpenedException(fileToOpen + " cant be opened\n" + e.getMessage());
            }
        }
        return null;
    }
}
