package com.liuvasconcelos.ponline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static java.lang.Integer.valueOf;

public class DetailScreenActivity extends AppCompatActivity {

    public static final String ID = "ID";
    public static final String NAME = "NAME";
    public static final String DESCRIPTION = "DESCRIPTION";
    public static final String PRICE = "PRICE";
    public static final String DATE = "DATE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.detailscreen);

        mainToolbarSetup();

        Bundle b = getIntent().getExtras();
        final String nameValue = b.getString(NAME);
        final String descriptionValue = b.getString(DESCRIPTION);
        final String priceValue = b.getString(PRICE);
        final String dateValue = b.getString(DATE);
        final String idValue = b.getString(ID);

        TextView name = (TextView) findViewById(R.id.detail_item_product_name);
        name.setText(nameValue);

        final TextView description = (TextView) findViewById(R.id.detail_item_product_description);
        description.setText(descriptionValue);

        final TextView price = (TextView) findViewById(R.id.detail_item_product_real_price);
        price.setText(priceValue);

        TextView date = (TextView) findViewById(R.id.detail_item_product_real_delivery_date);
        date.setText(dateValue);

        Button button =  (Button) findViewById(R.id.delete_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference databaseProducts;
                databaseProducts = FirebaseDatabase.getInstance().getReference("Product");
                databaseProducts.child(idValue).removeValue();
                goToMainScreen();
            }
        });

        Button updateButton =  (Button) findViewById(R.id.update_button);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUpdateScreen(idValue, nameValue, descriptionValue, priceValue, dateValue);
            }
        });
    }

    private void mainToolbarSetup(){

        Toolbar mainToolbar = (Toolbar) findViewById(R.id.detail_screen_toolbar);

        if (mainToolbar != null){
            setSupportActionBar(mainToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            mainToolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_left));
            mainToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DetailScreenActivity.super.onBackPressed();
                }
            });
        }
    }

    private void goToMainScreen() {
        Intent intent = new Intent(this, MainScreenActivity.class);
        startActivity(intent);
    }


    private void goToUpdateScreen(String idValue, String nameValue, String descriptionValue, String priceValue, String dateValue) {
        Intent intent = new Intent(this, UpdateItemActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString(DetailScreenActivity.ID, idValue);
        bundle.putString(DetailScreenActivity.NAME, nameValue);
        bundle.putString(DetailScreenActivity.DESCRIPTION, descriptionValue);
        bundle.putString(DetailScreenActivity.PRICE, priceValue);
        bundle.putString(DetailScreenActivity.DATE, dateValue);
        intent.putExtras(bundle);

        startActivity(intent);
    }
}
