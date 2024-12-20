/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Backend.DataBase;

/**
 *
 * @author DELL-G3
 */


import Backend.Content;
import Backend.Post;
import Backend.Story;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ContentFileReader extends JsonFileReader{
    public ContentFileReader(String path) {
        super(path);
    }

    //Read all Content in the File despite r=the type
    @Override
    public ArrayList<Content> readAll(){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter()).setPrettyPrinting().create();
        ArrayList<Content> Content = new ArrayList<>(); //arrayList creation
        try (FileReader fileReader = new FileReader(getFilePath())) {
            Type contentListType = new TypeToken<ArrayList<Content>>() { //create Type token
            }.getType();
            Content = gson.fromJson(fileReader, contentListType); //create arrayList from file

        } catch (IOException e) {
            e.printStackTrace();
        }
        return Content;
    }

    //return Stories only
    public ArrayList<Story> readAllStories(){
        ArrayList<Story> stories = new ArrayList<>();
        ContentFileReader reader = new ContentFileReader(getFilePath());
        ArrayList<Content> contents = reader.readAll();
        for(Content con : contents){ //filter Stories
            if(con.getContentID().startsWith("S")){
                stories.add(contentToStory(con));
            }
        }
        return stories;
    }

    //return posts only
    public ArrayList<Post> readAllPosts(){
        ArrayList<Post> posts = new ArrayList<>();
        ContentFileReader reader = new ContentFileReader(getFilePath());
        ArrayList<Content> contents = reader.readAll();
        for(Content con : contents){//Filter Posts
            if(con.getContentID().startsWith("P")){
                posts.add(contentToPost(con));
            }
        }
        return posts;
    }

    //Creating story object
    public static Story contentToStory(Content con){
        return new Story(con.getPhoto(),con.getContentID(),con.getAuthorID(),con.getText(),con.getTimePosted());
    }

    //creating post
    public static Post contentToPost(Content con){
        Post post =  new Post(con.getPhoto(),con.getContentID(),con.getAuthorID(),con.getText(),con.getTimePosted());
        return post;
    }
}
