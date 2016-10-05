package io.task02;

import javaWords.Statistic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;


@SuppressWarnings("WeakerAccess")
public class ReaderStreamStatistic extends Statistic {
    @Override
    protected String buildStringFromFile(String path) {
        int readed;
        byte[] a = new byte[1000];
        StringBuilder sb = new StringBuilder();

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            String s = br.readLine();
            while (s != null) {
                sb.append(s);
                s = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    @Override
    public void writeStatisticToFile(String path, HashMap<String, Integer> statistic) {
        try (FileWriter fw = new FileWriter(path)){
            String output = statistic.toString();
            fw.write(statistic.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

