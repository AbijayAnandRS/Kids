package com.example.kids.adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kids.R;
import com.example.kids.activities.CategoryActivity;
import com.example.kids.data.ProductType;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductTypeRecylerAdapter extends RecyclerView.Adapter<ProductTypeRecylerAdapter.ViewHolder> {

    private List<ProductType> productTypeList;
    private Activity activity;


    public ProductTypeRecylerAdapter(Activity activity){
       this.productTypeList = new ArrayList<>();
       this.activity = activity;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.product_view, parent, false
        );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductType productType = productTypeList.get(position);
        if(productType!= null){
            Picasso.with(activity).load(productType.imgUrl).into(holder.img);
            System.out.println(productType.imgUrl);
            holder.tv1.setText(productType.type);
            holder.tv2.setText(productType.description);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.startActivity(new Intent(activity, CategoryActivity.class));
                }
            });
        }
    }

    public void addProductView(ProductType productType){
        this.productTypeList.add(productType);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
       return productTypeList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv1, tv2;
        ImageView img;

        public ViewHolder(View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.imagevwpic);
            tv1 = (TextView) view.findViewById(R.id.textView4);
            tv2 = (TextView) view.findViewById(R.id.textView5);
        }
   }
}
