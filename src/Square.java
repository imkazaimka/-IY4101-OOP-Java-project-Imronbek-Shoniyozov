public class Square extends Shape {
    int side;

    public Square(Coordinates pos, int side) {
        super(pos);
        this.side = side;
    }

    public double getArea() {
        return side * side;
    }

    public double getPerimeter() {
        return 4 * side;
    }

    public String display() {
        return "Square: " + super.display();
    }
}