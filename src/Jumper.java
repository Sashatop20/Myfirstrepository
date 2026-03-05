public class Jumper {

    int height;

    public void jump() {
        height += 2;
    }

    public void bigjump() {
        height += 100;
    }
    public static double sqr(double x) {
        return x*x;
    }
    public static void main(String[] args) {
        double y = Math.pow(5.1, 2);
        System.out.println(y);


        Jumper jumper = new Jumper();
        jumper.height = 0;
        jumper.bigjump();
        System.out.println(jumper.height);
    }
}
