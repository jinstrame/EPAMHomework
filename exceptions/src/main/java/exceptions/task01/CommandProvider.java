package exceptions.task01;

import java.util.Scanner;

public class CommandProvider {
    private static FileSystemBrowser fsBrowser;

    public static void main(String[] args){
        fsBrowser = new FileSystemBrowser();
        try (Scanner scanner = new Scanner(System.in)) {

            String input = "not empty";
            while (!input.equals("quit")) {
                System.out.print(fsBrowser.getCurrentPath().toAbsolutePath().toString() + "> ");
                input = scanner.nextLine();
                String[] arguments = input.split(" ", 2);

                String argument = null;
                if (arguments.length > 1)
                    argument = arguments[1];

                switch (arguments[0]) {
                    case "cd": {
                        cd(argument);
                        break;
                    }
                    case "ls": {
                        fsBrowser.ls();
                        break;
                    }
                    case "lsroot": {
                        fsBrowser.lsRoot();
                        break;
                    }
                    case "cdroot": {
                        cdRoot(argument);
                        break;
                    }
                    case "cr": {
                        createText(argument);
                        break;
                    }
                    case "rm": {
                        deleteText(argument);
                        break;
                    }
                    case "write": {
                        writeText(argument, scanner);
                        break;
                    }
                    case "read": {
                        readText(argument);
                        break;
                    }
                    case "help": {
                        System.out.println("cd    <argument> - move to directory");
                        System.out.println("ls               - list files and folders in current directory");
                        System.out.println("lsroot           - list root directories");
                        System.out.println("cdroot           - move to root directory");
                        System.out.println("cr    <argument> - create .txt file");
                        System.out.println("rm    <argument> - delete .txt file");
                        System.out.println("read  <argument> - delete .txt file");
                        System.out.println("write <argument> - open write util to add content to .txt file");
                        System.out.println("quit             - close program");
                        break;
                    }
                    default:
                        System.out.println("Incorrect command. Type \"help\".");
                }
            }
        }
    }



    private static void cdRoot(String root){
        if (root == null)
            System.out.println("cdroot: incorrect command argument");

        fsBrowser.cdRoot(root);
    }

    private static void cd(String args) {
        if (args == null) {
            System.out.println("cd: incorrect command argument");
            return;
        }
        String[] cds = args.split("[\\/]");

        int i = 0;
        try {
            fsBrowser.backup();
            for (; i < cds.length; i++) {
                fsBrowser.cd(cds[i]);
            }
        }
        catch (Exception e) {
            fsBrowser.restore();
        }
    }
    private static void reverceCd(int count){
        for (int i = 0; i < count; i++)
            fsBrowser.reverseCD();
    }

    private static void createText(String file){
        if (file == null) {
            System.out.println("cr: incorrect command argument");
            return;
        }
        fsBrowser.createEmptyTextFile(file);
    }

    private static void deleteText(String file) {
        if (file == null) {
            System.out.println("rm: incorrect command argument");
            return;
        }
        fsBrowser.delete(file);
    }

    private static void writeText(String file, Scanner scanner) {
        if (file == null) {
            System.out.println("write: incorrect command argument");
            return;
        }
        if (!fsBrowser.isTextFileExists(file)) {
            System.out.println("write: file + \"" + file + "\" do not exists");
            return;
        }

        boolean running = true;
        System.out.println();
        while (running){
            System.out.print(file + "> ");
            String arguments[] = scanner.nextLine().split(" ", 2);
            String argument;
            if (arguments.length < 2)
                argument = "";
            else argument = arguments[1];

            switch (arguments[0]){
                case "add":{
                    fsBrowser.writeTextFileToEnd(file, argument);
                    break;
                }
                case "addl":{
                    fsBrowser.writeTextFileToEnd(file, argument + "\n");
                    break;
                }
                case "wr":{
                    fsBrowser.rewriteTextFile(file, argument);
                    break;
                }
                case "quit":{
                    running = false;
                    break;
                }
                case "help":{
                    System.out.println("add  <content> - add content to file");
                    System.out.println("addl <content> - add content to file and move to a new line");
                    System.out.println("wr   <content> - write content to file deleting existing content");
                    System.out.println("quit           - exit from write util");
                    break;
                }
                default:{
                    System.out.println("Incorrect command. Type \"help\".");
                    break;
                }
            }
        }
    }

    private static void readText(String file) {
        if (file == null) {
            System.out.println("read: incorrect command argument");
            return;
        }
        fsBrowser.readTextFile(file);
    }



}

