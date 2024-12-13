package Backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class CounterDatabase {
    
    public static int loadGroupCounterFromFile(String filePath) {
        int counter = 1;
        try (Scanner sc = new Scanner(new File(filePath))) {
            if (sc.hasNextInt())
                counter = sc.nextInt() + 1;
            else
                JOptionPane.showMessageDialog(null, "Error, " +filePath+ " file is empty.");
        } catch (FileNotFoundException e) {
            
        }
        return counter;
    }
    
    public static void saveGroupCounterToFile(int counter, String filePath) {
        try {
            File counterFile = new File(filePath);
            if (!counterFile.exists())
                counterFile.createNewFile();
            FileWriter file = new FileWriter(counterFile);
            file.write(Integer.toString(counter));
            file.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error loading " +filePath+ " file.");
        }
    }
}
