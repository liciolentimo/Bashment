package com.lentimosystems.bashment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lentimosystems.bashment.Model.AllCategoriesModel;
import com.lentimosystems.bashment.R;

import java.util.List;

public class AllCategoriesAdapter extends RecyclerView.Adapter<AllCategoriesAdapter.AllCategoriesViewHolder> {
    Context mContext;
    List<AllCategoriesModel> mCategoryList;

    public AllCategoriesAdapter(Context context, List<AllCategoriesModel> categoryList) {
        mContext = context;
        mCategoryList = categoryList;
    }

    @NonNull
    @Override
    public AllCategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.all_category_items,parent,false);
        return new AllCategoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllCategoriesViewHolder holder, int position) {
        holder.categoryImage.setImageResource(mCategoryList.get(position).getImageUrl());
        holder.category.setText(mCategoryList.get(position).getCategory());
    }

    @Override
    public int getItemCount() {
        return mCategoryList.size();
    }

    public static class AllCategoriesViewHolder extends RecyclerView.ViewHolder{
        ImageView categoryImage;
        TextView category;

        public AllCategoriesViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryImage = itemView.findViewById(R.id.categoryImage2);
            category = itemView.findViewById(R.id.category2);
        }
    }
}
