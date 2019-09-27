package ir.javacup.properNames;

import java.util.Scanner;

public class ProperNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] sentences = string.split("[.?]");
        for (String sentence : sentences) {
            sentence = sentence.trim();
            String[] words = sentence.split(" ");
            for (int i = 1; i < words.length; i++) {
                String word = words[i];
                if(word.length() < 2)
                    continue;
                if(Character.isUpperCase(word.charAt(0))){
                    word = word.replaceAll("[,?.]", "");
                    System.out.println(word);
                }
            }
        }
    }
}
