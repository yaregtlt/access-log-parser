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
        while (true){
            System.out.println("Введи путь к файлу: ");
            String path = new Scanner(System.in).nextLine();
            File file = new File(path);
            boolean fileExists = file.exists();
            boolean isDirectory = file.isDirectory();
            if (!fileExists || isDirectory) {
                throw new FileNotFound();
            }
            if (fileExists & !isDirectory) {
                System.out.println("Путь указан верно");
                count++;
                System.out.println("Это файл номер " + count);
            }
            try (FileReader fileReader = new FileReader(path);
                 BufferedReader reader = new BufferedReader(fileReader)){

                while ((line = reader.readLine()) != null) {
                    countLines++;
                    int length = line.length();
                    if (length>maxLength) maxLength=length;
                    if (maxLength>1024) throw new LineTooLongException();
                    if (length<minLength) minLength=length;
                    //String fragment1 = patternFinder("([^\"]*)\"", line, 5);
                    try {
                        String lookingFragment = "";
                        String fragment = patternFinder("([^(]*)\\)", patternFinder("([^\"]*)\"", line, 5), 0);
                        String[] parts = fragment.split(";");
                        if (parts.length >= 2) {
                            lookingFragment = parts[1];
                        }
                        String finalFragment = patternFinder(lookingFragment, '/');
                        if (finalFragment.equals("Googlebot")) googleCount++;
                        if (finalFragment.equals("YandexBot")) yandexCount++;
                    }
                    catch (IllegalStateException ignored){
                    }
                }
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println("Общее количество строк: " + countLines +
                    "\nСамая длинная строка: " + maxLength + " символов" +
                    "\nСамая короткая строка:" + minLength + " символов" +
                    "\nGooglebot встретился: " + googleCount + " раз" +
                    "\nYandexBot встретился: " + yandexCount + " раз" +
                    "\nYandexBot составляет: " + String.format("%.2f", (double) yandexCount/countLines*100) + " % от всего количества строк" +
                    "\nGooglebot составляет: " + String.format("%.2f", (double) googleCount/countLines*100) + " % от всего количества строк");
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