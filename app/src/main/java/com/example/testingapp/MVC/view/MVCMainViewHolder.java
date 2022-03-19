package com.example.testingapp.MVC.view;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testingapp.MVC.model.Person;
import com.example.testingapp.R;

public class MVCMainViewHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private Button delete;
    private HolderClickListener listener;
    private Person person;


    public MVCMainViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        delete = itemView.findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener!=null){//변화있으면
                    listener.onDeleteClick(person);
                }
            }
        });
    }

    public void setPerson(Person person){
        this.person = person;
        name.setText(person.getName());
    }

    public interface HolderClickListener{
        void onDeleteClick(Person person);
    }

    public void setOnHolderClickListener(HolderClickListener holderClickListener){
        this.listener = holderClickListener;
    }
}
