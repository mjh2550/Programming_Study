package com.example.testingapp.MVC.controller;

import static android.os.Build.VERSION_CODES.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testingapp.MVC.model.Person;
import com.example.testingapp.MVC.view.MVCMainViewHolder;
import com.example.testingapp.R;

import java.util.ArrayList;
import java.util.List;

public class MVCMainAdapter extends RecyclerView.Adapter<MVCMainViewHolder> {
    private List<Person> items = new ArrayList<>();
    private MVCMainViewHolder.HolderClickListener holderClickListener;

    public MVCMainAdapter(MVCMainViewHolder.HolderClickListener holderClickListener){
        this.holderClickListener = holderClickListener;
    }

    @NonNull
    @Override
    public MVCMainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(com.example.testingapp.R.layout.view_main, parent, false);
        return new MVCMainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MVCMainViewHolder holder, int position) {
        holder.setPerson(items.get(position));
        holder.setOnHolderClickListener(holderClickListener);
    }

    public void setItems(List<Person> items){
        this.items = items;

    }

    public List<Person> getItems(){
        return items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
