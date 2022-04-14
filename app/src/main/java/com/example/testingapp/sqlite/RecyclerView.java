package com.example.testingapp.sqlite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.testingapp.R;

import java.util.ArrayList;

public class RecyclerView extends androidx.recyclerview.widget.RecyclerView.Adapter<androidx.recyclerview.widget.RecyclerView.ViewHolder> {

    private ArrayList<String> list = new ArrayList<>();

    @NonNull
    @Override
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    /* public RecyclerView() {
         list.clear();

         for (int i = 0 ; i< list.size(); i++){
             list.add()
         }
     }
 */

}
