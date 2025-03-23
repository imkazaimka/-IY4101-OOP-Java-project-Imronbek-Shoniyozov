public abstract class Shape {
    Coordinates position;

    public Shape(Coordinates position) {
        this.position = position;
    }


    abstract double getArea();
    abstract double getPerimeter();


    public void translate(int dx, int dy) {
        position.translate(dx, dy);
    }

    public String display() {
        return "Position: " + position.toString() +
                ", Area: " + getArea() +
                ", Perimeter: " + getPerimeter();
    }
}