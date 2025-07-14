import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //System.out.println(fraction(278.46785646548999));
        //System.out.println(sumLastNums(4568));
        //System.out.println(charToNum('1'));
        //System.out.println(isPositive(4));
        //System.out.println(is2Digits(33));
        //System.out.println(isUpperCase('K'));
        //System.out.println(isInRange(52,23,52));
        //System.out.println(isDivisor(4,16));
        //System.out.println(isEqual(2,4,2));
        //System.out.println(lastNumSum(lastNumSum(lastNumSum(lastNumSum(5, 11), 123),14),1));
        //System.out.println(abs(45));
        //System.out.println(safeDiv(23,0));
        //System.out.println("Максимальное число = " + max2(15,7));
        //System.out.println(makeDecision(17,16));
        //System.out.println(max3(10,6,9));
        //System.out.println(sum3(8,4,4));
        //System.out.println(sum2(4,1));
        //System.out.println(is35(11));
        //System.out.println(magic6(5, 2));
        //System.out.println(age(4));
        //System.out.println(day(0));
        //printDays("вторник");
        //System.out.println(listNums(10));
        //System.out.println(reverseListNums(10));
        //System.out.println(chet(9));
        //System.out.println(pow(3,4));
        //System.out.println(numLen(1241241));
        //System.out.println(equalNum(22222));
        //square(10);
        //leftTriangle(10);
        //rightTriangle(5);
        //guessGame();
        //int[] array1 = {5,-8,9,5,-18,5,-4};
        //int[] array2 = {11,12,13};
        //System.out.println(countPositive(array));
        //System.out.println(Arrays.toString(add(array1,array2,5)));
        //System.out.println(java.util.Arrays.toString(array));
        //System.out.println(5%2);
//        int a = new int[3][14].length;
//        String s1 = "Hello world!";
//        String s2 = "Hello world!";
//        String s3 = "Hello" + " world!";
//        String s4 = new String("Hello world!");
//        String s5 = new String(new char[]{'H','e','l','l','o',' ','w','o','r','l','d','!'});
//        String s6 = new String(s3);
//        String s7 = new String(s3).intern();
//        System.out.println(s1 == s2);
//        System.out.println(s1 == s3);
//        System.out.println(s1 == s4);
//        System.out.println(s1 == s5);
//        System.out.println(s1 == s6);
//        System.out.println(s1 == s7);
        char c = 6;
        System.out.println("Hello".charAt(c));

                }
    public static int lastNumSum(int a, int b){
        return (a%10)+(b%10);
    }
    public static double fraction(double x){
        int num = (int) x;
        System.out.println(num);
        return Math.round((x - num) * 100d) / 100d;
    }
    public static int sumLastNums(int x){
        int i = 0;
        int y = 0;
        while (i < 2)  {
            y =x%10+y;
            x = x/10;
            i++;
        } ;
        return y;
    }
    public static int charToNum(char x){
        return (int) x - 48;
    }
    public static boolean isPositive(int x){
        return x > 0;
    }
    public static boolean is2Digits(int x){
        return x/10/10 == 0 && x/10>0;
    }
    public static boolean isUpperCase(char x){
        return (int) x >= 65 && (int) x <= 90;
    }
    public static boolean isInRange(int a, int b, int num){
        return (num >= a && num <= b) || (num >= b && num <= a);
    }
    public static boolean isDivisor(int a, int b){
        return (a % b == 0) || (b % a == 0);
    }
    public static boolean isEqual (int a, int b, int c){
        return a == b && b == c;
    }

