package com.lentimosystems.bashment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lentimosystems.bashment.Model.Category;
import com.lentimosystems.bashment.R;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    Context mContext;
    List<Category> mCategoryList;

    public CategoryAdapter(Context context, List<Category> categoryList) {
        mContext = context;
        mCategoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.category_item,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.categoryImage.setImageResource(mCategoryList.get(position).getImageUrl());
        holder.category.setText(mCategoryList.get(position).getCategory());
    }

    @Override
    public int getItemCount() {
        return mCategoryList.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder{
        ImageView categoryImage;
        TextView category;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryImage = itemView.findViewById(R.id.categoryImage);
            category = itemView.findViewById(R.id.category);
        }
    }
}
