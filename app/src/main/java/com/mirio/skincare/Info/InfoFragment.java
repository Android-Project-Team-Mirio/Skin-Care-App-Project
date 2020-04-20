package com.mirio.skincare.Info;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mirio.skincare.Info.InfoArticleActivity;
import com.mirio.skincare.MainActivity;
import com.mirio.skincare.R;

public class InfoFragment extends Fragment implements View.OnClickListener {
    private View context;
    private MainActivity main;

    public InfoFragment() {
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
        context = inflater.inflate(R.layout.fragment_info, container, false);

        context.findViewById(R.id.cv1).setOnClickListener(this);
        context.findViewById(R.id.cv2).setOnClickListener(this);
        context.findViewById(R.id.cv3).setOnClickListener(this);
        context.findViewById(R.id.cv4).setOnClickListener(this);

        return context;
    }

    @Override
    public void onClick(View v) {
            //         obtain myValue
            Intent intent = new Intent(main, InfoArticleActivity.class);
            // intent.putExtra("my_key", myValue);
            startActivity(intent);


    }
}
