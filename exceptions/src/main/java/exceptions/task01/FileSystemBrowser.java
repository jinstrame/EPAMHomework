package exceptions.task01;


import lombok.Getter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

@SuppressWarnings("WeakerAccess")
public class FileSystemBrowser {

    private Iterable<Path> rootDirectories;

    private Path backupPath;

    @Getter
    private Path currentPath;

    private File[] currentDirContent;

    public void backup(){
        backupPath = currentPath;
    }

    public void restore(){
        currentPath = backupPath;
        updateContent();
    }

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

    public void lsRoot(){
        for (Path p : rootDirectories){
            System.out.print("\t");
            System.out.println(p.toAbsolutePath().toString());
        }
    }

    public void cdRoot(String root) {
        for (Path p : rootDirectories){
            if (p.toAbsolutePath().toString().equals(root)) {
                currentPath = p;
                updateContent();
                return;
            }
        }
        RootNotFoundHandler(root);
    }

    void reverseCD(){
        Path tmpPath = currentPath.getParent();
        if (tmpPath != null) {
            currentPath = tmpPath;
            updateContent();
        }
    }

    public void cd(String to) throws Exception {
        boolean found = false;

        if (to.equals("..")) {
            reverseCD();
            return;
        }

        for (File f : currentDirContent) {
            if (!f.getName().equals(to))
                continue;

            if (!f.isDirectory()) {
                NotDirectoryHandler(to);
                throw new Exception();
            }

            currentPath = f.toPath();
            currentDirContent = f.listFiles();
            found = true;
        }
        if (!found) {
            FileNotFoundHandler(to);
            throw new Exception();
        }
    }

    public void readTextFile(String fileToOpen) {
        try {
            TextFile textFile = TextFile.open(currentPath, fileToOpen);
            BufferedReader bufferedReader = new BufferedReader(textFile.read());
            String s = bufferedReader.readLine();
            while (s != null) {
                System.out.println("\t" + s);
                s = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            FileNotFoundHandler(e);
        } catch (FileNotTxtException e) {
            FileNotTxtHandler(e);
        } catch (IOException e) {
            IOHandler(e);
        }
    }

    public void createEmptyTextFile(String fileToCreate) {
        try {
            TextFile.create(currentPath, fileToCreate);
            updateContent();
        } catch (FileNotTxtException e) {
            FileNotTxtHandler(e);
        } catch (FileAlreadyExistsException e) {
            FileAlreadyExistsHandler(e);
        } catch (IOException e) {
            IOHandler(e);
        }
    }

    public void rewriteTextFile(String file, String content) {
        write(file, content, false);
    }

    public void writeTextFileToEnd(String file, String content){
        write(file, content, true);
    }

    private void write(String file, String content, boolean append){
        try {
            TextFile textFile = TextFile.open(currentPath, file);
            if (append) textFile.wtiteToEnd(content);
            else textFile.reWrite(content);
        } catch (FileNotFoundException e) {
            FileNotFoundHandler(e);
        } catch (FileNotTxtException e) {
            FileNotTxtHandler(e);
        } catch (IOException e) {
            IOHandler(e);
        }
    }

    public void delete(String file){
        try {
            TextFile.open(currentPath, file).delete();
            updateContent();
        } catch (FileNotFoundException e) {
            FileNotFoundHandler(e);
        } catch (FileNotTxtException e) {
            FileNotTxtHandler(e);
        } catch (IOException e) {
            IOHandler(e);
        }
    }

    boolean isTextFileExists(String fileName){
        try {
            TextFile.open(currentPath, fileName);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private void updateContent(){
        currentDirContent = currentPath.toFile().listFiles();
    }

    private static void FileNotFoundHandler(FileNotFoundException e){
        System.out.println("\"" + e.getMessage() + "\" do not exist");
    }
    private static void FileNotTxtHandler(FileNotTxtException e){
        System.out.println("\"" + e.getMessage() + "\" is not .txt file");
    }
    private static void FileAlreadyExistsHandler(FileAlreadyExistsException e){
        System.out.println("\"" + e.getMessage() + "\" already exist");
    }

    private static void FileNotFoundHandler(String file){
        System.out.println("\"" + file + "\" do not exist");
    }
    private static void FileNotTxtHandler(String file){
        System.out.println("\"" + file + "\" is not .txt file");
    }
    private static void FileAlreadyExistsHandler(String file){
        System.out.println("\"" + file + "\" already exist");
    }
    private static void RootNotFoundHandler(String root){
        System.out.println("can`t find root directory \"" + root + "\"");
    }
    private static void NotDirectoryHandler(String dir){
        System.out.println("\"" + dir + "\" is not a directory");
    }


    private static void IOHandler(IOException e){
        if (e instanceof AccessDeniedException) {
            System.out.println("Access Denied!");
            return;
        }

        System.out.println(e.toString());

    }
}