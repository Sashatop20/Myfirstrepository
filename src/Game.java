import java.util.Random;
import java.util.Scanner;

public class Game {
    private static Object flag;

    public static void main(String[] args) {
        int step = 0;
        int sizeBoard = 5;

        Person person = new Person();
        Random r = new Random();
        int n = r.nextInt(sizeBoard);
        person.x = n == 0 ? 1 : n;
        person.y = sizeBoard;
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
        System.out.println("Количество жизней: " + person.live);
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

            while ((personLive > 0) && !(castleX == personX && castleY == personY)) {
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


                        System.out.println("Решите задачу:");
                        if (taskMonster(difficultGame)) {
                            board[personY - 1][personX - 1] = " ";
                            personX = x;
                            personY = y;
                        } else {
                            personLive--;
                        }
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

    private static boolean taskMonster(int key) {
        if (key == 1) {
            Random r = new Random();
            int x = r.nextInt(100);
            int y = r.nextInt(100);
            int trueAnswer = x + y;
            System.out.println("Реши пример: " + x + " + " + y + " = ?");
            Scanner sc = new Scanner(System.in);
            int ans = sc.nextInt();
            if (trueAnswer == ans) {
                System.out.println("Верно! Ты победил монстра");
                return true;
            }
            System.out.println("Ты проиграл эту битву!");
            return false;
        } else if (key == 2) {
            Random r = new Random();
            int x = r.nextInt(200);
            int y = r.nextInt(200);
            int trueAnswer = x + y;
            System.out.println("Реши пример: " + x + " + " + y + " = ?");
            Scanner sc = new Scanner(System.in);
            int ans = sc.nextInt();
            if (trueAnswer == ans) {
                System.out.println("Верно! Ты победил монстра");
                return true;
            }
            System.out.println("Ты проиграл эту битву!");
            return false;
        } else {
            if (key == 3) {
                Random r = new Random();
                int x = r.nextInt(300);
                int y = r.nextInt(300);
                int trueAnswer = x + y;
                System.out.println("Реши пример: " + x + " + " + y + " = ?");
                Scanner sc = new Scanner(System.in);
                int ans = sc.nextInt();
                if (trueAnswer == ans) {
                    System.out.println("Верно! Ты победил монстра");
                    return true;
                }
                System.out.println("Ты проиграл эту битву!");
                return false;
            } else {
                if (key == 4) {
                    Random r = new Random();
                    int x = r.nextInt(400);
                    int y = r.nextInt(400);
                    int trueAnswer = x + y;
                    System.out.println("Реши пример: " + x + " + " + y + " = ?");
                    Scanner sc = new Scanner(System.in);
                    int ans = sc.nextInt();
                    if (trueAnswer == ans) {
                        System.out.println("Верно! Ты победил монстра");
                        return true;
                    }
                    System.out.println("Ты проиграл эту битву!");
                    return false;
                } else {
                    if (key == 5) {
                        Random r = new Random();
                        int x = r.nextInt(500);
                        int y = r.nextInt(500);
                        int trueAnswer = x + y;
                        System.out.println("Реши пример: " + x + " + " + y + " = ?");
                        Scanner sc = new Scanner(System.in);
                        int ans = sc.nextInt();
                        if (trueAnswer == ans) {
                            System.out.println("Верно! Ты победил монстра");
                            return true;
                        }
                        System.out.println("Ты проиграл эту битву!");
                        return false;
                    } else {
                    }
                }
            }
        }
        return false;
    }
}




