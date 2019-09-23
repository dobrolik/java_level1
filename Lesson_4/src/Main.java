import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final int SIZE_X = 5;
    private static final int SIZE_Y = 5;

    private static final char PLAYER_DOT = 'X';
    private static final char AI_DOT = 'O';
    private static final char EMPTY_DOT = '_';

    private static final int WIN = 3;

    private static char[][] field = new char[SIZE_Y][SIZE_X];

    private static Scanner scanner = new Scanner(System.in);

    private static Random random = new Random();

    public static void main(String[] args) {
        Fields();
        printField();

        while (true) {
            playerTurn();
            printField();
            if (checkWin(PLAYER_DOT)) {
                System.out.println("You win!");
                break;
            }
            if (isFuelFull()) {
                System.out.println("Draw!");
                break;
            }
            aiTurn();
            printField();
            if (checkWin(AI_DOT)) {
                System.out.println("Computer win!");
                break;
            }
            if (isFuelFull()) {
                System.out.println("Draw!");
                break;
            }
        }

    }

    public static void Fields() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    public static void printField() {
        System.out.println();
        for (int i = 0; i < SIZE_Y; i++) {
            System.out.print("|");
            for (int j = 0; j < SIZE_X; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void setSym(int y, int x, char symbol) {
        field[y][x] = symbol;
    }

    public static void playerTurn() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты: X Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(y, x));
        setSym(y, x, PLAYER_DOT);
    }

    // Задача №4. Пробуем блокировать ходы
    public static void aiTurn() {
        //Ищем ход компьютера
        for (int i = 0; i < SIZE_Y; i++)
            for (int j = 0; j < SIZE_X; j++) {
                if (isCellValid(i, j)) {
                    setSym(i, j, AI_DOT);
                    if (checkWin(AI_DOT)) return;
                    setSym(i, j, EMPTY_DOT);
                }
            }
        for (int i = SIZE_Y; i > 0; i--)
            for (int j = SIZE_X; j > 0; j--) {
                if (isCellValid(i, j)) {
                    setSym(i, j, AI_DOT);
                    if (checkWin(AI_DOT)) return;
                    setSym(i, j, EMPTY_DOT);
                }
            }
        //Ищем ход игрока
        for (int i = 0; i < SIZE_Y; i++)
            for (int j = 0; j < SIZE_X; j++) {
                if (isCellValid(i, j)) {
                    setSym(i, j, PLAYER_DOT);
                    if (checkWin(PLAYER_DOT)) {
                        setSym(i, j, AI_DOT);
                        return;
                    }
                    setSym(i, j, EMPTY_DOT);
                }
            }
        for (int i = SIZE_Y; i > 0; i--)
            for (int j = SIZE_X; j > 0; j--) {
                if (isCellValid(i, j)) {
                    setSym(i, j, PLAYER_DOT);
                    if (checkWin(PLAYER_DOT)) {
                        setSym(i, j, AI_DOT);
                        return;
                    }
                    setSym(i, j, EMPTY_DOT);
                }
            }
        // Рандом, если не нашли
        int x;
        int y;
        do {
            x = random.nextInt(SIZE_X);
            y = random.nextInt(SIZE_Y);
        } while (!isCellValid(y, x));
        setSym(y, x, AI_DOT);
    }

    public static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x > SIZE_X - 1 || y > SIZE_Y - 1) {
            return false;
        }
        return field[y][x] == EMPTY_DOT;
    }

    public static boolean isFuelFull() {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if (field[i][j] == EMPTY_DOT) {
                    return false;
                }
            }
        }
        return true;
    }


    //   Задача №2,3
    // Проверяем победу
    private static boolean checkWin(char sym) {
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                if (checkLine(i, j, 0, 1, sym)) return true;   // x
                if (checkLine(i, j, 1, 0, sym)) return true;   // у
                if (checkLine(i, j, 1, 1, sym)) return true;   // х у
                if (checkLine(i, j, -1, 1, sym)) return true;  // х -у
            }
        }
        return false;
    }

    // Проверяем линию
    private static boolean checkLine(int y, int x, int vy, int vx, char symbol) {
        int wayX = x + (WIN - 1) * vx;
        int wayY = y + (WIN - 1) * vy;
        if (wayX < 0 || wayY < 0 || wayX > SIZE_X - 1 || wayY > SIZE_Y - 1) return false;
        for (int i = 0; i < WIN; i++) {
            int itemY = y + i * vy;
            int itemX = x + i * vx;
            if (field[itemY][itemX] != symbol) return false;
        }
        return true;
    }

}