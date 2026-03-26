import java.util.Random;
import java.util.Scanner;

public class BigMonster extends Monster {
    public BigMonster(int s) {
        super(s);

    }

    public String getImage() {
        return image;
    }

    @Override
    public boolean taskMonster(int difficultGame) {
        System.out.println("Решите задачу:");
        if (difficultGame == 1) {
            return taskMonster();
        } else {
            Random random = new Random();
            int x = random.nextInt(10 * (difficultGame - 1), 10 * difficultGame);
            int y = random.nextInt(10 * (difficultGame - 1), 10 * difficultGame);
            int z = random.nextInt(100 * (difficultGame - 1), 100 * difficultGame);
            int trueAnswer = x * y - z;
            System.out.println("Реши пример: " + x + " * " + y + " - " + z + " = ?");
            Scanner scanner = new Scanner(System.in);
            int ans = scanner.nextInt();
            if (trueAnswer == ans) {
                System.out.println("Верно! Ты победил монстра");
                return true;
            }
            System.out.println("Ты проиграл эту битву!");
            return false;
        }
    }

    public boolean taskMonster() {
        return super.taskMonster(0);
    }
}
