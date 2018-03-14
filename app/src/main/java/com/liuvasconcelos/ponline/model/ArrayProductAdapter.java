package com.liuvasconcelos.ponline.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.liuvasconcelos.ponline.DetailScreenActivity;
import com.liuvasconcelos.ponline.LoginActivity;
import com.liuvasconcelos.ponline.MainScreenActivity;
import com.liuvasconcelos.ponline.R;

import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.startActivity;

public class ArrayProductAdapter extends ArrayAdapter {
    private ArrayList<Product> products = new ArrayList<>();
    private Context context;

    public ArrayProductAdapter (Context context, ArrayList<Product> products) {
        super(context, 0, products);
        this.products   = products;
        this.context    = context;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v;
        if (convertView!= null){
           v = convertView;
        } else {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.item_recycle_view, parent, false);
        }

        ImageView image = (ImageView) v.findViewById(R.id.list_view_item_image);
        image.setImageResource(products.get(position).getImage());

        TextView name = (TextView) v.findViewById(R.id.list_view_item_product_name);
        name.setText(products.get(position).getName());

        TextView description = (TextView) v.findViewById(R.id.list_view_item_product_description);
        description.setText(products.get(position).getDescription());

        LinearLayout linearLayout = (LinearLayout) v.findViewById(R.id.list_view_item_layout);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailScreenActivity.class);

                Bundle bundle = new Bundle();
                bundle.putInt(DetailScreenActivity.IMAGE, products.get(position).getImage());
                bundle.putString(DetailScreenActivity.NAME, products.get(position).getName());
                bundle.putString(DetailScreenActivity.DESCRIPTION, products.get(position).getDescription());
                intent.putExtras(bundle);

                context.startActivity(intent);
            }
        });

        return v;
    }

}
