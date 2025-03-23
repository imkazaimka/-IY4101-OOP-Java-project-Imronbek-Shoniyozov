public class Rectangle extends Shape {
    int width, height;

    public Rectangle(Coordinates pos, int width, int height) {
        super(pos);
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    public String display() {
        return "Rectangle: " + super.display();
    }
}