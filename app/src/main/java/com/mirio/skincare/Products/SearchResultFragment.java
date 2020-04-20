package com.mirio.skincare.Products;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mirio.skincare.MainActivity;
import com.mirio.skincare.Products.ProductItemActivity;
import com.mirio.skincare.R;


public class SearchResultFragment extends Fragment implements View.OnClickListener {

    private Boolean isSkinCare;
    private View context;
    private MainActivity main;

    public SearchResultFragment() {
        // Required empty public constructor
    }

    public SearchResultFragment(Boolean prod){
        isSkinCare = prod;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        main = (MainActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = inflater.inflate(R.layout.fragment_search_result, container, false);

        ImageView img = context.findViewById(R.id.img);
        img.setImageResource(isSkinCare?R.drawable.ic_skincare_products : R.drawable.ic_makeup_products);

        context.findViewById(R.id.prod1).setOnClickListener(this);

        return context;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.prod1) {
            Intent intent = new Intent(main, ProductItemActivity.class);
            intent.putExtra("imgSrc", isSkinCare);
            startActivity(intent);
        }
    }
}
