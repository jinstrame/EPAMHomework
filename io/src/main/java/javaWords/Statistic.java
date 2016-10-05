package javaWords;

import java.util.HashMap;

public abstract class Statistic {
    public HashMap<String, Integer> getStaticstic(String path){

        HashMap<String, Integer> statistic = new HashMap<>();
        JavaKeyWord.reset();
        calcStatisticFromFile(path);

        for (JavaKeyWord i : JavaKeyWord.values()) {
            if (i.getCount() > 0) {
                statistic.put(i.getValue(), i.getCount());
            }
        }

        return statistic;
    }

    public abstract void writeStatisticToFile(String path, HashMap<String, Integer> statistic);

    private void calcStatisticFromFile(String path) {
        String code = buildStringFromFile(path);
        String[] words = code.split("[\\s\\n\\{\\}\\(\\)\\[\\];]+");
        for (String word : words){
            JavaKeyWord key = JavaKeyWord.getWord(word);
            if (key != null)
                key.plusPlus();
        }
    }

    abstract protected String buildStringFromFile(String path);
}
