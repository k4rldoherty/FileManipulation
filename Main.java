package FileManipulator;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileManipulator fileManipulator = new FileManipulator();

        while (true) {
            // Prints Out the Menu
            System.out.println("\nMenu");
            System.out.println("\n1. Search for file.");
            System.out.println("\n2. Delete file.");
            System.out.println("\n3. Copy file.");
            System.out.println("\n4. Exit the program.");
            // Prompts User for Choice
            System.out.print("\nYour choice:");
            // Takes in input in form of an Integer
            int choice = scanner.nextInt();
            // Consumes New Line
            scanner.nextLine();

            //
            switch (choice) {
                case 1:
                    String currentPath = new java.io.File(".").getCanonicalPath();
                    System.out.print("\nCurrent PWD ->" + currentPath);
                    
                    System.out.println("\nFile Search Selected...");
                    System.out.println("\nEnter a directory to search.");
                    String directory = scanner.next();

                    Path pathFromStr = Paths.get(currentPath + directory);
                    
                    System.out.println("\nEnter a file type to search for.");
                    String extension = scanner.next();
                    
                    System.out.println("\nYou have chosen to search for the '" + pathFromStr + "' directory for files ending in '" + extension + "'");

                    ArrayList<File> results = fileManipulator.searchFiles(pathFromStr, extension);

                    if(results.isEmpty()) {
                        System.out.println("\nNo results found, redirecting to main menu...\n");
                        break;
                    } else {
                        int i = 1;
                        for(File file: results) {
                            System.out.println("\nResult " + i + ": " + file);
                            i++;
                        }
                        break;
                    }

                case 2:
                    System.out.println("\nDelete File Selected...");

                    System.out.println("\nSpecify a file path to delete:");
                    String path = scanner.nextLine();

                    System.out.println("\nAre you sure you want to delete this file: '" + path + "' ? Y/N:");
                    String deleteChoice = scanner.nextLine();

                    if (deleteChoice.contains("Y")) {
                        System.out.println("\nDeleting the file '" + path + "' ...");
                        fileManipulator.deleteFile(path);
                    } else if (deleteChoice.contains("N")) {
                        System.out.println("\nNo selected, redirecting to main menu...\n");
                        break;
                    } else {
                        System.out.print("\nPlease choose a valid option.");
                        break;
                    }
                    break;

                case 3:
                    break;


                case 4:
                    System.out.print("Exiting, thank you for using..");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    break;
            }
        }
    }
}
