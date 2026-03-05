import java.util.Random;
import java.util.Scanner;

public class Game {
    private static Object flag;

    public static void main(String[] args) {
        int step = 0;
        int personX;
        int personY;
        int personeLive = 3;
        int sizeBoard = 5;

        personX = sizeBoard / 2;
        personY = sizeBoard / 2;
        personX = 1 + sizeBoard / 2;
        personY = 1 + sizeBoard / 2;
        step = step + 1;
        step += 1;
        step -= 10;
        step *= 5;
        step /= 2;
        String person = "Г";
        String monster = "Мм";
        String castle = "\uD83C\uDFF0";
        int castleY = 1;
        Random random = new Random();
        int castleX = 1 + random.nextInt(sizeBoard);
        String leftBlock = " | ";
        String rightBlock = " |";
        String wall = " + —— + —— + —— + —— + —— + ";
        String begin = "|   | |";
        String end = "|   |";
        String full = begin + monster + end; // |   | Мм |   |
        System.out.println("Привет! Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");
        System.out.println("Количество жизней: " + personeLive);
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        boolean flag = answer.equals("ДА");
        if (flag) {
            System.out.println("Начинаем играть");
            System.out.println("Выбери сложность игры(от 1 до 5):");
            int difficultGame = scanner.nextInt();
            System.out.println("Выбранная сложность:\t" + difficultGame);
            String[][] board = new String[sizeBoard][sizeBoard];
            for (int y = 1; y <= sizeBoard; y++) {
                for (int x = 1; x <= sizeBoard; x++) {
                    board[y - 1][x - 1] = "  ";
                }
            }

            int count_monster = sizeBoard * sizeBoard - sizeBoard - 1;

            for (int i = 0; i <= count_monster; i++) {
                board[random.nextInt(sizeBoard - 1)][random.nextInt(sizeBoard)] = monster;
            }
            board[castleY - 1][castleX - 1] = castle;

            while ((personeLive > 0) && !(castleX == personX && castleY == personY)) {
                board[personY - 1][personX - 1] = person;
                for (int y = 1; y <= sizeBoard; y++) {
                    System.out.println(wall);
                    for (int x = 1; x <= sizeBoard; x++) {
                        System.out.print(leftBlock);
                        System.out.print(board[y - 1][x - 1]);
                    }

                    System.out.println(rightBlock);
                }
                System.out.println(wall);
                System.out.println(wall);
                for (String[] raw : board) {
                    for (String col : raw) {

                    }
                }
                //  логика хода

                System.out.println("Введите куда будет ходить персонаж(ход возможен только по вертикали и горизонтали на одну клетку; ");
                System.out.println("Координаты персонажа - (x:" + personX + "+ y: " + personY + "))");
                int x = scanner.nextInt();
                int y = scanner.nextInt();

                if (x != personX && y != personY) {
                    System.out.println("Неккоректный ход");
                } else if (Math.abs(x - personX) == 1 || Math.abs(y - personY) == 1) {
                    if (board[personY - 1][personX - 1].equals("  ")) {
                        personX = x;
                        personY = y;
                        step += 1;
                        System.out.println("Ход корректный; Новые координаты: " +
                                personX + ", " + personY + "\nХод номер: " + step);
                    } else if (board[personY - 1][personX - 1].equals(castle)) {
                        System.out.println("Вы прошли игру");
                        break;
                    } else {
                        System.out.println("Решите задачу.");
                        break;
                    }
                } else {
                    System.out.println("Координаты не изменены");
                }
                //конец
            }
        } else if (answer.equals("НЕТ")) {

            System.out.println("Жаль, приходи еще!");
        } else {

            System.out.println("Данные введены некорректно");
            System.out.println("Закончились жизни. Итог: ...");
        }
    }
}
