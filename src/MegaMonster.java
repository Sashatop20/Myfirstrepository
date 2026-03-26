import java.beans.PropertyVetoException;
import java.util.Random;
import java.util.Scanner;

public class MegaMonster extends Monster {

    Random random = new Random();

    MegaMonster(int sizeBoard) {
        super(sizeBoard);
        String image = "\uD83D\uDC7E";

    }

    public boolean taskMonster(int key) {
        int a = random.nextInt(600);
        int b = random.nextInt(600);
        int answer = a + b;

        System.out.println("Ты встретил мегамонстра который отнимает 2 жизни!! Решите задачу");
        System.out.println(a + "+" + b + " = ? ");
        Scanner scanner = new Scanner(System.in);
        int user = scanner.nextInt();


        if (user == answer) {
            System.out.println("Верно! Ты победил этого мегамонстра!");
        }
        return false;
    }
}

