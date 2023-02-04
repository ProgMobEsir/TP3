package com.example.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class main extends Activity {

    ListView FileList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Question6();

    }

    public void Question1_3(){
        setContentView(R.layout.layout1);

        FileHolderManager.getInstance().init(this.getFilesDir().toString(),this);

        FileHolderManager.getInstance().CreateFile("RonanYann.txt","Bonjour Yohan Bourcier");

        Fileholder fh = FileHolderManager.getInstance().getFileHolder("RonanYann.txt");
        //get the text of the textview from the layout
        TextView textView = findViewById(R.id.TextView_FileContent);
        String ctn = "Content :" + fh.getTextFromFile();
        textView.setText(ctn);
        fh.getTextFromFile();

    }

    public void Question4(){
        setContentView(R.layout.layout_q4);
        FileHolderManager.getInstance().init(this.getFilesDir().toString(),this);
        FileHolderManager.getInstance().CreateFile("RonanYann2.txt","Bonjour Yohan Bourcier");
        Fileholder fh = FileHolderManager.getInstance().getFileHolder("RonanYann2.txt");

        //get the text of the textview from the layout
        TextView textView = findViewById(R.id.TextView_FileContent);
        String ctn = fh.getTextFromFile();
        textView.setText(ctn);


        Button btnOk = (Button) findViewById(R.id.OKButton);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the text of the textview from the layout
                TextView textView = findViewById(R.id.TextView_FileContent);
                FileHolderManager.getInstance().getFileHolder("RonanYann2.txt").fillTextToFile(textView.getText().toString());

            }
        });

        Button btnCancel = (Button) findViewById(R.id.CancelButton);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the text of the textview from the layout
                TextView textView = findViewById(R.id.TextView_FileContent);
                String ctn = FileHolderManager.getInstance().getFileHolder("RonanYann2.txt").getTextFromFile();
                textView.setText(ctn);
            }
        });

    }

    public void Question5(){
        setContentView(R.layout.layout_q5);
        FileHolderManager.getInstance().init(this.getFilesDir().toString(),this);

        Button btnOk = (Button) findViewById(R.id.OKButton);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the text of the textview from the layout
                TextView textView = findViewById(R.id.TextView_Filename);
                if (!textView.getText().toString().equals("")){
                    FileHolderManager.getInstance().CreateFile(textView.getText().toString());
                }
                else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(main.this);
                    builder.setMessage("Please enter a filename")
                            .setTitle("Missing Value");
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });


    }

    public void Question6(){
        setContentView(R.layout.layout_q6);
        FileHolderManager.getInstance().init(this.getFilesDir().toString(),this);

        FileList = (ListView) findViewById(R.id.ListView_Files);

        reloadFileList();

        Button btnOk = (Button) findViewById(R.id.OKButton);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the text of the textview from the layout
                TextView textView = findViewById(R.id.TextView_Filename);
                if (!textView.getText().toString().equals("")){
                    FileHolderManager.getInstance().CreateFile(textView.getText().toString());
                    reloadFileList();
                    AlertDialog.Builder builder = new AlertDialog.Builder(main.this);
                    builder.setMessage("File : " + textView.getText().toString() + "succesfully created")
                            .setTitle("Succes");
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(main.this);
                    builder.setMessage("Please enter a filename")
                            .setTitle("Missing Value");
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });
    }

    public void reloadFileList(){
        Map<String,Fileholder> files = FileHolderManager.getInstance().getFileHolders();
        ListWithButonAdapter adapterList = new ListWithButonAdapter(this, Arrays.asList(files.keySet().toArray(new String[0])) );
        FileList.setAdapter(adapterList);
    }





}
