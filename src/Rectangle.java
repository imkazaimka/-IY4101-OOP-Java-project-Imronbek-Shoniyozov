public class Rectangle extends Shape {
    private double width;
    private double length;

    public Rectangle(Coordinates pos, double width, double length) {
        super(4, pos);
        this.width = width;
        this.length = length;
    }

    @Override
    public void scale(int factor, boolean sign) {
        if (sign) {
            width *= factor;
            length *= factor;
        } else {
            width /= factor;
            length /= factor;
        }
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public String display() {
        return "Rectangle at " + position.display() + ", Width: " + width + ", Length: " + length;
    }
}