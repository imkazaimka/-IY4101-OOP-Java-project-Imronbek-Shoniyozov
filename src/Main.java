import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShapeManager manager = new ShapeManager();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            printMainMenu();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
                switch (choice) {
                    case 1:
                        manager.addShape();
                        break;
                    case 2:
                        manager.removeShape();
                        break;
                    case 3:
                        manager.getShapeInfo();
                        break;
                    case 4:
                        manager.viewAreaPerimeter();
                        break;
                    case 5:
                        manager.displayAllShapes();
                        break;
                    case 6:
                        manager.translateAllShapes();
                        break;
                    case 7:
                        manager.scaleAllShapes();
                        break;
                    case 0:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid option, please try again.");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Invalid input. Please enter a number corresponding to a menu option.");
                scanner.nextLine(); // clear the invalid input
            }
        }
        System.out.println("Exiting Shape Management Application. Goodbye!");
        scanner.close();
    }

    // Print the main menu options as per the assignment requirements.
    static void printMainMenu() {
        System.out.println("\n***** Shape Management Menu *****");
        System.out.println("1. Add a Shape");
        System.out.println("2. Remove a Shape by Position");
        System.out.println("3. Get Information about a Shape by Position");
        System.out.println("4. Get Area and Perimeter of a Shape by Position");
        System.out.println("5. Display Information of All Shapes");
        System.out.println("6. Translate All Shapes");
        System.out.println("7. Scale All Shapes");
        System.out.println("0. Quit");
        System.out.print("Enter your choice: ");
    }
}
