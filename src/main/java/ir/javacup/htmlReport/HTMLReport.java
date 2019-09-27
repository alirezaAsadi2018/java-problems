package ir.javacup.htmlReport;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        string = string.replaceAll("\\s*", "");
        Pattern pattern = Pattern.compile("<tr(class=.+?)?>"
                + "<td(class=.+?)?>Sum</td>(.*?)"
                + "</tr>");
        Matcher matcher = pattern.matcher(string);
        if (matcher.find()) {
            String match = matcher.group(3);
            pattern = Pattern.compile(
                    "\\d+%");
            matcher = pattern.matcher(match);
            StringBuilder stringBuilder = new StringBuilder();
            while (matcher.find()) {
                stringBuilder.append(matcher.group(0)).append(" ");
            }
            if (stringBuilder.charAt(stringBuilder.length() - 1) == ' ')
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            System.out.println(stringBuilder);
        }
    }
}

