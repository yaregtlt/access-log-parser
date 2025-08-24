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
                        LogEntry logEntry = new LogEntry(line);
                        if (logEntry.getAgent().isGooglebot()) googleCount++;
                        if (logEntry.getAgent().isYandexBot()) yandexCount++;
                        statistics.addEntry(logEntry);
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
            System.out.println("Traffic rate is: " + statistics.getTrafficRate());
            System.out.println("OS statistics is: " + statistics.getOsStatistics());
            System.out.println("OS statistics is: " + statistics.getBrowserStatistics());
            System.out.println("Average number of requests per hour: " + statistics.getAverageRequestsPerHour());
            System.out.println("Average number of error requests per hour: " + statistics.getAverageErrorRequestsPerHour());
            System.out.println("Average number of requests per user: " + statistics.getAverageRequestsPerUser());
        }

        }
    }