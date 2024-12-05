package main.java.Backend;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FileReader {
    public ArrayList<Story> readStoriesFile(){
        ArrayList<Story> stories = new ArrayList<>();
        try{
            String json = new String(Files.readAllBytes(Paths.get(C:\Users\Kimo Store\Desktop\meow.txt)));
            JSONArray postsArray = new JSONArray(json);
        }
        catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Error loading file.");
        }
    }
}
