public class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x1, int y1) {
        this.x = x1;
        this.y = y1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public double distance(Coordinates p) {
        int distX = this.x - p.getX();
        int distY = this.y - p.getY();
        return Math.sqrt(distX * distX + distY * distY);
    }

    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public void scale(int factor, boolean sign) {
        if (sign) {
            this.x *= factor;
            this.y *= factor;
        } else {
            this.x /= factor;
            this.y /= factor;
        }
    }
    public String display() {
        String msg = "X = " + x + ", Y = " + y;
        if (x < 0 || y < 0) {
            msg += "\nNote: Negative X or Y, Coordinates are out of zone.\n";
        }
        return msg;
    }
}