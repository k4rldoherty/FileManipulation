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
            String currentPath = new java.io.File(".").getCanonicalPath();

            //
            switch (choice) {
                case 1:
                    System.out.print("\nCurrent PWD ->" + currentPath);

                    System.out.println("\nFile Search Selected...");
                    System.out.println("\nEnter a directory to search.");
                    String directory = scanner.next();

                    Path pathFromStr = Paths.get(currentPath + directory);

                    System.out.println("\nEnter a file type to search for.");
                    String extension = scanner.next();

                    System.out.println("\nYou have chosen to search for the '" + pathFromStr
                            + "' directory for files ending in '" + extension + "'");

                    ArrayList<File> results = fileManipulator.searchFiles(pathFromStr, extension);

                    if (results.isEmpty()) {
                        System.out.println("\nNo results found, redirecting to main menu...\n");
                        break;
                    } else {
                        int i = 1;
                        for (File file : results) {
                            System.out.println("\nResult " + i + ": " + file);
                            i++;
                        }
                        break;
                    }

                case 2:
                    System.out.println("\nDelete File Selected...");
                    System.out.print("\nCurrent PWD ->" + currentPath);

                    System.out.println("\nSpecify an ABSOLUTE file path to delete:");
                    String path = scanner.nextLine();

                    Path pathFromStrDelete = Paths.get(currentPath + path);

                    System.out.println("\nAre you sure you want to delete this file: '" + path + "' ? Y/N:");
                    String deleteChoice = scanner.nextLine();

                    if (deleteChoice.contains("Y")) {
                        System.out.println("\nDeleting the file '" + path + "' ...");
                        fileManipulator.deleteFile(pathFromStrDelete);
                    } else if (deleteChoice.contains("N")) {
                        System.out.println("\nNo selected, redirecting to main menu...\n");
                        break;
                    } else {
                        System.out.print("\nPlease choose a valid option.");
                        break;
                    }
                    break;

                case 3:
                    System.out.println("\nCopy File Selected...");
                    System.out.print("\nCurrent PWD ->" + currentPath);

                    System.out.println("\nSpecify an ABSOLUTE path to a file you want to copy to another location:");
                    String copySource = scanner.next();

                    System.out.println("\nSpecify an ABSOLUTE path to the location you want to copy the file to:");
                    String copyDestination = scanner.next();

                    // Path copyFileFrom = Paths.get(copySource);
                    // Path fileDestination = Paths.get(copyDestination);

                    fileManipulator.copyFile(copySource, copyDestination);

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
