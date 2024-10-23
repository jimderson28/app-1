package com.example.ex05_recyclerview01a_12131131;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter. ViewHolder>{
    static OnItemClickLiten listner;

    interface OnItemClickLiten{
        void OnItemClick(int position);
    }
    private ArrayList<MyListData> listdata;
    //private MyListData[] listData;
    //public MyListAdapter(MyListData[] listData){this.listData = listData;}
    //public void setListData(MyListData[] listData){this.listData = listData;}
    public MyListAdapter(ArrayList<MyListData> listdata) {
        this.listdata = listdata;
    }
    public MyListAdapter(ArrayList<MyListData> listdata,OnItemClickLiten listner) {
        this.listdata = listdata;
        this.listner= listner;
    }
    @NonNull
    @NotNull
    @Override
    public MyListAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, @SuppressLint("RecyclerView")
    int position) {
        final MyListData myListData = listdata.get(position);
        holder.textView.setText(myListData.getDescription());
        holder.imageView.setImageResource(myListData.getImgId());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "click on item: "
                        + myListData.getDescription(), Toast.LENGTH_LONG).show();
                listner.OnItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {return listdata.size();}

    public static class ViewHolder extends RecyclerView.ViewHolder
    implements View.OnClickListener{
        public ImageView imageView;
        public TextView textView;
        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
            this.textView = (TextView) itemView.findViewById(R.id.textView);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relativelayout);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if(position !=  RecyclerView.NO_POSITION){
                if(listner != null)listner.OnItemClick(position);
            }
        }
    }
}
