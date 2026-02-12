import java.util.Scanner;

public class Game {
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
        String gaminsFieald = "+ —— + —— + —— +\\n"
        + "|    |    |   |\n"
        + "+ —— + —— + —— +\n"
        + "|    |  " + monster + " |   |\n"
        + "+ —— + —— + —— +\\n"
        + "| " + person + " |   |   |\n"
        + "+ —— + —— + —— +";
        System.out.println(gaminsFieald);
        String begin = "|   | |";
        String end = "|   |";
        String full = begin + monster + end; // |   | Мм |   |
        System.out.println("Привет! Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");
        System.out.println("Количество жизней: " + personeLive);
        Scanner scanner = new Scanner("System. in");
        String answer = scanner.nextLine();
        System.out.println("Ваш ответ \t" + answer);
        if (answer.equals("ДА")) {

        } else {
            System.out.println("Почему ты не захотел со мной играть(");
            System.out.println("Приходи ещё!");

        }

    }
}

