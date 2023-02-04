package com.example.myapplication;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FileHolderManager {

    private Map<String,Fileholder> fileHolders;

    private String folderPath;

    private main ctx;

    public void init(String folderPath,main ctx){
        this.folderPath = folderPath;
        this.ctx = ctx;
        //get all files in the folder
        File folder = new File(folderPath);
        File[] listOfFiles = folder.listFiles();
        //for each file, create a fileholder and add it to the list
        for (File file : listOfFiles) {
            if (file.isFile()) {
                Fileholder fh = new Fileholder(file.getAbsolutePath(),ctx);
                addFileHolder(file.getName(),fh);
            }
        }
    }

    private FileHolderManager(){
        fileHolders = new HashMap<>();
    }

    static FileHolderManager instance;

    public static FileHolderManager getInstance(){
        if(instance == null){
            instance = new FileHolderManager();
        }
        return instance;
    }

    public void CreateFile(String name,String DefaultContent){
        Fileholder fh = new Fileholder(folderPath+"/"+name,ctx,DefaultContent);

        addFileHolder(name,fh);
    }
    public void CreateFile(String name){
        Fileholder fh = new Fileholder(folderPath+"/"+name,ctx);
        addFileHolder(name,fh);
    }
    public void addFileHolder(String name,Fileholder fileHolder){
        fileHolders.put(name,fileHolder);
    }

    public void removeFileHolder(String name){
        fileHolders.remove(name);
    }

    public void deleteFile(String name){
        Fileholder fh = fileHolders.get(name);
        if (fh == null){

            return;
        }
        fh.deleteFromSystem();
        removeFileHolder(name);
    }


    public Fileholder getFileHolder(String name){
        return fileHolders.get(name);
    }

    public Map<String,Fileholder> getFileHolders(){
        return fileHolders;
    }

    public void clearFileHolders(){
        fileHolders.clear();
    }

    public int getFileHoldersCount(){
        return fileHolders.size();
    }




}
