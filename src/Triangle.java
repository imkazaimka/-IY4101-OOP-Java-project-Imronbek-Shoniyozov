public class Triangle extends Shape {
    private Coordinates v1;
    private Coordinates v2;
    private Coordinates v3;

    public Triangle(Coordinates v1, Coordinates v2, Coordinates v3) {
        super(3, v1);
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    @Override
    public void scale(int factor, boolean sign) {
        // Scale vertex 2 relative to vertex 1 (anchor)
        int diffX2 = v2.getX() - v1.getX();
        int diffY2 = v2.getY() - v1.getY();
        int newDiffX2 = sign ? diffX2 * factor : diffX2 / factor;
        int newDiffY2 = sign ? diffY2 * factor : diffY2 / factor;
        v2 = new Coordinates(v1.getX() + newDiffX2, v1.getY() + newDiffY2);

        // Scale vertex 3 relative to vertex 1 (anchor)
        int diffX3 = v3.getX() - v1.getX();
        int diffY3 = v3.getY() - v1.getY();
        int newDiffX3 = sign ? diffX3 * factor : diffX3 / factor;
        int newDiffY3 = sign ? diffY3 * factor : diffY3 / factor;
        v3 = new Coordinates(v1.getX() + newDiffX3, v1.getY() + newDiffY3);
    }

    @Override
    public double getArea() {
        double a = v1.distance(v2);
        double b = v2.distance(v3);
        double c = v3.distance(v1);
        double s = (a + b + c) / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double getPerimeter() {
        return v1.distance(v2) + v2.distance(v3) + v3.distance(v1);
    }

    @Override
    public void translate(int dx, int dy) {
        v1.translate(dx, dy);
        v2.translate(dx, dy);
        v3.translate(dx, dy);
    }

    @Override
    public String display() {
        return "Triangle: Vertex1: " + v1.display() +
                ", Vertex2: " + v2.display() +
                ", Vertex3: " + v3.display() +
                ", Area: " + getArea() +
                ", Perimeter: " + getPerimeter();
    }
}
