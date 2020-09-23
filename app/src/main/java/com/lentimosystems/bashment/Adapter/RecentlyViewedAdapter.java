package com.lentimosystems.bashment.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.lentimosystems.bashment.Model.RecentlyViewed;
import com.lentimosystems.bashment.ProductDetails;
import com.lentimosystems.bashment.R;

import java.util.List;

public class RecentlyViewedAdapter extends RecyclerView.Adapter<RecentlyViewedAdapter.RecentlyViewedViewHolder> {
    Context mContext;
    List<RecentlyViewed> mRecentlyViewedList;

    public RecentlyViewedAdapter(Context context, List<RecentlyViewed> recentlyViewedList) {
        mContext = context;
        mRecentlyViewedList = recentlyViewedList;
    }

    @NonNull
    @Override
    public RecentlyViewedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recently_viewed_items,parent,false);
        return new RecentlyViewedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentlyViewedViewHolder holder, final int position) {
        holder.name.setText(mRecentlyViewedList.get(position).getName());
       //holder.desc.setText(mRecentlyViewedList.get(position).getDescription());
        holder.quantity.setText(mRecentlyViewedList.get(position).getQuantity());
        holder.price.setText(mRecentlyViewedList.get(position).getPrice());
        holder.unit.setText(mRecentlyViewedList.get(position).getUnit());
        holder.bg.setBackgroundResource(mRecentlyViewedList.get(position).getImageUrl());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ProductDetails.class);
                intent.putExtra("name",mRecentlyViewedList.get(position).getName());
                intent.putExtra("quantity",mRecentlyViewedList.get(position).getQuantity());
                intent.putExtra("price",mRecentlyViewedList.get(position).getPrice());
                intent.putExtra("unit",mRecentlyViewedList.get(position).getUnit());
                intent.putExtra("image",mRecentlyViewedList.get(position).getBgImageUrl());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mRecentlyViewedList.size();
    }

    public static class RecentlyViewedViewHolder extends RecyclerView.ViewHolder{
        TextView name,desc,quantity,price,unit;
        ConstraintLayout bg;

        public RecentlyViewedViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.txtProductName);
            //desc = itemView.findViewById(R.id.txtDesc);
            quantity = itemView.findViewById(R.id.txtQty);
            price = itemView.findViewById(R.id.txtPrice);
            unit = itemView.findViewById(R.id.txtUnit);
            //image = itemView.findViewById(R.id.imgRecent);
            bg = itemView.findViewById(R.id.recent_layout);
        }
    }
}
