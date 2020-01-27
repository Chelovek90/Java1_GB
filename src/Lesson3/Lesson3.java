package Lesson3;

import java.util.Random;
import java.util.Scanner;

public class Lesson3 {
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';
    private static final char DOT_EMPTY = '.';
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static int fieldSizeY;
    private static int fieldSizeX;
    private static int victoryCondition;
    private static char[][] field;

    private static void initField() {
        System.out.println("Enter size field (y/x):");
        fieldSizeY = SCANNER.nextInt();
        fieldSizeX = SCANNER.nextInt();
        System.out.println("Enter victory condition:");
        victoryCondition = SCANNER.nextInt();

        field = new char[fieldSizeY][fieldSizeX];
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                field[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printField() {
        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print("|");
            for (int j = 0; j < fieldSizeX; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
    }

    private static void humanTurn() {
        int y;
        int x;
        do {
            System.out.println("You move (y x ):");
            y = SCANNER.nextInt() - 1;
            x = SCANNER.nextInt() - 1;
        } while (!isCellEmpty(y, x) || !isCellValid(y, x));
        field[y][x] = DOT_HUMAN;
    }

    private static boolean isCellValid(int y, int x) {
        return y >= 0 && y <= fieldSizeY && x >= 0 && x < fieldSizeX;
    }

    private static boolean isCellEmpty(int y, int x) {
        return field[y][x] == DOT_EMPTY;
    }

    private static void aiTurn() {
        int y;
        int x;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isCellEmpty(y, x));
        field[y][x] = DOT_AI;
    }

    private static boolean isDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

/*    2. Переделать проверку победы, чтобы она не была реализована просто набором условий,
например, с использованием циклов.
 */
//    private static boolean checkWin(char c) {
//        for (int i = 0; i < 3; i++)
//            if ((field[i][0] == c && field[i][1] == c && field[i][2] == c) || (field[0][i] == c && field[1][i] == c && field[2][i] == c))
//                return true;
//        if ((field[0][0] == c && field[1][1] == c && field[2][2] == c) || (field[2][0] == c && field[1][1] == c && field[0][2] == c))
//            return true;
//        return false;
//    }




/* 3/ Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и
количества фишек 4. Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
 */

    public static boolean checkWin(char c) {
        int n = victoryCondition;
        boolean winDiagonal1;
        boolean winDiagonal2;
        boolean winLineHorizont;
        boolean winLineVertical;
        for (int y = 0; y + n <= fieldSizeY; y++) {
            for (int x = 0; x + n <= fieldSizeX; x++) {
                winDiagonal1 = true;
                winDiagonal2 = true;
                for (int step = 0; step < n; step++) {
                    winDiagonal1 = winDiagonal1 & (field[y + step][x + step] == c);
                    winDiagonal2 = winDiagonal2 & (field[y + step][x + (n - 1) - step] == c);
                }
                if (winDiagonal1 | winDiagonal2) {
                    return true;
                }
            }
        }
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x  < fieldSizeX; x++){
                winLineHorizont = true;
                winLineVertical = true;
                if (y+n-1<fieldSizeY){
                    for (int step = 0; step < n; step++) {
                        winLineVertical = winLineVertical & (field[y + step][x] == c);
                    }
                    if (winLineVertical) {
                        return true;
                    }
                }
                if (x+n-1<fieldSizeX){
                    for (int step = 0; step < n; step++) {
                        winLineHorizont = winLineHorizont & (field[y][x+ step] == c);
                    }
                    if (winLineHorizont) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        initField();
        printField();
        System.out.println();
        while (true) {
            humanTurn();
            printField();
            System.out.println();
            if (checkWin(DOT_HUMAN)) {
                System.out.println("You win!");
                break;
            }
            if (isDraw()) {
                System.out.println("Draw!");
                break;
            }
            aiTurn();
            printField();
            System.out.println();
            if (checkWin(DOT_AI)) {
                System.out.println("Computer win! Try again");
                break;
            }
            if (isDraw()) {
                System.out.println("Draw!");
                break;
            }
        }
    }
}
