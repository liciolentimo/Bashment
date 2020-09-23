package com.lentimosystems.bashment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.lentimosystems.bashment.Adapter.AllCategoriesAdapter;
import com.lentimosystems.bashment.Model.AllCategoriesModel;

import java.util.ArrayList;
import java.util.List;

public class AllCategories extends AppCompatActivity {
    RecyclerView allCategoriesRecycler;
    AllCategoriesAdapter mAllCategoriesAdapter;
    List<AllCategoriesModel> mAllCategoriesModelList;

    ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_categories);

        allCategoriesRecycler = findViewById(R.id.recyclerAllCategories);
        imgBack = findViewById(R.id.imgBack2);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AllCategories.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mAllCategoriesModelList = new ArrayList<>();
        mAllCategoriesModelList.add(new AllCategoriesModel(1,R.drawable.jd,"Whisky"));
        mAllCategoriesModelList.add(new AllCategoriesModel(2,R.drawable.absolut,"Vodka"));
        mAllCategoriesModelList.add(new AllCategoriesModel(3,R.drawable.brandy,"Brandy"));
        mAllCategoriesModelList.add(new AllCategoriesModel(4,R.drawable.tusker,"Beer"));
        mAllCategoriesModelList.add(new AllCategoriesModel(5,R.drawable.wine,"Wine"));
        mAllCategoriesModelList.add(new AllCategoriesModel(6,R.drawable.rum,"Rum"));

        setCategoryRecycler(mAllCategoriesModelList);
    }

    private void setCategoryRecycler(List<AllCategoriesModel> allcategoryDataList) {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,3);
        allCategoriesRecycler.setLayoutManager(layoutManager);
        allCategoriesRecycler.addItemDecoration(new SpaceGrid(3, 10, true));
        mAllCategoriesAdapter = new AllCategoriesAdapter(this,allcategoryDataList);
        allCategoriesRecycler.setAdapter(mAllCategoriesAdapter);
    }

    private class SpaceGrid extends RecyclerView.ItemDecoration{
        private int mSpanCount;
        private int mSpacing;
        private boolean mIncludeEdge;
        private SpaceGrid(int spanCount, int spacing, boolean includeEdge){
            mSpanCount = spanCount;
            mSpacing = spacing;
            mIncludeEdge = includeEdge;
        }
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state){
            int position = parent.getChildAdapterPosition(view);
            int column = position % mSpanCount;
            if(mIncludeEdge){
                outRect.left = mSpacing - column * mSpacing / mSpanCount;
                outRect.right =(column + 1) * mSpacing / mSpanCount;
                if(position < mSpanCount){
                    outRect.top = mSpacing;
                }
                outRect.bottom = mSpacing;
            }else{
                outRect.left = column * mSpacing / mSpanCount;
                outRect.right = mSpacing - (column + 1) * mSpacing / mSpanCount;
                if(position < mSpanCount){
                    outRect.top = mSpacing;
                }
            }
        }
    }

}