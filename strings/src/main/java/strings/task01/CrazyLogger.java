package strings.task01;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("WeakerAccess")
public class CrazyLogger {
    private static StringBuilder stringBuilder = new StringBuilder("");

    public static void log(String message){
        stringBuilder
                .append(ZonedDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-YYYY : hh-mm - ")))
                .append(message)
                .append("\n");
    }

    public static void out(){
        System.out.println(stringBuilder.toString());
    }

    public static Iterator<String> search(String regex){
        Pattern p = Pattern.compile("((.*)(" + regex + ")(.*))");
        Matcher m = p.matcher(stringBuilder);

        LinkedList<String> list = new LinkedList<>();

        while (m.find()){
            list.add(stringBuilder.subSequence(m.start(), m.end()).toString());
        }

        return list.iterator();
    }


}
