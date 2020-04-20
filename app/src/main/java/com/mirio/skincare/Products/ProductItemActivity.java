package com.mirio.skincare.Products;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mirio.skincare.R;

public class ProductItemActivity extends AppCompatActivity implements View.OnClickListener {

    public boolean isInWishlist = false;
    private Button wishlistBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_item);

        Intent intent = getIntent();

        Boolean isSkinCare = intent.getBooleanExtra("imgSrc", true);

        ImageView img = findViewById(R.id.imageView);
        img.setImageResource(isSkinCare?R.drawable.ic_skincare_products : R.drawable.ic_makeup_products);

        wishlistBtn = findViewById(R.id.saveWishlist);
        wishlistBtn.setOnClickListener(this);
//        filter.setCompoundDrawablesWithIntrinsicBounds(0, 0, open? R.drawable.ic_arrow_down : R.drawable.ic_arrow_up , 0);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.saveWishlist){
            isInWishlist = !isInWishlist;
            wishlistBtn.setCompoundDrawablesWithIntrinsicBounds(0, 0, isInWishlist? R.drawable.ic_wishlist : R.drawable.ic_wishlist_alt , 0);
        }

    }
}
