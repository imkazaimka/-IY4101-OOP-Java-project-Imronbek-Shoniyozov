import java.util.InputMismatchException;
import java.util.Scanner;

public class ShapeManager {
    private ShapeList shapeList;
    private Scanner scanner;

    public ShapeManager() {
        shapeList = new ShapeList();
        scanner = new Scanner(System.in);
    }

    // Helper method: Read an integer value with a prompt and validate input.
    private int readValidatedInt(String prompt) {
        int value;
        while (true) {
            System.out.print(prompt);
            try {
                value = scanner.nextInt();
                scanner.nextLine(); // consume newline
                break;
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input. Please enter an integer value.");
                scanner.nextLine(); // clear invalid input
            }
        }
        return value;
    }

    // Helper method: Read a double value with a prompt and validate input.
    private double readValidatedDouble(String prompt) {
        double value;
        while (true) {
            System.out.print(prompt);
            try {
                value = scanner.nextDouble();
                scanner.nextLine(); // consume newline
                break;
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.nextLine(); // clear invalid input
            }
        }
        return value;
    }

    // Helper method: Read a boolean value with a prompt and validate input.
    private boolean readValidatedBoolean(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextBoolean()) {
                boolean result = scanner.nextBoolean();
                scanner.nextLine(); // consume newline
                return result;
            } else {
                System.out.println("Invalid input. Please enter 'true' or 'false'.");
                scanner.nextLine(); // clear invalid input
            }
        }
    }

    // Helper method: Read coordinates for a vertex with auto-correction for negative values.
    private Coordinates readValidatedCoordinates(String vertexName) {
        int x = readValidatedInt(vertexName + " - x (will be converted to positive if negative): ");
        int y = readValidatedInt(vertexName + " - y (will be converted to positive if negative): ");
        if (x < 0 || y < 0) {
            System.out.println("Warning: Negative coordinate entered; automatically converting to positive values.");
            x = Math.abs(x);
            y = Math.abs(y);
        }
        return new Coordinates(x, y);
    }

    // Option 1: Add a new shape.
    public void addShape() {
        System.out.println("\n***********************************");
        System.out.println("         ADD A NEW SHAPE           ");
        System.out.println("***********************************");
        System.out.println("Select shape type to add:");
        System.out.println("1. Rectangle");
        System.out.println("2. Square");
        System.out.println("3. Circle");
        System.out.println("4. Triangle");

        int type = readValidatedInt("Your choice: ");

        switch (type) {
            case 1:
                // Rectangle
                Coordinates rectCoord = readValidatedCoordinates("Rectangle position");
                double width = readValidatedDouble("Enter width (positive): ");
                double length = readValidatedDouble("Enter length (positive): ");
                if (width <= 0 || length <= 0) {
                    System.out.println("Dimensions must be positive. Rectangle not added.");
                } else {
                    shapeList.addShape(new Rectangle(rectCoord, width, length));
                    System.out.println("Rectangle added.");
                }
                break;
            case 2:
                // Square
                Coordinates squareCoord = readValidatedCoordinates("Square position");
                double side = readValidatedDouble("Enter side length (positive): ");
                if (side <= 0) {
                    System.out.println("Side length must be positive. Square not added.");
                } else {
                    shapeList.addShape(new Square(squareCoord, side));
                    System.out.println("Square added.");
                }
                break;
            case 3:
                // Circle
                Coordinates circleCoord = readValidatedCoordinates("Circle center");
                double radius = readValidatedDouble("Enter radius (positive): ");
                if (radius <= 0) {
                    System.out.println("Radius must be positive. Circle not added.");
                } else {
                    shapeList.addShape(new Circle(circleCoord, radius));
                    System.out.println("Circle added.");
                }
                break;
            case 4:
                // Triangle
                System.out.println("Enter coordinates for Triangle vertices:");
                Coordinates v1 = readValidatedCoordinates("Vertex 1");
                Coordinates v2 = readValidatedCoordinates("Vertex 2");
                Coordinates v3 = readValidatedCoordinates("Vertex 3");

                // Validate that all vertices are distinct.
                if ((v1.getX() == v2.getX() && v1.getY() == v2.getY()) ||
                        (v1.getX() == v3.getX() && v1.getY() == v3.getY()) ||
                        (v2.getX() == v3.getX() && v2.getY() == v3.getY())) {
                    System.out.println("Vertices must be distinct. Triangle not added.");
                    break;
                }

                Triangle triangle = new Triangle(v1, v2, v3);

                // Validate that the triangle is non-degenerate (area != 0)
                if (triangle.getArea() == 0) {
                    System.out.println("Vertices are collinear. Not a valid triangle. Triangle not added.");
                    break;
                }
                shapeList.addShape(triangle);
                System.out.println("Triangle added.");
                break;
            default:
                System.out.println("Invalid shape type selected.");
        }
    }

    // Option 2: Remove a shape by its position.
    public void removeShape() {
        System.out.println("\n--- REMOVE A SHAPE ---");
        int index = readValidatedInt("Enter the shape number to remove: ");
        Shape removed = shapeList.removeShape(index - 1);
        if (removed != null) {
            System.out.println("Removed: " + removed.display());
        }
    }

    // Option 3: Get information about a shape by its position.
    public void getShapeInfo() {
        System.out.println("\n--- GET SHAPE INFORMATION ---");
        int index = readValidatedInt("Enter the shape number to get information: ");
        Shape s = shapeList.getShape(index - 1);
        if (s != null) {
            System.out.println("Shape Info: " + s.display());
        }
    }

    // Option 4: Get area and perimeter of a shape by its position.
    public void viewShapeMetrics() {
        System.out.println("\n--- VIEW AREA & PERIMETER ---");
        int index = readValidatedInt("Enter the shape number to view area and perimeter: ");
        Shape s = shapeList.getShape(index - 1);
        if (s == null) {
            System.out.println("Invalid shape number.");
        } else {
            System.out.println("Area: " + s.getArea());
            System.out.println("Perimeter: " + s.getPerimeter());
        }
    }

    // Option 5: Display information of all shapes.
    public void listShapes() {
        System.out.println("\n--- LIST OF ALL SHAPES ---");
        System.out.println(shapeList.display());
    }

    // Option 6: Translate all shapes by a given (dx, dy).
    public void translateShapes() {
        System.out.println("\n--- TRANSLATE SHAPES ---");
        int dx = readValidatedInt("Enter translation dx: ");
        int dy = readValidatedInt("Enter translation dy: ");
        shapeList.translateShapes(dx, dy);
        System.out.println("All shapes translated by (" + dx + ", " + dy + ").");
    }

    // Option 7: Scale all shapes by a given factor.
    public void scaleShapes() {
        System.out.println("\n--- SCALE SHAPES ---");
        int factor = readValidatedInt("Enter scaling factor (positive integer): ");
        if (factor <= 0) {
            System.out.println("Scaling factor must be positive.");
            return;
        }
        boolean sign = readValidatedBoolean("Scale by multiplication? (true/false): ");
        shapeList.scaleShapes(factor, sign);
        System.out.println("All shapes scaled.");
    }

    public void drawShapes() {
        System.out.println("\n--- DRAWING SHAPES ---");
        int cols = 50;
        int rows = 20;
        char[][] canvas = new char[rows][cols];

        // Initialize the canvas with dots.
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                canvas[r][c] = '.';
            }
        }

        // Prepare a StringBuilder to collect warnings for shapes outside the canvas.
        StringBuilder warnings = new StringBuilder();

        // Loop over each shape in the shape list.
        for (int i = 0; i < shapeList.getNumberOfShapes(); i++) {
            Shape s = shapeList.getShape(i);
            Coordinates pos = s.getCoordinates();
            int id = i + 1;  // Shape ID for display.
            int x = pos.getX();
            int y = pos.getY();

            // Check if the anchor position is within the canvas bounds.
            if (x < 0 || x >= cols || y < 0 || y >= rows) {
                warnings.append("Shape number ").append(id)
                        .append(" exceeds the boundaries of the graph.\n");
            } else {
                // Determine a symbol for the shape's ID.
                char symbol;
                if (id < 10) {
                    symbol = (char) ('0' + id);
                } else if (id < 36) { // 10 -> A, 11 -> B, etc.
                    symbol = (char) ('A' + id - 10);
                } else {
                    symbol = '*'; // Fallback for IDs 36 and above.
                }
                canvas[y][x] = symbol;
            }
        }

        // Print the canvas.
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(canvas[r][c] + " ");
            }
            System.out.println();
        }

        // Print any warnings about shapes that exceed boundaries.
        if (warnings.length() > 0) {
            System.out.println(warnings.toString());
        }
    }}