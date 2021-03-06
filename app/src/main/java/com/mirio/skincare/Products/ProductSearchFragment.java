package com.mirio.skincare.Products;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mirio.skincare.MainActivity;
import com.mirio.skincare.R;

import java.util.ArrayList;

import static android.view.View.FIND_VIEWS_WITH_CONTENT_DESCRIPTION;

public class ProductSearchFragment extends Fragment implements View.OnClickListener {

    private static Boolean isSkinCare;
    private View context;
    private Boolean open = false;
    private ArrayList<View> labels;
    private MainActivity main;
    public ProductSearchFragment() {
        // Required empty public constructor
    }

   public ProductSearchFragment(Boolean skinCare) {
        isSkinCare = skinCare;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        main = (MainActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = inflater.inflate(R.layout.fragment_product_search, container, false);

        TextView text = context.findViewById(R.id.headerText);
        text.setText(isSkinCare?"Search for skin care products" : "Search for makeup products");

        context.findViewById(R.id.search_btn).setOnClickListener(this);
        context.findViewById(R.id.filters_open).setOnClickListener(this);

        return context;
    }

    private void setFilterLabels(){
        labels = new ArrayList<>();
        String[] skinCareLabels = {"Ingredients", "Skin Type", "Skin Issues", "Product Type", "Brand"};
        String[] makeUpLabels = {"Brand", "Product Type", "Shade", "Price Range", "Rating"};
        context.findViewsWithText(labels, "label", FIND_VIEWS_WITH_CONTENT_DESCRIPTION);

            for(int i = 0; i < 5; i++){
                TextView temp = (TextView)labels.get(i);
                temp.setText(isSkinCare?skinCareLabels[i]:makeUpLabels[i]);
            }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.filters_open) filtersAnimation();
        else if(v.getId() == R.id.search_btn){
            main.getFragManager().beginTransaction().replace(R.id.frag_container, new SearchResultFragment(isSkinCare)).addToBackStack(null).commit();
        }
    }

    private void filtersAnimation(){
    //changes arrow direction
        TextView filter = context.findViewById(R.id.filters_open);
        filter.setCompoundDrawablesWithIntrinsicBounds(0, 0, open? R.drawable.ic_arrow_down : R.drawable.ic_arrow_up , 0);

        View container = context.findViewById(R.id.filterContainer);
        if(container.getVisibility() == View.VISIBLE) container.setVisibility(View.INVISIBLE);
        else container.setVisibility(View.VISIBLE);

        if(labels == null) setFilterLabels();

        open = !open;
    }
}
