package com.example.deliveryapplication;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.deliveryapplication.data.Product;


import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.ExperimentalBadgeUtils;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CartActivity extends AppCompatActivity {


    private ListView listView;
    private TextView totalPriceView;
    private double total =0;

    @ExperimentalBadgeUtils
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        listView = findViewById(R.id.cartListView);
        List<Product> cartItems = new ArrayList<>();
        cartItems.add(new Product("amend", "desc", 10,R.mipmap.ic_launcher_round));
        cartItems.add(new Product("grape", "desc", 5,R.mipmap.ic_launcher_round));
        cartItems.add(new Product("orange", "desc", 23,R.mipmap.ic_launcher_round));
        cartItems.add(new Product("ananas", "desc", 2,R.mipmap.ic_launcher_round));
        cartItems.add(new Product("banana", "desc", 4,R.mipmap.ic_launcher_round));
        cartItems.add(new Product("amend", "desc", 100,R.mipmap.ic_launcher_round));
        cartItems.add(new Product("amend", "desc", 150,R.mipmap.ic_launcher_round));
        cartItems.add(new Product("amend", "desc", 90,R.mipmap.ic_launcher_round));
        CartItemsAdapter cartItemsAdapter = new CartItemsAdapter(this, cartItems);
        listView.setAdapter(cartItemsAdapter);
        // Inside your activity or fragment...
        FloatingActionButton fabButton = findViewById(R.id.fabButton);

        // Create a BadgeDrawable
        BadgeDrawable badgeDrawable = BadgeDrawable.create(this);
        badgeDrawable.setVisible(true);
        badgeDrawable.setNumber(3);
        badgeDrawable.setText("3");
        badgeDrawable.setBackgroundColor(ContextCompat.getColor(this, R.color.amber));
        BadgeUtils.attachBadgeDrawable(badgeDrawable, fabButton, null);
        // handle total
        totalPriceView = findViewById(R.id.totalPrice);

        cartItems.forEach(product -> {
            total +=total+product.getTotal();
        });
        // Format the string with the total amount
        String formattedTotal = getString(R.string.total, String.format(Locale.getDefault(), "%.2f", total));

        // Set the formatted string to the TextView
        totalPriceView.setText(formattedTotal);

    }
}