package ou5;

/**
 * Created by Linus on 2017-12-10.
 */

public class Punkt {
    private String namn;
    private int x;
    private int y;

    public Punkt(Punkt p) {
        this.namn = p.getNamn();
        this.x = p.getX();
        this.y = p.getY();
    }

    public Punkt(String name, int x, int y) {
        this.namn = name;
        this.x = x;
        this.y = y;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point: " + this.namn + " {X: " + this.x + ", Y: " + this.y + "}";
    }

    public double avstand(Punkt p2) {
        return Math.sqrt(Math.pow((p2.getX() - this.x), 2) + Math.pow(p2.getY() - this.y, 2));
    }
}
