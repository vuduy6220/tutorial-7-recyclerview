package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.GridLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ProductAdapter.IOnClickItem {
    List<Product> listProduct = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        ProductAdapter adapter = new ProductAdapter(this, listProduct, this);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);

        RecyclerView rvProduct = (RecyclerView) findViewById(R.id.rvProduct);
        rvProduct.setLayoutManager(layoutManager);
        rvProduct.setAdapter(adapter);
    }

    private void initData() {
        listProduct.add(new Product("Model 1", "Most Expensive", "50000$", R.drawable.model1));
        listProduct.add(new Product("Model 2", "Normal Price", "3000$", R.drawable.model2));
        listProduct.add(new Product("Model 3", "Normal Price", "2500$", R.drawable.model3));
        listProduct.add(new Product("Model 4", "Cheapest", "500$", R.drawable.model4));
    }


    @Override
    public void onClickItem(int position) {
        Product product = listProduct.get(position);
        Toast.makeText(this, product.getTitle(), Toast.LENGTH_SHORT).show();
    }
}