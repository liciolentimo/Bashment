package com.lentimosystems.bashment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.lentimosystems.bashment.Adapter.CategoryAdapter;
import com.lentimosystems.bashment.Adapter.DiscountedProductAdapter;
import com.lentimosystems.bashment.Adapter.RecentlyViewedAdapter;
import com.lentimosystems.bashment.Model.Category;
import com.lentimosystems.bashment.Model.DiscountedProducts;
import com.lentimosystems.bashment.Model.RecentlyViewed;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView discountRecycler, categoryRecycler,recentlyViewedRecycler;
    DiscountedProductAdapter mDiscountedProductAdapter;
    List<DiscountedProducts> mDiscountedProductsList;

    CategoryAdapter mCategoryAdapter;
    List<Category> mCategoryList;

    RecentlyViewedAdapter mRecentlyViewedAdapter;
    List<RecentlyViewed> mRecentlyViewedList;

    ImageView allCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        discountRecycler = findViewById(R.id.discountedRecycler);
        categoryRecycler = findViewById(R.id.recyclerCategory);
        allCategories = findViewById(R.id.imgCategories);
        recentlyViewedRecycler = findViewById(R.id.recyclerRecent);

        allCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AllCategories.class);
                startActivity(intent);
            }
        });

        mDiscountedProductsList = new ArrayList<>();
        mDiscountedProductsList.add(new DiscountedProducts(1,R.drawable.jb));
        mDiscountedProductsList.add(new DiscountedProducts(2,R.drawable.jd));
        mDiscountedProductsList.add(new DiscountedProducts(3,R.drawable.absolut));
        mDiscountedProductsList.add(new DiscountedProducts(4,R.drawable.skyy));
        mDiscountedProductsList.add(new DiscountedProducts(5,R.drawable.smirf));
        mDiscountedProductsList.add(new DiscountedProducts(6,R.drawable.midleton));

        mCategoryList = new ArrayList<>();
        mCategoryList.add(new Category(1,R.drawable.jd,"Whisky"));
        mCategoryList.add(new Category(2,R.drawable.absolut,"Vodka"));
        mCategoryList.add(new Category(3,R.drawable.brandy,"Brandy"));
        mCategoryList.add(new Category(4,R.drawable.tusker,"Beer"));
        mCategoryList.add(new Category(5,R.drawable.wine,"Wine"));
        mCategoryList.add(new Category(6,R.drawable.rum,"Rum"));

        mRecentlyViewedList = new ArrayList<>();
        mRecentlyViewedList.add(new RecentlyViewed("Johnnie Walker",
                "KES 4000","5","750ML",R.drawable.jd,R.drawable.jd));
        mRecentlyViewedList.add(new RecentlyViewed("Absolut Vodka",
                "KES 2000","2","1L",R.drawable.absolut,R.drawable.absolut));
        mRecentlyViewedList.add(new RecentlyViewed("Captain Morgan",
                "KES 1000","4","750ML",R.drawable.rum,R.drawable.rum));
        mRecentlyViewedList.add(new RecentlyViewed("Tusker",
                "KES 150","6","500ML",R.drawable.tusker,R.drawable.tusker));

        setDiscountedRecycler(mDiscountedProductsList);
        setCategoryRecycler(mCategoryList);
        setRecentRecycler(mRecentlyViewedList);
    }

    private void setDiscountedRecycler(List<DiscountedProducts> dataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        discountRecycler.setLayoutManager(layoutManager);
        mDiscountedProductAdapter = new DiscountedProductAdapter(this,dataList);
        discountRecycler.setAdapter(mDiscountedProductAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        categoryRecycler.setLayoutManager(layoutManager);
        mCategoryAdapter = new CategoryAdapter(this,categoryDataList);
        categoryRecycler.setAdapter(mCategoryAdapter);
    }

    private void setRecentRecycler(List<RecentlyViewed> recentDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recentlyViewedRecycler.setLayoutManager(layoutManager);
        mRecentlyViewedAdapter = new RecentlyViewedAdapter(this,recentDataList);
        recentlyViewedRecycler.setAdapter(mRecentlyViewedAdapter);
    }

}