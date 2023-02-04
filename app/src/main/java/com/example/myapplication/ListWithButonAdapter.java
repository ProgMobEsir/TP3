package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ListWithButonAdapter extends BaseAdapter {

    private main mContext;
    private List<String> fileNames;

    public ListWithButonAdapter(main context, List fileNames_) {
        super();
        mContext = context;
        fileNames = fileNames_;
    }

    public int getCount() {
        // return the number of records
        return fileNames.size();
    }

    // getView method is called for each item of ListView
    public View getView(int position, View view, ViewGroup parent) {
        // inflate the layout for each item of listView
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.files_list_row, parent, false);


        // get the reference of textView and button
        TextView txtSchoolTitle = (TextView) view.findViewById(R.id.TextView_Filename);
        Button btnAction = (Button) view.findViewById(R.id.btnDelete);

        // Set the title and button name
        txtSchoolTitle.setText(fileNames.get(position));
        btnAction.setText("Supprimer");

        // Click listener of button
        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String filename = ((TextView) ((ViewGroup) view.getParent()).findViewById(R.id.TextView_Filename)).getText().toString();
                FileHolderManager.getInstance().deleteFile(filename);
                mContext.reloadFileList();
            }
        });

        return view;
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

}

