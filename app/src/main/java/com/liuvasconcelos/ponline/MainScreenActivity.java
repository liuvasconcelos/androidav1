package com.liuvasconcelos.ponline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.liuvasconcelos.ponline.model.ArrayProductAdapter;
import com.liuvasconcelos.ponline.model.Product;

import java.util.ArrayList;

public class MainScreenActivity extends AppCompatActivity {

    private ArrayList<Product> products = new ArrayList<>();
    String loremipsum = "Lorem ipsum dolor sit amet, convallis donec voluptatem, wisi velit.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.mainscreen);

        Button button =  (Button) findViewById(R.id.add_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToAddItem();
            }
        });


        mainToolbarSetup();

        DatabaseReference databaseProducts;
        databaseProducts = FirebaseDatabase.getInstance().getReference("Product");

        databaseProducts.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                products.clear();
                for(DataSnapshot productSnapshot : dataSnapshot.getChildren()) {


                    Product product = productSnapshot.getValue(Product.class);
                    products.add(product);


                }

                ArrayProductAdapter adapter = new ArrayProductAdapter(MainScreenActivity.this, products);

                ListView list = (ListView) findViewById(R.id.list_view);
                list.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }


    private void mainToolbarSetup(){

        Toolbar mainToolbar = (Toolbar) findViewById(R.id.main_screen_toolbar);

        if (mainToolbar != null){
            setSupportActionBar(mainToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            mainToolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_left));
            mainToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainScreenActivity.super.onBackPressed();
                }
            });
        }
    }

    private void goToAddItem() {
        Intent intent = new Intent(this, AddItemActivity.class);
        startActivity(intent);
    }


}