// ----------------------------Условия----------------------------
    public static int abs(int x){
         return x>0?x:x*-1;
    }
    public static int safeDiv(int x, int y){
        if (y!=0) return x/y;
        else return 0;
    }
    public static int max(int x, int y){
        return x>y?x:y;
    }
    public static int max2(int x, int y){
        if (x>y) return x;
        else return y;
    }
    public static String makeDecision(int x, int y){
        if (x>y) {return String.valueOf(x) + '>' + y;}
        else if (x<y) {return String.valueOf(x) + '<' + y;}
        else return String.valueOf(x) + '=' + y;
    }
    public static int max3(int x, int y, int z){
        int max = x;
        if (y > max) max = y;
        if (z > max) max = z;
        return max;
    }
    public static boolean sum3(int x, int y, int z){
        return x + y == z | x + z == y | y + z == x;
    }
    public static int sum2(int x, int y){
        if (x+y>=10 & x+y<=19) return 20;
        else return x+y;
    }
    public static boolean is35(int x){
        if (x%3==0 & x%5==0) return false;
        else return x % 3 == 0 | x % 5 == 0;
    }
    public static boolean magic6(int x, int y){
        if (x==6 | y==6) return true;
        if (x+y==6) return true;
        return x - y == 6 | y - x == 6;
    }
    public static String age(int x){
        String numToStr=Integer.toString(x);
        if (numToStr.charAt(numToStr.length()-1)=='1' & x%100 != 11) return x + " год";
        if ((numToStr.charAt(numToStr.length()-1)=='2' |
                numToStr.charAt(numToStr.length()-1)=='3' |
                numToStr.charAt(numToStr.length()-1)== '4') &
                (x%100!=12 & x%100!=13 & x%100!=14)) return x + " года";
        return x + " лет";
    }
    public static String day(int x){
        switch (x) {
            case 1: return "Понедельник";
            case 2: return "Вторник";
            case 3: return "Среда";
            case 4: return "Четверг";
            case 5: return "Пятница";
            case 6: return "Суббота";
            case 7: return "Воскресенье";
            default: return "это не день недели";
        }
    }
    public static void printDays(String x){
        String upper = x.substring(0, 1).toUpperCase() + x.substring(1);
        switch (upper) {
            case "Понедельник":
                System.out.println("Понедельник");
            case "Вторник":
                System.out.println("Вторник");
            case "Среда":
                System.out.println("Среда");
            case "Четверг":
                System.out.println("Четверг");
            case "Пятница":
                System.out.println("Пятница");
            case "Суббота":
                System.out.println("Суббота");
            case "Воскресенье":
                System.out.println("Воскресенье"); break;
            default: System.out.println("это не день недели");
        }
    }

    //----------------------------Циклы----------------------------
    public static String listNums(int x){
        String numbers = "0";
        for (int i=1; i<=x; i++) {
            numbers = numbers + " " + i;
        }
        return numbers;
    }
    public static String reverseListNums(int x){
        String numbers = Integer.toString(x);
        for (int i=x-1; i>=0; i--) {
            numbers = numbers + " " + i;
        }
        return numbers;
    }
    public static String chet(int x){
        String numbers = "0";
        for (int i=2;i<=x;i+=2){
            numbers = numbers + " " + i;
        }
        return numbers;
    }
    public static int pow(int x, int y){
        int pow = x;
        for (int i=1;i<y;i++){
            pow = pow * x;
        }
        return pow;
    }
    public static int numLen(long x) {
        int count = 0;
        while (x > 0) {
            x /= 10;
            count++;
        }
        return count;
    }
    public static boolean equalNum(int x) {
        int firstDigit = x % 10;
        x /= 10;
        while (x > 0) {
            int currentDigit = x % 10;
            if (currentDigit != firstDigit) return false;
            x /= 10;
        }
        return true;
    }
    public static void square(int x){
        for (int i = 1; i<=x;i++){
            for (int j = 1; j<=x;j++){
                System.out.print('*');
            }
            System.out.println(' ');
        }
    }
    public static void leftTriangle(int x){
        for (int i = 1; i<=x;i++){
            for (int j = 1; j<=i;j++){
                System.out.print('*');
            }
            System.out.println(' ');
        }
    }
    public static void rightTriangle(int x) {
        for (int i=1; i<=x;i++) {
            for (int j = 1;j<=x-i;j++) {
                System.out.print(" ");
            }
           for (int k = 1;k<=i;k++) {
                System.out.print("*");
            }
            System.out.println(' ');
        }
    }
    public static void guessGame() {
        int randomNum = 3;
        Scanner sc = new Scanner(System.in);
        System.out.println("What number am I thinking (0 to 9)? :");
        int x = 0;
        while (true) {
            x = sc.nextInt();
            if (x==randomNum) break;
            System.out.println("No, try again");
        }
            System.out.println("Yes, it`s " + randomNum);
        
    }

    //----------------------------Массивы------------------------------
    public static int findFirst(int[] arr, int x){
        for (int i = 0; i< arr.length;i++){
            if (arr[i] == x) return i;
        }
        return -1;
    }
    public static int findLast(int[] arr, int x){
        for (int i = arr.length-1; i>=0;i--){
            if (arr[i] == x) return i;
        }
        return -1;
    }
    public static int maxAbs(int[] arr){
        int max = 0;
        for (int i = 0; i< arr.length;i++){
           if (Math.abs(arr[i])>Math.abs(max)) max=arr[i];
        }
        return max;
    }
    public static int countPositive(int[] arr){
        int count = 0;
        for (int i = 0; i< arr.length;i++){
            if (arr[i]>0) count++;
        }
        return count;
    }
    public static boolean palindrom(int[] arr){
        //if (arr.length%2==0) return false;
        int first = 0;
        int last = arr.length - 1;

        while (first < last) {
            if (arr[first] != arr[last]) {
                return false;
            }
            first++;
            last--;
        }
        return true;
    }
    public static void reverse(int[] arr){
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }
    public static int[] reverseBack(int[] arr){
        int[] tmp = new int[arr.length];
        for (int i = 0; i < arr.length / 2; i++) {
            tmp[i] = arr[arr.length - 1 - i];
        }
        return tmp;
    }
    public static int[] concat(int[] arr1, int[] arr2){
        int[] newArr = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            newArr[i] = arr1[i];
        }
       for (int j = 0; j < arr2.length; j++) {
            newArr[j + arr1.length] = arr2[j];
        }
        return newArr;
    }
    public static int[] findAll(int[] arr, int x){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                count++;
            }
        }
        int[] result = new int[count];
        int pos = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                result[pos++] = i;
            }
        }
        return result;
    }
    public static int[] deleteNegative(int[] arr){
        int count = countPositive(arr);
        int[] result = new int[count];
        int pos = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                result[pos++] = arr[i];
            }
        }
        return result;
    }
    public static int[] add(int[] arr, int x, int pos){
        int[] result = new int[arr.length+1];
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            if (i == pos) {
                result[count] = x;
                count=i+1;
            }
            result[count] = arr[i];
            count++;
        }
        return result;
    }
    public static int[] add(int[] arr, int[] ins, int pos){
        int[] result = new int[arr.length+ ins.length];
        for (int i = 0; i < pos; i++) {
            result[i] = arr[i];
        }
        for (int j = 0; j < ins.length; j++) {
            result[pos + j] = ins[j];
        }
        for (int k = pos; k < arr.length; k++) {
            result[k + ins.length] = arr[k];
        }
        return result;
    }
}
