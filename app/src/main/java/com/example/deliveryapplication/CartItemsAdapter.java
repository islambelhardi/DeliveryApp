package com.example.deliveryapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.deliveryapplication.data.Product;

import java.util.List;

public class CartItemsAdapter extends ArrayAdapter<Product> {
    private List<Product> cartsList;
    private LayoutInflater inflater;
    public CartItemsAdapter(@NonNull Context context, List<Product> cartsList) {
        super(context, 0, cartsList);
        this.cartsList = cartsList;
        this.inflater = LayoutInflater.from(context);
    }
    private View getCustomView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.product, parent, false);

        }
        Product currentProduct = cartsList.get(position);
        TextView productName = convertView.findViewById(R.id.productName);
        TextView productPrice = convertView.findViewById(R.id.priceValue);
        TextView productCount = convertView.findViewById(R.id.itemCount);
        TextView productTotal = convertView.findViewById(R.id.itemPriceTotal);
        ImageView flagImageView = convertView.findViewById(R.id.productImage);
        Button incrementButton = convertView.findViewById(R.id.incrementButton);
        Button decrementButton = convertView.findViewById(R.id.decrementButton);

        productName.setText(currentProduct.getName());
        productPrice.setText("Price"+ currentProduct.getPrice());
        productCount.setText(String.valueOf(currentProduct.getCount()));
        productTotal.setText(String.valueOf(currentProduct.getTotal())+" Dzd");
        flagImageView.setImageResource(currentProduct.iconResourceId);


        // Set click listeners for increment and decrement buttons
        incrementButton.setOnClickListener(v -> {
            // Increment the item count
            currentProduct.incrementCount();
            currentProduct.calculateTotal();
            notifyDataSetChanged(); // Notify adapter about the data change
        });

        decrementButton.setOnClickListener(v -> {
            // Decrement the item count
            currentProduct.decrementCount();
            currentProduct.calculateTotal();
            notifyDataSetChanged(); // Notify adapter about the data change
        });
        return convertView;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }
}
