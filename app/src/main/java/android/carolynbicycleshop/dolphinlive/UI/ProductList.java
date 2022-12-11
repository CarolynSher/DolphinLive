package android.carolynbicycleshop.dolphinlive.UI;

import static android.carolynbicycleshop.dolphinlive.R.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.carolynbicycleshop.dolphinlive.Database.Repository;
import android.carolynbicycleshop.dolphinlive.R;
import android.carolynbicycleshop.dolphinlive.entities.Product;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class ProductList extends AppCompatActivity {
    private Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_product_list);
        RecyclerView recyclerView = findViewById(id.productrecyclerview);
        final ProductAdapter productAdapter = new ProductAdapter(this);
        recyclerView.setAdapter(productAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        repository = new Repository(getApplication());
        List<Product> allProducts = repository.getAllProducts();
        FloatingActionButton fab = findViewById(id.floatingActionButton);
        productAdapter.setProducts(allProducts);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductList.this, ProductDetails.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {

        super.onResume();
        List<Product> allProducts = repository.getAllProducts();
        RecyclerView recyclerView = findViewById(R.id.productrecyclerview);
        final ProductAdapter productAdapter = new ProductAdapter(this);
        recyclerView.setAdapter(productAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productAdapter.setProducts(allProducts);

        //Toast.makeText(ProductDetails.this,"refresh list",Toast.LENGTH_LONG).show();
    }
}