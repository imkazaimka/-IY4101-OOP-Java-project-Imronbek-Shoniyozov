public class Triangle extends Shape {
    // Three vertices of the triangle
    Coordinates v1, v2, v3;

    // Constructor: Receives three Coordinates as vertices.
    // We use the first vertex (v1) as the base position for the Shape.
    public Triangle(Coordinates v1, Coordinates v2, Coordinates v3) {
        super(v1);
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    // Helper method: calculates the distance between two points using the basic formula.
    double distance(Coordinates a, Coordinates b) {
        int dx = b.x - a.x;
        int dy = b.y - a.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Perimeter is the sum of the lengths of the three sides.
    public double getPerimeter() {
        double side1 = distance(v1, v2);
        double side2 = distance(v2, v3);
        double side3 = distance(v3, v1);
        return side1 + side2 + side3;
    }

    // Area using Heron's formula: area = sqrt(s * (s - side1) * (s - side2) * (s - side3))
    public double getArea() {
        double side1 = distance(v1, v2);
        double side2 = distance(v2, v3);
        double side3 = distance(v3, v1);
        double s = (side1 + side2 + side3) / 2.0;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    // Translate the triangle by moving all three vertices.
    public void translate(int dx, int dy) {
        v1.translate(dx, dy);
        v2.translate(dx, dy);
        v3.translate(dx, dy);
    }

    // Returns a string representation of the triangle's properties.
    public String display() {
        return "Triangle: v1=" + v1.toString() +
                ", v2=" + v2.toString() +
                ", v3=" + v3.toString() +
                ", Area=" + getArea() +
                ", Perimeter=" + getPerimeter();
    }
}