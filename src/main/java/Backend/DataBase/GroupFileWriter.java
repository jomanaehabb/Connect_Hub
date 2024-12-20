/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Backend.DataBase;

/**
 *
 * @author DELL-G3
 */

import Backend.Group;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Mnw Emile
 */
public class GroupFileWriter extends JsonFileWriter<Group>{

    public GroupFileWriter(String filePath) {
        super(filePath);
    }

    @Override
    public void writeAll(ArrayList<Group> data) {
         Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()).setPrettyPrinting().create();
        //write content to file
        String json = gson.toJson(data);
        try (FileWriter fileWriter = new FileWriter(getFilePath(), false)) {
            fileWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
    
}
