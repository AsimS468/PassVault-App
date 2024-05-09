package passVault.app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AdminFileManager {

    public static void adminFolder(String adminDirectory) {
        String basePath = "src/";  // Path to the src directory
        File directory = new File(basePath, adminDirectory);
        if (!directory.exists()) {
            directory.mkdirs();  // Create the directory if it doesn't exist
        }
    }

    public static void makeAdminFolder(boolean folderCreate) {
        if (folderCreate) {
            String adminInfo = "data/aud";
            adminFolder(adminInfo);
        }
    }

    public static void makeAdminTXT(boolean txtCreate) throws IOException {
        makeAdminFolder(true);
        if (txtCreate) {
            File masterPasswordFile = new File("src/data/aud/mpf.txt");
            if (!masterPasswordFile.exists()) {  // Only create and write if the file doesn't exist
                masterPasswordFile.createNewFile();  // Create the file
                FileWriter myWriter = new FileWriter(masterPasswordFile);
                myWriter.write("false\n");  // Write the default data
                myWriter.close();
            }
        }
    }


    public static void DefaultTXTdata(boolean textWrite) throws IOException {
        makeAdminTXT(textWrite);  // Pass true if you want to create and write to the file if it doesn't exist
    }
}

