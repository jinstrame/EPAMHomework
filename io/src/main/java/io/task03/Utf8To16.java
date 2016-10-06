package io.task03;

import java.io.*;

@SuppressWarnings("WeakerAccess")
public class Utf8To16 {
    public static void procedure(String from, String to){
        String fromString = getFromUtf8File(from);
        putToUtf16File(to, fromString);
    }

    private static String getFromUtf8File(String path){
        String fromString = "";
        try (BufferedReader br = new BufferedReader (
                new InputStreamReader(new FileInputStream(path), "utf8"))){
            StringBuilder sb = new StringBuilder();
            String s = br.readLine();
            while (s != null){
                sb.append(s);
                s = br.readLine();
            }
            fromString = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fromString;
    }

    private static void putToUtf16File(String path, String content){
        try(FileOutputStream fos = new FileOutputStream(path)){
            byte[] a = content.getBytes("utf-16");
            fos.write(a);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
