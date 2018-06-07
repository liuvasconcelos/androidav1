package com.liuvasconcelos.ponline;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.liuvasconcelos.ponline.model.Product;

public class AddItemActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.additem);

        Button button =  (Button) findViewById(R.id.add_item_button_on_register);

        final EditText nameInfo = (EditText) findViewById(R.id.enter_add_item_name);
        final EditText descriptionInfo = (EditText) findViewById(R.id.enter_add_item_description);
        final EditText priceInfo = (EditText) findViewById(R.id.enter_add_item_price);
        final EditText deliveryTimeInfo = (EditText) findViewById(R.id.enter_add_item_time);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameInfo.getText().toString();
                String description = descriptionInfo.getText().toString();
                String price = priceInfo.getText().toString();
                String deliveryTime = deliveryTimeInfo.getText().toString();
                register(name, description, price, deliveryTime);
            }
        });

    }

    private void register(String name, String description, String price, String deliveryTime) {
        DatabaseReference databaseProducts;
        databaseProducts = FirebaseDatabase.getInstance().getReference("Product");
        String id = databaseProducts.push().getKey();
        Product product = new Product(id, name, description, price, deliveryTime);
        databaseProducts.child(id).setValue(product);

        goToMainScreen();
    }
    private void goToMainScreen() {
        Intent intent = new Intent(this, MainScreenActivity.class);
        startActivity(intent);
    }

}
