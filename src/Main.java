import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x = 100;
        System.out.println(x);
        System.out.println("Hello world");
        int y = 200;
        System.out.println(x+y);
        System.out.println("Hello world");
        int z = 300;
        int sum = y + z;
        System.out.println(sum);
        System.out.println("Hello world");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Hello " + name);
    }
}
