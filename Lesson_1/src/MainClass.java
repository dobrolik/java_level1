import java.sql.SQLOutput;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
    /*  byte b = -12;
        int i = 23321234;
        short s = 327;
        long l = 5627654345L;
        char c = 'h';
        float  f = 2.1332f;
        double d = 3.12321456;
        boolean bb = b>5;  */


        System.out.println(formula(2, 3, 6, 5));

        System.out.println(isBetweenTenToTwenty(10, 15));

        System.out.println(plusOrMinus(-1));

        System.out.println(lessThenZero(0));

        System.out.println(helloName("Никита"));

        System.out.println(yearWhatEver(1915));

    }

    static double formula(double a, double b, double c, double d) {
        return a * (b + (c / d));
    }

    static boolean isBetweenTenToTwenty(int x, int y) {
        return x + y > 10 && x + y < 20;

    }

    static String plusOrMinus (int a) {
        String b;
        if (a>=0) {
            b = "Положительное";
        } else {
            b = "Отрицательное";
        }
        return b;
    }

    static boolean lessThenZero (int z){
        return z<0;
    }

    static String helloName (String n){
        return ("Привет, "+ n + "!");
    }

    static boolean yearWhatEver (int g) {
       return (g%4 == 0) && (g%100 != 0) || (g%400 == 0);
    }
}

