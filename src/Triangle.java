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
        v2 = scaleVertex(v1, v2, factor, sign);
        v3 = scaleVertex(v1, v3, factor, sign);
    }

    private Coordinates scaleVertex(Coordinates anchor, Coordinates vertex, int factor, boolean sign) {
        int diffX = vertex.getX() - anchor.getX();
        int diffY = vertex.getY() - anchor.getY();
        int newDiffX = sign ? diffX * factor : diffX / factor;
        int newDiffY = sign ? diffY * factor : diffY / factor;
        return new Coordinates(anchor.getX() + newDiffX, anchor.getY() + newDiffY);
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