public class Square extends Shape {
    private double side;

    public Square(Coordinates pos, double side) {
        super(4, pos);
        this.side = side;
    }

    @Override
    public void scale(int factor, boolean sign) {
        if (sign) {
            side *= factor;
        } else {
            side /= factor;
        }
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public String display() {
        return "Square at " + position.display() + ", Side: " + side;
    }
}