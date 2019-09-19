import java.util.Random;
import java.util.Scanner;

public class Main {

    private static Random random = new Random();

    public static void main(String[] args) {
        // Задача №1
        guessNum();

        // Задача №2
        guessFruit();

    }

    private static void guessNum() {
        Scanner in = new Scanner(System.in);

        do {
            int num = random.nextInt(10);
            System.out.println("Я загадал число от 0 до 9, попробуй угадать с трёх попыток.");
            for (int i = 3; i > 0; i--) {
                System.out.println("Введи число:");
                int userNum = in.nextInt();
                if (userNum == num) {
                    System.out.println("Верно! Ура!");
                    break;
                }
                System.out.println(userNum > num ? "Загаданное число меньше." : "Загаданное число больше.");
                System.out.println((i - 1 > 0 ? "Попробуй еще раз!" : "Не угадал, к сожалению:("));
            }
            System.out.println("Сыграем ещё? Да - 1, Нет - 0");

        } while (in.nextInt() == 1);
        System.out.println("Спасибо за игру!");
    }

    // Задача №2
    private static void guessFruit() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int iiWord = random.nextInt(words.length);
        String word = words[iiWord];
        int wordLenght = word.length();
        System.out.println("Я загадал слово, попробуй отгадать какое.");
        System.out.println(word); //выведен загаданное слово для проверки
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Введи свой вариант:");
            String userWord = in.nextLine();
            if (userWord.equals("")) {
                break;
            } else if (word.equals(userWord)) {
                System.out.println("Угадал!:)");
                break;
            }
            char[] charsUserWord = userWord.toCharArray();
            for (int i = 0; i < wordLenght; i++) {
                if (i >= charsUserWord.length) {
                    break;
                }
                if (word.charAt(i) != charsUserWord[i]) {
                    charsUserWord[i] = '#';
                }
            }
            StringBuilder hint = new StringBuilder(String.valueOf(charsUserWord));
            for (int i = hint.length(); i < 15; i++) {
                hint.append('#');}
                System.out.println(hint);
        }
        while (true);
    }


}

