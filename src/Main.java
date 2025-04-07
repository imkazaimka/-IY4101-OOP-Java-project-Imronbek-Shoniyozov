import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


    public static int getValidatedInt(String prompt, Scanner scanner) {
        int value;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                scanner.nextLine(); // consume newline
                break;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine(); // discard invalid input
            }
        }
        return value;
    }


    public static boolean getValidatedBoolean(String prompt, Scanner scanner) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextBoolean()) {
                boolean result = scanner.nextBoolean();
                scanner.nextLine(); // consume newline
                return result;
            } else {
                System.out.println("Invalid input. Please enter 'true' or 'false'.");
                scanner.nextLine(); // discard invalid input
            }
        }
    }


    public static void pause(Scanner scanner) {
        System.out.print("Press Enter to continue...");
        scanner.nextLine();
    }


    static void printMainMenu() {
        System.out.println("\n***********************************");
        System.out.println("       SHAPE MANAGEMENT MENU       ");
        System.out.println("***********************************");
        System.out.println("1. Add a Shape");
        System.out.println("2. Remove a Shape by Position");
        System.out.println("3. Get Information about a Shape by Position");
        System.out.println("4. Get Area and Perimeter of a Shape by Position");
        System.out.println("5. Display Information of All Shapes");
        System.out.println("6. Translate All Shapes");
        System.out.println("7. Scale All Shapes");
        System.out.println("0. Quit");
        System.out.println("***********************************");
    }

    public static void main(String[] args) {
        ShapeManager manager = new ShapeManager();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            printMainMenu();
            int choice = getValidatedInt("Enter your choice: ", scanner);

            switch (choice) {
                case 1:
                    manager.addShape();
                    pause(scanner);
                    break;
                case 2:
                    manager.removeShape();
                    pause(scanner);
                    break;
                case 3:
                    manager.getShapeInfo();
                    pause(scanner);
                    break;
                case 4:
                    manager.viewShapeMetrics();
                    pause(scanner);
                    break;
                case 5:
                    manager.listShapes();
                    pause(scanner);
                    break;
                case 6:
                    manager.translateShapes();
                    pause(scanner);
                    break;
                case 7:
                    manager.scaleShapes();
                    pause(scanner);
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
        System.out.println("Exiting Shape Management Application. Goodbye!");
        scanner.close();
    }
}
