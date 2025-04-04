import java.util.ArrayList;

public class ShapeList {
    private final ArrayList<Shape> listOfShapes;

    public ShapeList() {
        listOfShapes = new ArrayList<>();
    }

    public void addShape(Shape s) {
        listOfShapes.add(s);
    }

    public Shape removeShape(int pos) {
        if (pos >= 0 && pos < listOfShapes.size()) {
            return listOfShapes.remove(pos);
        } else {
            System.out.println("No shape at position " + (pos + 1));
            return null;
        }
    }

    public Shape getShape(int pos) {
        if (pos >= 0 && pos < listOfShapes.size()) {
            return listOfShapes.get(pos);
        } else {
            System.out.println("No shape at position " + (pos + 1));
            return null;
        }
    }

    public void translateShapes(int dx, int dy) {
        for (Shape s : listOfShapes) {
            s.translate(dx, dy);
        }
    }

    public void scaleShapes(int factor, boolean sign) {
        for (Shape s : listOfShapes) {
            s.scale(factor, sign);
        }
    }

    public int getNumberOfShapes() {
        return listOfShapes.size();
    }

    public String display() {
        if (listOfShapes.isEmpty()) {
            return "No shapes in the list.";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listOfShapes.size(); i++) {
            sb.append(i + 1)
                    .append(". ")
                    .append(listOfShapes.get(i).display())
                    .append("\n");
        }
        return sb.toString();
    }

}
