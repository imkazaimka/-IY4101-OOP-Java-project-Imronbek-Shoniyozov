import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ShapeManager {
    private ArrayList<Shape> shapes;
    private Scanner scanner;

    public ShapeManager() {
        shapes = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Add a new shape based on user input.
    public void addShape() {
        try {
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
                    System.out.print("Enter width (positive): ");
                    double width = scanner.nextDouble();
                    System.out.print("Enter length (positive): ");
                    double length = scanner.nextDouble();
                    if(width <= 0 || length <= 0) {
                        System.out.println("Dimensions must be positive. Shape not added.");
                    } else {
                        shapes.add(new Rectangle(new Coordinates(rx, ry), width, length));
                        System.out.println("Rectangle added.");
                    }
                    break;
                case 2:
                    System.out.print("Enter x coordinate for Square: ");
                    int sx = scanner.nextInt();
                    System.out.print("Enter y coordinate for Square: ");
                    int sy = scanner.nextInt();
                    System.out.print("Enter side length (positive): ");
                    double side = scanner.nextDouble();
                    if(side <= 0) {
                        System.out.println("Side length must be positive. Shape not added.");
                    } else {
                        shapes.add(new Square(new Coordinates(sx, sy), side));
                        System.out.println("Square added.");
                    }
                    break;
                case 3:
                    System.out.print("Enter x coordinate for Circle: ");
                    int cx = scanner.nextInt();
                    System.out.print("Enter y coordinate for Circle: ");
                    int cy = scanner.nextInt();
                    System.out.print("Enter radius (positive): ");
                    double radius = scanner.nextDouble();
                    if(radius <= 0) {
                        System.out.println("Radius must be positive. Shape not added.");
                    } else {
                        shapes.add(new Circle(new Coordinates(cx, cy), radius));
                        System.out.println("Circle added.");
                    }
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
        } catch (InputMismatchException ime) {
            System.out.println("Invalid input. Please enter numeric values where required.");
            scanner.nextLine(); // clear the invalid input
        }
    }

    // List all shapes with a brief description.
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
        try {
            System.out.print("Enter translation dx: ");
            int dx = scanner.nextInt();
            System.out.print("Enter translation dy: ");
            int dy = scanner.nextInt();
            for (Shape s : shapes) {
                s.translate(dx, dy);
            }
            System.out.println("All shapes translated by (" + dx + ", " + dy + ").");
        } catch (InputMismatchException ime) {
            System.out.println("Invalid translation input.");
            scanner.nextLine(); // clear the invalid input
        }
    }

    // Scale all shapes by a given factor (using multiplication or division).
    public void scaleShapes() {
        try {
            System.out.print("Enter scaling factor (positive integer): ");
            int factor = scanner.nextInt();
            if(factor <= 0) {
                System.out.println("Scaling factor must be positive.");
                return;
            }
            System.out.print("Scale by multiplication? (true/false): ");
            boolean sign = scanner.nextBoolean();
            for (Shape s : shapes) {
                s.scale(factor, sign);
            }
            System.out.println("All shapes scaled.");
        } catch (InputMismatchException ime) {
            System.out.println("Invalid scaling input.");
            scanner.nextLine(); // clear the invalid input
        }
    }

    // View detailed metrics (area and perimeter) of a specific shape by its index.
    public void viewShapeMetrics() {
        try {
            System.out.print("Enter the shape number to view metrics: ");
            int index = scanner.nextInt();
            if (index < 1 || index > shapes.size()) {
                System.out.println("Invalid shape number.");
            } else {
                Shape s = shapes.get(index - 1);
                System.out.println("Area: " + s.getArea());
                System.out.println("Perimeter: " + s.getPerimeter());
            }
        } catch (InputMismatchException ime) {
            System.out.println("Invalid input. Please enter a valid shape number.");
            scanner.nextLine(); // clear the invalid input
        }
    }
}