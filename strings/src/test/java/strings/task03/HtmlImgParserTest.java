package strings.task03;

import org.junit.Test;

import java.io.*;
import java.util.LinkedList;


public class HtmlImgParserTest {
    @Test
    public void ImgOrderTest() {
        File file = null;
        FileInputStream fis;
        InputStreamReader isr;
        try {
            fis = new FileInputStream("/Users/eugeny/IdeaProjects/EPAMHomework/strings/src/test/resources/imghtmlfile.html");
            isr = new InputStreamReader(fis, "windows-1251");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        try (BufferedReader br = new BufferedReader(isr)) {
            HtmlImgParser parser = new HtmlImgParser(br);
            LinkedList<String> ls = parser.getLs();
            LinkedList<Integer> l = parser.getL();
            for (int i = 0; i < ls.size(); i++) {
                String s = ls.get(i);
                System.out.println("Link " + i + " for img " + l.get(i) + ". Context = " + s);
            }
            //TODO: проверка порядка
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

