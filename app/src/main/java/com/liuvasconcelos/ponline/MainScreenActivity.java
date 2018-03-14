package com.liuvasconcelos.ponline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

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
        String filetSteak = getString(R.string.filetsteak);
        String wingPaddle = getString(R.string.wingpaddle);
        String chickenHeart = getString(R.string.chickenheart);
        String rib = getString(R.string.rib);

        products.add(new Product(R.drawable.picanha, filetSteak, loremipsum));
        products.add(new Product(R.drawable.aves1, wingPaddle, loremipsum));
        products.add(new Product(R.drawable.coracao, chickenHeart, loremipsum));
        products.add(new Product(R.drawable.costelapremium, rib, loremipsum));

        ArrayProductAdapter adapter = new ArrayProductAdapter(this, products);

        ListView list = (ListView) findViewById(R.id.list_view);
        list.setAdapter(adapter);
        mainToolbarSetup();


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

}
