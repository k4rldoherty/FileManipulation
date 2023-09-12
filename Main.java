package FileManipulator;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileManipulator fileManipulator = new FileManipulator();

        while (true) {
            // Prints Out the Menu
            System.out.println("Menu");
            System.out.println("\n1. Search for file.");
            System.out.println("\n2. Delete file.");
            System.out.println("\n3. Copy file.");
            System.out.println("\n4. Recursively search for a file.");
            System.out.println("\n5. Exit the program.");
            // Prompts User for Choice
            System.out.print("\nYour choice:");
            // Takes in input in form of an Integer
            int choice = scanner.nextInt();
            // Consumes New Line
            scanner.nextLine();

            // 
            switch (choice) {
                case 1:
                    System.out.println("\nFile Search Selected...");
                    System.out.println("\nEnter a directory to search.");
                    
                    String directory = scanner.nextLine();
                    
                    System.out.println("\nYou have chosen to search the " + directory + " directory");
                    System.out.println("\nEnter a file type to search for.");
                    
                    String fileType = scanner.nextLine();
                    
                    System.out.println("\nSearching for " + fileType + " files in the " + directory + " directory");
                    
                    ArrayList<String> filesFound = new ArrayList<>();
                    filesFound = fileManipulator.searchFiles(directory, fileType);
                    
                    if(filesFound.isEmpty()) {
                        System.out.print("No Files Found, Please Try Again\n\n");
                    } else {
                        for(String file: filesFound) {
                            System.out.print(file);
                        }
                    }
                    break;

                case 2:
                    break;
                
                case 3:
                    break;

                case 4:
                    break;
                
                case 5:
                System.out.print("Exiting, thank you for using..");
                    System.exit(0);
                    break;
                    
                    
            
                default:
                    break;
            }
        }
    }
}
