package exceptions.task01;

import java.util.Scanner;

public class CommandProvider {
    FileSystemBrowser fsBrowser;

    public static void main() {
        Scanner scanner = new Scanner(System.in);
        String input = "not empty";
        while (!input.equals("quit")) {
            String[] args = input.split(" ", 2);
        }
    }

    public static void cd(String args){
        String[] cds = args.split("[\\/]");

    }
}
