package io.task01;

import org.junit.Test;

import java.util.HashMap;

public class BinStreamStatisticTest {
    @Test
    public void getStaticstic() throws Exception {
        BinStreamStatistic binStatistic = new BinStreamStatistic();

        HashMap<String, Integer> statistic =
                binStatistic.getStaticstic("src/main/java/io/task01/BinStreamStatistic.java");
        System.out.println(statistic);

        binStatistic.writeStatisticToFile("src/test/resources/resultsBin.txt", statistic);
    }
}