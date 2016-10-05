package io.task01;

import javaWords.Statistic;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

@SuppressWarnings("WeakerAccess")
public class BinStreamStatistic extends Statistic {

    @Override
    public void writeStatisticToFile(String path, HashMap<String, Integer> statistic){
        try (FileOutputStream fis = new FileOutputStream(path)){
            String output = statistic.toString();
            fis.write(output.getBytes("utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected String buildStringFromFile(String path) {
        int readed;
        byte[] a = new byte[1000];
        StringBuilder sb = new StringBuilder();

        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path))) {
            while (true) {
                readed = bis.read(a);
                if (readed == a.length)
                    sb.append(new String(a, "utf-8"));
                else {
                    sb.append(new String(Arrays.copyOfRange(a, 0, readed)));
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
