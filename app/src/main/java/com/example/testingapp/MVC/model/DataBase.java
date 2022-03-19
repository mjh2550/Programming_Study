package com.example.testingapp.MVC.model;

import java.util.ArrayList;

public class DataBase {
    private static DataBase instance;
    private ArrayList<Person> personArrayList = new ArrayList<>();
    private DatabaseListener databaseListener;

    private DataBase(){
        for (int index=0; index<100; index++){
            personArrayList.add(new Person(index, String.format("JH%d",index)));
        }
    }

    public static DataBase getInstance(){
        if(instance==null){
            instance = new DataBase();
        }
        return instance;
    }

    public void add(Person person){
        personArrayList.add(0,person);
        notifyChanged();
    }

    public void remove(Person person){
        personArrayList.remove(person);
        notifyChanged();

    }

    public interface DatabaseListener{
        void onChanged();
    }

    public void setOnDatabaseListener(DatabaseListener databaseListener){
        this.databaseListener = databaseListener;
    }

    public void notifyChanged(){
        if(databaseListener!=null){
            databaseListener.onChanged();
        }
    }

    public ArrayList<Person> getPersonArrayList(){
        return personArrayList;
    }


}
