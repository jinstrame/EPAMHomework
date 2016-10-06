package io.task03;

import org.junit.Test;

public class Utf8To16Test {
    @Test
    public void utf8to16test() throws Exception {
        String source = "src\\test\\resources\\utf8.txt";
        String dest = "src\\test\\resources\\utf16.txt";

        Utf8To16.procedure(source, dest);
    }
}