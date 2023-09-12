package FileManipulator;

import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class FileManipulator {

    
    public ArrayList<File> searchFiles(Path directory, String extension) {
        ArrayList<File> filePaths = new ArrayList<>();
        File directoryFile = new File(directory.toString());
        if (directoryFile.isDirectory()) {
            
            // Gets a list of files in directory passed to function
            File[] files = directoryFile.listFiles();
            
            // If list is not empty
            if (files != null) {
                for (File file : files) {
                    
                    // loops through files and checks if any are inner directories
                    if(file.isDirectory()) {
                        
                        // If it finds an inner directory - recursively call the search function again 
                        //until no sub directories are present
                        searchFiles(file.toPath(), extension);
                    } else {
                        
                        // if file name ends with provided extension, add to list
                        if(file.getName().endsWith(extension)){
                            filePaths.add(file);
                        }
                    }
                }
            }
        }
        
        return filePaths;
    }

    public void deleteFile(Path filePath) {
        File fileToDelete = new File(filePath.toString());
        fileToDelete.delete();
    }

    public void copyFile(String sourcePath, String destinationPath) throws IOException {
        String[] targetFileSplit = sourcePath.split("/");
        
        // gets the name of the file to make a copy.
        String targetFileName = targetFileSplit[targetFileSplit.length - 1];
        
        // creates a new file to copy to with the path specified
        File newFile = new File(destinationPath + targetFileName);
        
        System.out.println("\nCopying file '" + targetFileName + "' to '" + destinationPath + "' ...");
        
        if(newFile.createNewFile()) {
            
            System.out.println("New File Created: " + newFile);
            
            // Creates input and output streams to read and write to and from files
            FileInputStream stream = new FileInputStream(sourcePath);
            FileOutputStream outputStream = new FileOutputStream(newFile);
            
            int i;
            while((i = stream.read()) != -1) {
                outputStream.write(i);
            }
            if(stream != null) {
                stream.close();
            }
            if (outputStream != null) {  
                outputStream.close();  
            }  
        }
        
    }
    
}
