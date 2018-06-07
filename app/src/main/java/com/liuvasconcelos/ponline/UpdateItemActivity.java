package com.liuvasconcelos.ponline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.liuvasconcelos.ponline.model.Product;

public class UpdateItemActivity extends AppCompatActivity {
    public static final String ID = "ID";
    public static final String NAME = "NAME";
    public static final String DESCRIPTION = "DESCRIPTION";
    public static final String PRICE = "PRICE";
    public static final String DATE = "DATE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.updateitem);

        Bundle b = getIntent().getExtras();
        final String nameValue = b.getString(NAME);
        final String descriptionValue = b.getString(DESCRIPTION);
        final String priceValue = b.getString(PRICE);
        final String dateValue = b.getString(DATE);
        final String idValue = b.getString(ID);

        Button button =  (Button) findViewById(R.id.update_item_button_on_register);

        final EditText nameInfo = (EditText) findViewById(R.id.update_enter_add_item_name);
        final EditText descriptionInfo = (EditText) findViewById(R.id.update_enter_add_item_description);
        final EditText priceInfo = (EditText) findViewById(R.id.update_enter_add_item_price);
        final EditText deliveryTimeInfo = (EditText) findViewById(R.id.update_enter_add_item_time);

        nameInfo.setText(nameValue);
        descriptionInfo.setText(descriptionValue);
        priceInfo.setText(priceValue);
        deliveryTimeInfo.setText(dateValue);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameInfo.getText().toString();
                String description = descriptionInfo.getText().toString();
                String price = priceInfo.getText().toString();
                String deliveryTime = deliveryTimeInfo.getText().toString();

                update(idValue, name, description, price, deliveryTime);
            }
        });

    }

    private void update(String idValue, String name, String description, String price, String deliveryTime) {
        DatabaseReference databaseProducts;
        databaseProducts = FirebaseDatabase.getInstance().getReference();
        Product product = new Product(idValue, name, description, price, deliveryTime);
        databaseProducts.child("Product").child(idValue).setValue(product);

        goToMainScreen();
    }
    private void goToMainScreen() {
        Intent intent = new Intent(this, MainScreenActivity.class);
        startActivity(intent);
    }

}
