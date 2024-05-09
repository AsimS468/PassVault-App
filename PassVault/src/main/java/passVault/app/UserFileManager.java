package passVault.app;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class UserFileManager {
    private static final String customerFolder = "src/main/java/coe528/project/user_data/customer_data/";
    private static final String adminFolder = "src/main/java/coe528/project/user_data/admin_data/";

    public void writeToFile(String filename, String content) {
        String directory = filename.equals("admin.txt") ? adminFolder : customerFolder;
        File dir = new File(directory);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(directory + filename))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFromFile(String filename) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(customerFolder + filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public void deleteFile(String filename) {
        File file = new File(customerFolder + filename);
        if (file.delete()) {
            System.out.println("Deleted the file: " + file.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }

    public List<String> getFilesInDirectory() {
        File directory = new File(customerFolder);
        File[] files = directory.listFiles();
        List<String> fileNames = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    fileNames.add(file.getName());
                }
            }
        }
        return fileNames;
    }
}