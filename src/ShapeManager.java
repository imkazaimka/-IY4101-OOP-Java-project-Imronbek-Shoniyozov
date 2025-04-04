import java.util.InputMismatchException;
import java.util.Scanner;

public class ShapeManager {
    private ShapeList shapeList;
    private Scanner scanner;

    public ShapeManager() {
        shapeList = new ShapeList();
        scanner = new Scanner(System.in);
    }

    // Option 1: Add a new shape based on user input.
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
                        shapeList.addShape(new Rectangle(new Coordinates(rx, ry), width, length));
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
                        shapeList.addShape(new Square(new Coordinates(sx, sy), side));
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
                        shapeList.addShape(new Circle(new Coordinates(cx, cy), radius));
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
                    shapeList.addShape(new Triangle(new Coordinates(t1x, t1y),
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

    // Option 2: Remove a shape by its position.
    public void removeShape() {
        try {
            System.out.print("Enter the shape number to remove: ");
            int index = scanner.nextInt();
            scanner.nextLine(); // consume newline
            Shape removed = shapeList.removeShape(index - 1);
            if (removed != null) {
                System.out.println("Removed: " + removed.display());
            }
        } catch (InputMismatchException ime) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine();
        }
    }

    // Option 3: Get information about a shape by its position.
    public void getShapeInfo() {
        try {
            System.out.print("Enter the shape number to get information: ");
            int index = scanner.nextInt();
            scanner.nextLine(); // consume newline
            Shape s = shapeList.getShape(index - 1);
            if (s != null) {
                System.out.println("Shape Info: " + s.display());
            }
        } catch (InputMismatchException ime) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine();
        }
    }

    // Option 4: Get area and perimeter of a shape by its position.
    public void viewShapeMetrics() {
        try {
            System.out.print("Enter the shape number to view area and perimeter: ");
            int index = scanner.nextInt();
            scanner.nextLine(); // consume newline
            Shape s = shapeList.getShape(index - 1);
            if (s == null) {
                System.out.println("Invalid shape number.");
            } else {
                System.out.println("Area: " + s.getArea());
                System.out.println("Perimeter: " + s.getPerimeter());
            }
        } catch (InputMismatchException ime) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine(); // clear the invalid input
        }
    }

    // Option 5: Display information of all shapes.
    public void listShapes() {
        System.out.println("\n--- List of Shapes ---");
        System.out.println(shapeList.display());
    }

    // Option 6: Translate all shapes by a given (dx, dy).
    public void translateShapes() {
        try {
            System.out.print("Enter translation dx: ");
            int dx = scanner.nextInt();
            System.out.print("Enter translation dy: ");
            int dy = scanner.nextInt();
            shapeList.translateShapes(dx, dy);
            System.out.println("All shapes translated by (" + dx + ", " + dy + ").");
        } catch (InputMismatchException ime) {
            System.out.println("Invalid translation input.");
            scanner.nextLine(); // clear the invalid input
        }
    }

    // Option 7: Scale all shapes by a given factor (using multiplication or division).
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
            shapeList.scaleShapes(factor, sign);
            System.out.println("All shapes scaled.");
        } catch (InputMismatchException ime) {
            System.out.println("Invalid scaling input.");
            scanner.nextLine(); // clear the invalid input
        }
    }
}
