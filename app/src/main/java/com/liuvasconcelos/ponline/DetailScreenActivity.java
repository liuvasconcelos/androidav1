package com.liuvasconcelos.ponline;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static java.lang.Integer.valueOf;

public class DetailScreenActivity extends AppCompatActivity {
    public static final String IMAGE = "IMAGE";
    public static final String NAME = "NAME";
    public static final String DESCRIPTION = "DESCRIPTION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.detailscreen);

        mainToolbarSetup();

        Bundle b = getIntent().getExtras();
        int imageValue = b.getInt(IMAGE);
        String nameValue = b.getString(NAME);
        String descriptionValue = b.getString(DESCRIPTION);

        ImageView image = (ImageView) findViewById(R.id.detail_item_image);
        image.setImageResource(imageValue);

        TextView name = (TextView) findViewById(R.id.detail_item_product_name);
        name.setText(nameValue);

        TextView description = (TextView) findViewById(R.id.detail_item_product_description);
        description.setText(descriptionValue);
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
}
