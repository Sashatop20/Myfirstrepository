import java.util.Random;
import java.util.Scanner;

public class Game {
    private static Object flag;

    public static void main(String[] args) {
        int step = 0;
        int sizeBoard = 5;


        Person person = new Person(sizeBoard);
//        Monster monster = new Monster(sizeBoard);
//        monster.taskMonster(4);
//
//        monster = new BigMonster(2,2);
//        monster.taskMonster(4);
        String castle = "\uD83C\uDFF0";
        int castleY = 1;
        Random random = new Random();
        int castleX = 1 + random.nextInt(sizeBoard);
        String leftBlock = " | ";
        String rightBlock = " |";
        String wall = " + —— + —— + —— + —— + —— + ";
        String begin = "|   | |";
        String end = "|   |";
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
            Monster[] arrMonster = new Monster[count_monster + 1];
            int count = 0;
            Monster test;
            while (count <= count_monster) {
                int z = random.nextInt(3);
                if (z == 0) {
                    test = new Monster(sizeBoard);
                } else if (z == 1){
                    test = new BigMonster(sizeBoard);
                }else{
                    test = new MegaMonster(sizeBoard);
                }
                if (board[test.getY() - 1][test.getX() - 1].equals("  ")) {
                    board[test.getY() - 1][test.getX() - 1] = test.getImage();
                    arrMonster[count] = test;
                    count++;
                }
            }
            board[castleY - 1][castleX - 1] = castle;

            while ((person.live > 0) && !(castleX == person.getX() && castleY == person.getY())) {
                board[person.getY() - 1][person.getX() - 1] = person.getImage();
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
                System.out.println("Координаты персонажа - (x:" + person.getX() + "+ y: " + person.getY() + "))");
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                if (person.isMoveCorrect(x, y)) {
                    String next = board[y - 1][x - 1];
                    if (next.equals("  ")) {
                        board[person.getY() - 1][person.getX() - 1] = "  ";
                        person.move(x, y);
                        step++;
                        System.out.println("Ход корректный; Новые координаты: " + person.getX() + ", " + person.getY() +
                                "\\nХод номер: " + step);
                    } else if (next.equals(castle)) {
                        System.out.println("Вы прошли игру!");
                        break;

                    } else {
                        System.out.println("Решите задачу:");
                        for (Monster monster : arrMonster) {
                            if (monster.conflictPerson(x, y)) {
                                if (monster.taskMonster(sizeBoard)) {
                                    board[person.getX() - 1][person.getY() - 1] = "  ";
                                    person.move(x, y);

                                } else {
                                    person.downLive();
                                }
                                break;
                            }
                        }
                    }
                } else {
                    System.out.println("Некорректный ход");
                }
            }
        } else if (answer.equals("НЕТ")) {

            System.out.println("Жаль, приходи еще!");
        } else {

            System.out.println("Данные введены некорректно");
            System.out.println("Закончились жизни. Итог: ...");
        }
    }
}