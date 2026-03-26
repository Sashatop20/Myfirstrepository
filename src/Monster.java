import java.security.PrivateKey;
import java.util.Random;
import java.util.Scanner;

public class Monster {

    private int x, y; //
    String image = "\uD83E\uDDDF\u200D";

    public Monster(int sizeBoard) {
        Random r = new Random();
        int n = r.nextInt(sizeBoard + 1);
        x = n == 0 ? 1 : n;
        n = r.nextInt(sizeBoard + 1);
        y = n == 0 ? 1 : n;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getImage() {
        return image;
    }

    public boolean taskMonster(int key) {
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

    public boolean conflictPerson(int x, int y) {
        return this.x == x && this.y == y;
    }
}

