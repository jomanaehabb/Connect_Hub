/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Backend.DataBase;

/**
 *
 * @author DELL-G3
 */

import java.util.ArrayList;

public abstract class JsonFileWriter<T extends Database> implements FilePaths {

    private String filePath;

    public String getFilePath() {
        return filePath;
    }

    public JsonFileWriter(String filePath) {
        this.filePath = filePath;
    }

    public abstract void writeAll(ArrayList<T> data);
}