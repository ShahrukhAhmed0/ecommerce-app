package com.example.karad1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter2 extends RecyclerView.Adapter<MainAdapter2.ViewHolder> {
    ArrayList<MainModel3> mainModels;
    Context context;
    public MainAdapter2(Context context,ArrayList<MainModel3> mainModels)
    {
        this.context=context;
        this.mainModels=mainModels;
    }
    @NonNull
    @Override
    public MainAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MainAdapter2.ViewHolder holder, int position) {
        final MainModel3 temp= mainModels.get(position);
        holder.imageView.setImageResource(mainModels.get(position).getLangLogo1());
        holder.textView.setText(mainModels.get(position).getLangName1());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, objectDisplay.class);
                intent.putExtra("image name",temp.langLogo1);
                intent.putExtra("Shirt no",temp.langName1);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivities(new Intent[]{intent});
            }
        });
    }
    @Override
    public int getItemCount() {
        return mainModels.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            imageView=itemView.findViewById(R.id.image_view);
            textView=itemView.findViewById(R.id.text_view);
        }
    }
}
