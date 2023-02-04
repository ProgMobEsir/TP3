package com.example.myapplication;

import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Fileholder {

    String folderPath;
    String path;
    main ctx;

    public Fileholder(String path,main ctx ) {
        this.path = path;
        this.ctx = ctx;
        this.folderPath = path.substring(0,path.lastIndexOf("/"));
        createFile();
    }

    public Fileholder(String path,main ctx,String defaultContent ) {
        this.path = path;
        this.ctx = ctx;
        createFile(defaultContent);
    }

    public void createFile(String defaultContent){

        try {
            File file = new File(path);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
                fillTextToFile(defaultContent);

            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void createFile(){

        try {
            File file = new File(path);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());

            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void deleteFromSystem(){

        File file = new File(path);
        if (file.delete()) {
            System.out.println("Deleted the file: " + file.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }

    }

    public String getTextFromFile() {
        File file = new File(path);
        StringBuilder sb = new StringBuilder();
        String st;

        try {
            BufferedReader br= new BufferedReader(new FileReader(file));

            while ((st = br.readLine()) != null)
                sb.append(st);

        }catch (Exception e){
            e.printStackTrace();
        }

        return sb.toString();

    }

    public void fillTextToFile(String text){
        try{
            File file = new File(path);
            FileWriter writer = new FileWriter(file);
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
