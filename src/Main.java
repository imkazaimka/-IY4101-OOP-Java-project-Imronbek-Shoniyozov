public class Main {
    public static void main(String[] args) {
        ShapeManager manager = new ShapeManager();
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            printMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    manager.addShape();
                    break;
                case 2:
                    manager.listShapes();
                    break;
                case 3:
                    manager.translateShapes();
                    break;
                case 4:
                    manager.scaleShapes();
                    break;
                case 5:
                    manager.viewShapeDetails();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }

        System.out.println("Exiting Shape Management Application. Goodbye!");
    }

    static void printMainMenu() {
        System.out.println("\n***** Shape Management Menu *****");
        System.out.println("1. Add a Shape");
        System.out.println("2. List all Shapes");
        System.out.println("3. Translate all Shapes");
        System.out.println("4. Scale all Shapes");
        System.out.println("5. View Shape Details");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }
}