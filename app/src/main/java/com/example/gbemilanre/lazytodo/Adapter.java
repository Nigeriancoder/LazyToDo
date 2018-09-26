package com.example.gbemilanre.lazytodo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import java.util.ArrayList;

import static android.content.ContentValues.TAG;


public class Adapter extends ArrayAdapter<DataSource> {


    public Adapter(@NonNull Context context,  @NonNull ArrayList<DataSource> objects) {
        super(context, 0, objects);
    }


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.to_do_items, parent, false);
        }

        DataSource newTask = getItem(position);

        RadioButton radioButton = listItemView.findViewById(R.id.radioButton);
        Log.d(TAG, "getView: " + newTask.getmTaskName());
        radioButton.setText(newTask.getmTaskName());

        TextView description =listItemView.findViewById(R.id.textView);
        description.setText(newTask.getmTaskDescription());

        TextView date = listItemView.findViewById(R.id.textView2);
        date.setText(newTask.getmTaskDate());

        return listItemView;
    }
}
