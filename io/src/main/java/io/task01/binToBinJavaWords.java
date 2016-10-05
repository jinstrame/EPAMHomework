package io.task01;

import javaWords.JavaKeyWord;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

@SuppressWarnings("WeakerAccess")
public class binToBinJavaWords {

    public static HashMap<String, Integer> getStaticstic(String path){

        HashMap<String, Integer> statistic = new HashMap<>();

        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path))){

            JavaKeyWord.reset();
            calcStatistic(bis);

            for (JavaKeyWord i : JavaKeyWord.values()) {
                if (i.getCount() > 0){
                    statistic.put(i.getValue(), i.getCount());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return statistic;
    }

    public static void writeStatistic(String path, HashMap<String, Integer> statistic){
        try (FileOutputStream fis = new FileOutputStream(path)){
            String output = statistic.toString();
            fis.write(output.getBytes("utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String buildString(BufferedInputStream bis) throws IOException {
        int readed;
        byte[] a = new byte[1000];
        StringBuilder sb = new StringBuilder();
        while(true){
            readed = bis.read(a);
            if (readed == a.length)
                sb.append(new String(a, "utf-8"));
            else {
                sb.append(new String(Arrays.copyOfRange(a, 0, readed)));
                break;
            }
        }
        return sb.toString();
    }

    private static void calcStatistic(BufferedInputStream bis) throws IOException {
        String code = buildString(bis);
        String[] words = code.split("[\\s\\n\\{\\}\\(\\)\\[\\]]+");
        for (String word : words){
            JavaKeyWord key = JavaKeyWord.getWord(word);
            if (key != null)
                key.plusPlus();
        }
    }

}
