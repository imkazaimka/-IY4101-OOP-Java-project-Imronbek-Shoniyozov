public class Circle extends Shape {
    private double radius;

    public Circle(Coordinates coord, double radius) {
        super(0, coord);
        this.radius = radius;
    }

    @Override
    public void scale(int factor, boolean sign) {
        if (sign) {
            this.radius *= factor;
        } else {
            this.radius /= factor;
        }
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String display() {
        return "Circle at " + position.display() + ", Radius: " + radius;
    }
}
