package com.liuvasconcelos.ponline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        products.add(new Product(R.drawable.picanha, "Picanha", loremipsum));
        products.add(new Product(R.drawable.aves1, "Coxinha da asa", loremipsum));
        products.add(new Product(R.drawable.coracao, "Coração", loremipsum));
        products.add(new Product(R.drawable.costelapremium, "Costela", loremipsum));

        ArrayProductAdapter adapter = new ArrayProductAdapter(this, products);

        ListView list = (ListView) findViewById(R.id.list_view);
        list.setAdapter(adapter);

    }
    public void goToDetail() {
        Intent intent = new Intent(this, DetailScreenActivity.class);
        startActivity(intent);
    }

}
