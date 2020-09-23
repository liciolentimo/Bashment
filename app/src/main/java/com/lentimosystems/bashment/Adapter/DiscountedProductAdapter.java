package com.lentimosystems.bashment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lentimosystems.bashment.Model.DiscountedProducts;
import com.lentimosystems.bashment.R;

import java.util.List;

public class DiscountedProductAdapter extends RecyclerView.Adapter<DiscountedProductAdapter.DiscountedProductViewHolder> {
    Context mContext;
    List<DiscountedProducts> mDiscountedProductsList;

    public DiscountedProductAdapter(Context context, List<DiscountedProducts> discountedProductsList) {
        mContext = context;
        mDiscountedProductsList = discountedProductsList;
    }

    @NonNull
    @Override
    public DiscountedProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.discounted_items_row,parent,false);
        return new DiscountedProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscountedProductViewHolder holder, int position) {
        holder.discountImg.setImageResource(mDiscountedProductsList.get(position).getImageUrl());
    }

    @Override
    public int getItemCount() {
        return mDiscountedProductsList.size();

    }

    public static class DiscountedProductViewHolder extends RecyclerView.ViewHolder{
        ImageView discountImg;

        public DiscountedProductViewHolder(@NonNull View itemView) {
            super(itemView);
            discountImg = itemView.findViewById(R.id.discountImg);
        }
    }
}
