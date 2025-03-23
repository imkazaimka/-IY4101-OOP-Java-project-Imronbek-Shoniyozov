public class Circle extends Shape {
    int radius;

    public Circle(Coordinates pos, int radius) {
        super(pos);
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public String display() {
        return "Circle: " + super.display();
    }
}