package com.mirio.skincare.Products;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mirio.skincare.MainActivity;
import com.mirio.skincare.Products.ProductItemActivity;
import com.mirio.skincare.R;


public class WishlistFragment extends Fragment implements View.OnClickListener {

    private View context;
    private MainActivity main;

    public WishlistFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        main = (MainActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = inflater.inflate(R.layout.fragment_wishlist, container, false);

        context.findViewById(R.id.prod).setOnClickListener(this);

        return context;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.prod){
            Intent intent = new Intent(main, ProductItemActivity.class);

            startActivity(intent);
        }
    }
}
