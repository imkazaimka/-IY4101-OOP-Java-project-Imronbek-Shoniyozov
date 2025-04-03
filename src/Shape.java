public abstract class Shape {

    protected Coordinates position;
    protected int sides; // Not needed but included for completeness


    public Shape(int noOfSides, Coordinates coord) {
        this.position = coord;
        this.sides = noOfSides;
    }


    public Coordinates getCoordinates() {
        return position;
    }


    public int getSides() {
        return sides;
    }


    public void setCoordinates(Coordinates newCoord) {
        this.position = newCoord;
    }

    public void translate(int dx, int dy) {
        position.translate(dx, dy);
    }

    public abstract void scale(int factor, boolean sign);
    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract String display();
}
