package com.example.kids.adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kids.R;
import com.example.kids.activities.ProductpageActivity;
import com.example.kids.data.ImageData;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private List<ImageData> imageList;
    private Activity activity;

    public ImageAdapter(Activity activity){
        this.imageList = new ArrayList();
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(activity).inflate(
                R.layout.single_image_view, viewGroup , false
        );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ImageData imageData = imageList.get(position);
        if(imageData!=null){
           holder.itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   activity.startActivity(new Intent(activity, ProductpageActivity.class));
               }
           });
        }
    }

    public void addImage(ImageData imageData){
        imageList.add(imageData);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return this.imageList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvHeader;
        ImageView ivImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            ivImage = itemView.findViewById(R.id.iv_image);
//            tvHeader = itemView.findViewById(R.id.tv_name);
        }
    }
}
