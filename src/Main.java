import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Введите первое число: ");
        int number1 = new Scanner(System.in).nextInt();
        System.out.println("Введите второе число: ");
        int number2 = new Scanner(System.in).nextInt();

        System.out.println("Сумма = " + (number1 + number2));
        System.out.println("Разность = " + (number1 - number2));
        System.out.println("Частное = " + ((double) number1/number2));
        }
    }