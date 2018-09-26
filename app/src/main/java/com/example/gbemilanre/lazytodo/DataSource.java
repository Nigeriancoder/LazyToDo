package com.example.gbemilanre.lazytodo;

public class DataSource {

    private String mTaskName;
    private String mTaskDescription;
    private String mTaskDate;



    public DataSource(String taskname, String taskDescription, String taskDate){

        mTaskName = taskname;
        mTaskDescription = taskDescription;
        mTaskDate = taskDate;

    }


    public String getmTaskName(){

        return mTaskName;
    }

    public String getmTaskDescription(){

        return  mTaskDescription;
    }

    public String getmTaskDate (){

        return mTaskDate;
    }

}
