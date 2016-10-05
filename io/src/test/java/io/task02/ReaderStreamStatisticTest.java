package io.task02;

import org.junit.Test;

import java.util.HashMap;

public class ReaderStreamStatisticTest {
    @Test
    public void getStaticstic() throws Exception {
        ReaderStreamStatistic readerStatistic = new ReaderStreamStatistic();

        HashMap<String, Integer> statistic =
                readerStatistic.getStaticstic("src/main/java/io/task01/BinStreamStatistic.java");
        System.out.println(statistic);

        readerStatistic.writeStatisticToFile("src/test/resources/resultsReader.txt", statistic);
    }
}