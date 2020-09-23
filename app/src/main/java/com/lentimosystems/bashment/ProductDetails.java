package com.lentimosystems.bashment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetails extends AppCompatActivity {
    String name, price, quantity, unit;
    int image;
    ImageView img,back;
    TextView product_name,product_price,product_unit,product_quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Intent intent = getIntent();

         name = intent.getStringExtra("name");
        price = intent.getStringExtra("price");
        quantity = intent.getStringExtra("quantity");
        unit = intent.getStringExtra("unit");
        image = intent.getIntExtra("image",R.drawable.absolut);

        img =  findViewById(R.id.product_image);
        product_name = findViewById(R.id.product_name);
        product_price = findViewById(R.id.product_price);
        product_unit = findViewById(R.id.product_unit);
        product_quantity = findViewById(R.id.product_qty);
        back = findViewById(R.id.imgBack2);

        product_name.setText(name);
        product_quantity.setText(quantity);
        product_unit.setText(unit);
        product_price.setText(price);
        img.setImageResource(image);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProductDetails.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}