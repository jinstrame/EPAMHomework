package strings.task03;

import lombok.*;

import java.io.*;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



@SuppressWarnings("WeakerAccess")
public class HtmlImgParser {
    @Getter
    private LinkedList<Integer> l;
    @Getter
    private LinkedList<String> ls;

    private Pattern imgPattern;

    public HtmlImgParser(BufferedReader reader) {
        imgPattern = Pattern.compile("(\\([Рр]ис\\.|[Рр]исун[еко]{2})[ ]*([0-9]+)\\)?");
        l = new LinkedList<>();
        ls = new LinkedList<>();

        try {
            String s = reader.readLine();
            while(s != null) {
                if (s.contains("<img")) s = "";
                s = s.replaceAll("(<div>|Рис. [0-9]+[ ]*(&nbsp;)+)", "");
                s = s.replaceAll("(<[/\\w]*>|&nbsp;)", "");
                sequenceProcessing(s);
                s = reader.readLine();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


    private void sequenceProcessing(String sequence){
        Matcher m = imgPattern.matcher(sequence);
        while (m.find()){
            SequenceFinder sf = new SequenceFinder(m.start(), m.end(), sequence);
            l.add(new Integer(m.group(2)));
            ls.add(sequence.substring(sf.getLeftResult(), sf.getRightResult()));
            //System.out.println(sequence.substring(sf.getLeftResult(), sf.getRightResult()));
        }
    }

    private class SequenceFinder{
        private int leftIdx;
        private int rightIdx;

        private String source;

        @Getter
        private int leftResult;
        @Getter
        private int rightResult;

        public SequenceFinder(int leftIdx, int rightIdx, String source) {
            this.leftIdx = leftIdx;
            this.rightIdx = rightIdx;
            this.source = source;
            leftResult = 0;
            rightResult = 0;
            proceed();
        }

        private void proceed(){
            leftResult = leftIdx;
            rightResult = rightIdx;
            try {
                leftProceed();
            }
            catch (Exception e){
                if (leftResult < 0)
                    leftResult = 0;
            }
            try{
                rightProceed();
            }
            catch (Exception e){
                if (rightResult >= source.length())
                    rightResult = source.length() - 1;
            }
        }

        private void leftProceed(){
            char c = source.charAt(leftResult);
            while (!Character.isUpperCase(c)){
                if (source.charAt(leftResult) == ')')
                    leftSkipTo('(');
                leftResult--;
                c = source.charAt(leftResult);
            }

            int tmp = leftResult - 1;
            c = source.charAt(tmp);
            while (c == ' ') {
                tmp --;
                c = source.charAt(tmp);
            }
            if (c != '.' && tmp > 0) {
                leftResult = tmp;
                leftProceed();
            }
        }

        private void rightProceed(){
            while (source.charAt(rightResult) != '.'){
                if (source.charAt(rightResult) == '(')
                    rightSkipTo(')');
                rightResult++;
            }
            rightResult++;
        }


        private void leftSkipTo(char c){
            while (source.charAt(leftResult) != c)
                leftResult--;
        }

        private void rightSkipTo(char c){
            while (source.charAt(rightResult) != c)
                rightResult++;
        }
    }

}
