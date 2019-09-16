import java.util.Arrays;
import java.util.concurrent.atomic.AtomicStampedReference;

public class Main {
    public static void main(String[] args) {
        //Задача №1
        int[] a = new int[7]; //сделал чуть сложнее, чтобы генерировалось разное количество 1 и 0
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 2);
        }
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                a[i] = 1;
            } else {
                a[i] = 0;
            }
        }
        System.out.println(Arrays.toString(a));
        System.out.println("=========================");

        //задача №2
        int[] b = new int[8];
        int n = 0;
        for (int i = 0; i < b.length; i++) {
            b[i] = b[i] + n;
            n = n + 3;
        }
        System.out.println(Arrays.toString(b));
        System.out.println("=========================");

        //задача №3
        int[] c = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(c));
        for (int i = 0; i < c.length; i++) {
            if (c[i] < 6) {
                c[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(c));
        System.out.println("=========================");

        //задача №4

        int m = 4;
        int[][] d = new int[m][m];
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[i].length; j++) {
                if ((i == j) || (i + j == m - 1)) {
                    d[i][j] = 1;
                } else {
                    d[i][j] = 0;
                }
                System.out.print("\t" + d[i][j]);
            }
            System.out.println();

        }
        System.out.println("=========================");

        //задача №5
        int x = 5;
        int[] e = new int[x];
        for (int i = 0; i < x; i++) {
            e[i] = (int) (Math.random() * 20);
        }
        System.out.println(Arrays.toString(e));
        int maxElement = e[1];
        int minElement = e[1];
        for (int i = 0; i < x; i++) {
            if (e[i] > maxElement) {
                maxElement = e[i];
            } else if (e[i] < minElement) {
                minElement = e[i];
            }
        }
        System.out.println("Максимальный элемент = " + maxElement + "\n" + "Минимальный элемент = " + minElement);
        System.out.println("=========================");

        //задача №6
        // Метод checkSumLeftToRight
        int[] f = new int[10];
        for (int i = 0; i < f.length; i++){
            f[i] = (int)(Math.random()*3);
        }
        System.out.println(Arrays.toString(f));
        System.out.println(checkSumLeftToRIght(f));
        System.out.println("=========================");

        //задача №7

        int[] h = {0,1,2,3,4,5,6,7};
        bigShift(h,-3);


    }
    static boolean checkSumLeftToRIght(int[] array) {
        int left;
        int right;

        for (int i = 0; i < array.length + 1; i++) {
            left = 0;
            right = 0;

            for (int j = 0; j < i; j++) {
                left += array[j];
            }

            for (int j = i; j < array.length; j++) {
                right += array[j];
            }

            if (right == left) return true;
        }
        return false;
    }

    static void bigShift (int[] w, int n){
        System.out.println(Arrays.toString(w));
        if (n>0){
            for (int i = 0; i <n; i++){
                int shift = w[w.length-1];
                if (w.length - 1>0) {
                    System.arraycopy(w,0,w,1,w.length-1);
                } w[0] = shift;
            }
        } else if (n < 0) {
            for (int i = 0; i>n; i--){
                int shift = w[0];
                System.arraycopy(w,1,w,0,w.length - 1);
                w[w.length-1]=shift;
            }
        }
        System.out.println(Arrays.toString(w));
    }


}






