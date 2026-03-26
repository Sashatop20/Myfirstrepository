import java.util.Random;

public class Person {
    private int x, y; //
    String image = "\uD83E\uDDD9\u200D";
    int live = 3;

    public Person(int sizeBoard) {
        Random r = new Random();
        y = sizeBoard;
        int n = r.nextInt(sizeBoard);
        x = n == 0 ? 1 : n;
    }


    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public boolean isMoveCorrect(int x, int y) {
        return this.x == x && Math.abs(this.y - y) == 1 || this.y == y && Math.abs(this.x - x) == 1;
    }
    public int getX(){
        return x;
    }
    public int getY() {
        return y;
    }
    public String getImage(){
        return image;
    }
    public int getLive() {
        return live;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public void downLive() {
        if (live < 0)
            live = 0;
        else
            live--;
    }
}
