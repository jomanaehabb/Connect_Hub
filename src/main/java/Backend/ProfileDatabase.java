/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author DELL-G3
 */
public class ProfileDatabase {
    private static final String PROFILE_DB = "profiles.json";
    private Map<String, Profile> profiles = new HashMap<>();

    public ProfileDatabase() throws IOException {
        loadDatabase();
    }

    public Profile getProfile(String userId) {
        return profiles.getOrDefault(userId, new Profile("", "", ""));
    }

    public void saveProfile(String userId, Profile profile) throws IOException {
        profiles.put(userId, profile);
        saveDatabase();
    }

    private void loadDatabase() throws IOException {
        if (!Files.exists(Paths.get(PROFILE_DB))) return;
        String json = Files.readString(Paths.get(PROFILE_DB));
        profiles = new Gson().fromJson(json, new TypeToken<Map<String, Profile>>() {}.getType());
    }

    private void saveDatabase() throws IOException {
        String json = new Gson().toJson(profiles);
        Files.writeString(Paths.get(PROFILE_DB), json);
    }
}
