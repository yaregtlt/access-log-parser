import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFound, InputOutputException {
        int count = 0;
        String line;
        int maxLength = 0;
        int minLength = Integer.MAX_VALUE;
        int countLines = 0;
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
                }
            }
            catch (IOException e) {
                throw new InputOutputException(e);
            }
            System.out.println("Общее количество строк: " + countLines + "\nСамая длинная строка: " + maxLength + " символов" + "\nСамая короткая строка:" + minLength + " символов");
        }

        }
    }