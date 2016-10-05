package io.task01;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class binToBinJavaWordsTest {
    @Test
    public void getStaticstic() throws Exception {
        HashMap<String, Integer> statistic =
                binToBinJavaWords.getStaticstic("/Users/eugeny/IdeaProjects/EPAMHomework/io/src/main/java/io/task01/binToBinJavaWords.java");
        System.out.println(statistic);
        binToBinJavaWords.writeStatistic("/Users/eugeny/IdeaProjects/EPAMHomework/io/src/test/resources/results.txt", statistic);
    }

}