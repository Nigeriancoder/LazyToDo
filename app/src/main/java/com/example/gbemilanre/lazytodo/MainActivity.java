package com.example.gbemilanre.lazytodo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Switch;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ArrayList<DataSource> tasks = new ArrayList<>();
        final Adapter adapter = new Adapter(this, tasks);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.myFAB);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.add_item, null);
                final EditText taskName = (EditText) mView.findViewById(R.id.taskName);
                final EditText taskDesctiption = (EditText) mView.findViewById(R.id.taskDescription);
                final EditText date = (EditText) mView.findViewById(R.id.date);
                final Switch priority = (Switch) mView.findViewById(R.id.priority);
                Button save = (Button) mView.findViewById(R.id.saveTask);

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();




                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        final String task = taskName.getText().toString();
                        final String description = taskDesctiption.getText().toString();
                        final String taskDate = date.getText().toString();

                        tasks.add(new DataSource(task, description, taskDate));
                        adapter.notifyDataSetChanged();
                        dialog.dismiss();

                    }
                });


            }
        });



        ListView listView =  findViewById(R.id.newView);
        listView.setAdapter(adapter);

    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
