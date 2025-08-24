package ru.study;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws FileNotFound, InputOutputException {
        int count = 0;
        String line;
        int maxLength = 0;
        int minLength = Integer.MAX_VALUE;
        int countLines = 0;
        int yandexCount = 0;
        int googleCount = 0;
        Statistics statistics = new Statistics();
        while (true){
            System.out.println("Enter path to the file: ");
            String path = new Scanner(System.in).nextLine();
            File file = new File(path);
            boolean fileExists = file.exists();
            boolean isDirectory = file.isDirectory();
            if (!fileExists || isDirectory) {
                throw new FileNotFound();
            }
            if (fileExists & !isDirectory) {
                System.out.println("Path is correct");
                count++;
                System.out.println("The file number is " + count);
            }
            try (FileReader fileReader = new FileReader(path);
                 BufferedReader reader = new BufferedReader(fileReader)){
                int count1 = 0;
                while ((line = reader.readLine()) != null) {
                    countLines++;
                    int length = line.length();
                    if (length>maxLength) maxLength=length;
                    if (maxLength>1024) throw new LineTooLongException();
                    if (length<minLength) minLength=length;
                    try {
                        //line = "190.136.46.196 - - [25/Sep/2022:06:25:04 +0300] \"GET /december-reports/analysis/6367/65/?n=11 HTTP/1.0\" 200 8680 \"-\" \"Mozilla/5.0 (compatible; SemrushBot/7~bl; +http://www.semrush.com/bot.html)\"";
                        LogEntry le = new LogEntry(line);
                        //System.out.println("Browser is: " + le.getAgent().getBrowser() + "; OS type is: " + le.getAgent().getOsType());
                        String lookingFragment = "";
                        String fragment = patternFinder("([^(]*)\\)", patternFinder("([^\"]*)\"", line, 5), 0);
                        String[] parts = fragment.split(";");
                        if (parts.length >= 2) {
                            lookingFragment = parts[1];
                        }
                        String finalFragment = patternFinder(lookingFragment, '/');
                        if (finalFragment.equals("Googlebot")) googleCount++;
                        if (finalFragment.equals("YandexBot")) yandexCount++;
                        statistics.addEntry(le);
                    }
                    catch (IllegalStateException ignored){
                    }
                }
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println("Whole number of strings: " + countLines +
                    "\nMost long string: " + maxLength + " symbols" +
                    "\nMost short string:" + minLength + " symbols" +
                    "\nGooglebot caught: " + googleCount + " times" +
                    "\nYandexBot caught: " + yandexCount + " times" +
                    "\nYandexBot is: " + String.format("%.2f", (double) yandexCount/countLines*100) + " % from whole number of strings" +
                    "\nGooglebot is: " + String.format("%.2f", (double) googleCount/countLines*100) + " % from whole number of strings");
            System.out.println("OS statistics is: " + statistics.getOsStatistics());
            System.out.println("OS statistics is: " + statistics.getBrowserStatistics());
        }

        }
        public static String patternFinder(String patternString, String line, int fragmentNumber) {

            Pattern pattern = Pattern.compile(patternString);
            Matcher matcher = pattern.matcher(line);
            int countFragment = 0;
            while(matcher.find()) {
                if(countFragment++ == fragmentNumber) {
                    break;
                }
            }
            return matcher.group(1);
        }
        public static String patternFinder(String line, char delimiter) {
            String newLine = line.replaceAll(" ", "");
            int index = newLine.indexOf(delimiter);
            if (index != -1) {
                return newLine.substring(0, index);
            } else {
                return newLine;
            }
        }
    }