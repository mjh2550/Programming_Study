package com.example.testingapp.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testingapp.R;

import java.util.ArrayList;

public class RecyclerManager extends RecyclerView.Adapter<RecyclerManager.ViewHolder> {

    private ArrayList<String> list = null;

    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv = itemView.findViewById(R.id.textView);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                
                @Override
                public boolean onLongClick(View v) {
                    Toast.makeText(itemView.getContext(),
                            "롱클릭", Toast.LENGTH_SHORT).show();
                    int position = getAdapterPosition();


                    return true;
                }
            });
        }
    }

    RecyclerManager (ArrayList<String> list){
        this.list = list;
    }


    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @NonNull
    @Override
    public RecyclerManager.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.view_items, parent, false);
        RecyclerManager.ViewHolder vh = new RecyclerManager.ViewHolder(view);

        return vh;
    }


    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String data = list.get(position);
        holder.tv.setText(data);
    }



    @Override
    public int getItemCount() {
        return list.size();
    }
}
