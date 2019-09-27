package ir.javacup.ranker;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ranker {

    public static void main(String args[]) {
        String[] documents = new String[6];
        documents[0] = "hola hi hello salam? hello.";            // 1/5
        documents[1] = "hola hola hello,hello 	hi! hi.";        // 0/6
        documents[2] = "salam salam hi! hola   hello hello.";    // 2/6
        documents[3] = "salam hi hola salam salam hi.";        // 3/6
        documents[4] = "salam hi. hi! hi salam hi hola.";        // 2/7
        documents[5] = "salam hi. hi! hi hi hi hola.";            // 1/7
        int[] indexes = new Ranker().rank("salam", documents);
        System.out.println(Arrays.toString(indexes));
        // expected indexes: [3, 2, 4, 0, 5, 1]
    }

    public int[] rank(String word, String[] documents) {
        List<Double> ranksList = Arrays.stream(documents).
                map(document -> Arrays.stream(document.split("[.?,! ]"))
                        .map(String::trim)
                        .map(String::toLowerCase)
                        .filter(aword -> aword.length() > 0 && !aword.equals(" "))
                        .toArray()
                )
                .map(words -> (double) Collections.frequency(Arrays.asList(words),
                        word.toLowerCase())
                        / (double) words.length)
                .collect(Collectors.toList());
        System.out.println(ranksList);
        int[] ranks = new int[documents.length];
        for (int i = 0; i < ranksList.size(); i++) {
            double max = -1.0;
            int index = 0;
            for (int j = 0; j < ranksList.size(); j++) {
                if(ranksList.get(j) > max){
                    max = ranksList.get(j);
                    index = j;
                }
            }
            ranks[i] = index;
            ranksList.set(index, -1.0);
        }
        return ranks;
    }

}
