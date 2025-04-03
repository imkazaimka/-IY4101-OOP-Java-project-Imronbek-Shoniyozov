import java.util.ArrayList;
import java.util.Scanner;

public class ShapeManager {
    private ArrayList<Shape> shapes;
    private Scanner scanner;

    public ShapeManager() {
        shapes = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Add a new shape based on user input
    public void addShape() {
        System.out.println("\nSelect shape type to add:");
        System.out.println("1. Rectangle");
        System.out.println("2. Square");
        System.out.println("3. Circle");
        System.out.println("4. Triangle");
        int type = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (type) {
            case 1:
                System.out.print("Enter x coordinate for Rectangle: ");
                int rx = scanner.nextInt();
                System.out.print("Enter y coordinate for Rectangle: ");
                int ry = scanner.nextInt();
                System.out.print("Enter width: ");
                double width = scanner.nextDouble();
                System.out.print("Enter length: ");
                double length = scanner.nextDouble();
                shapes.add(new Rectangle(new Coordinates(rx, ry), width, length));
                System.out.println("Rectangle added.");
                break;
            case 2:
                System.out.print("Enter x coordinate for Square: ");
                int sx = scanner.nextInt();
                System.out.print("Enter y coordinate for Square: ");
                int sy = scanner.nextInt();
                System.out.print("Enter side length: ");
                double side = scanner.nextDouble();
                shapes.add(new Square(new Coordinates(sx, sy), side));
                System.out.println("Square added.");
                break;
            case 3:
                System.out.print("Enter x coordinate for Circle: ");
                int cx = scanner.nextInt();
                System.out.print("Enter y coordinate for Circle: ");
                int cy = scanner.nextInt();
                System.out.print("Enter radius: ");
                double radius = scanner.nextDouble();
                shapes.add(new Circle(new Coordinates(cx, cy), radius));
                System.out.println("Circle added.");
                break;
            case 4:
                System.out.println("Enter coordinates for Triangle vertices:");
                System.out.print("Vertex 1 - x: ");
                int t1x = scanner.nextInt();
                System.out.print("Vertex 1 - y: ");
                int t1y = scanner.nextInt();
                System.out.print("Vertex 2 - x: ");
                int t2x = scanner.nextInt();
                System.out.print("Vertex 2 - y: ");
                int t2y = scanner.nextInt();
                System.out.print("Vertex 3 - x: ");
                int t3x = scanner.nextInt();
                System.out.print("Vertex 3 - y: ");
                int t3y = scanner.nextInt();
                shapes.add(new Triangle(new Coordinates(t1x, t1y),
                        new Coordinates(t2x, t2y),
                        new Coordinates(t3x, t3y)));
                System.out.println("Triangle added.");
                break;
            default:
                System.out.println("Invalid shape type selected.");
        }
        scanner.nextLine();
    }


    public void listShapes() {
        System.out.println("\n--- List of Shapes ---");
        if (shapes.isEmpty()) {
            System.out.println("No shapes available.");
        } else {
            for (int i = 0; i < shapes.size(); i++) {
                System.out.println((i + 1) + ". " + shapes.get(i).display());
            }
        }
    }

    // Translate all shapes by a given (dx, dy).
    public void translateShapes() {
        System.out.print("Enter translation dx: ");
        int dx = scanner.nextInt();
        System.out.print("Enter translation dy: ");
        int dy = scanner.nextInt();
        for (Shape s : shapes) {
            s.translate(dx, dy);
        }
        System.out.println("All shapes translated by (" + dx + ", " + dy + ").");
    }

    // Scale all shapes by a given factor (using multiplication or division).
    public void scaleShapes() {
        System.out.print("Enter scaling factor: ");
        int factor = scanner.nextInt();
        System.out.print("Scale by multiplication? (true/false): ");
        boolean sign = scanner.nextBoolean();
        for (Shape s : shapes) {
            s.scale(factor, sign);
        }
        System.out.println("All shapes scaled.");
    }

    // View detailed information of a shape by its index.
    public void viewShapeDetails() {
        System.out.print("Enter the shape number to view details: ");
        int index = scanner.nextInt();
        if (index < 1 || index > shapes.size()) {
            System.out.println("Invalid shape number.");
        } else {
            System.out.println("Shape Details: " + shapes.get(index - 1).display());
        }
    }
}