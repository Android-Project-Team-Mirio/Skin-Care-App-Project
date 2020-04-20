package com.mirio.skincare.SkinCareRoutine;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mirio.skincare.MainActivity;
import com.mirio.skincare.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SavedRoutinesFragment extends Fragment implements View.OnClickListener {

    private View context;
    private MainActivity main;

    public SavedRoutinesFragment() {
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
        context = inflater.inflate(R.layout.fragment_saved_routines, container, false);

        context.findViewById(R.id.image1).setOnClickListener(this);
        context.findViewById(R.id.image2).setOnClickListener(this);

        return context;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.image1 || v.getId() == R.id.image2)
            main.getFragManager().beginTransaction().replace(R.id.frag_container, new RoutineItemFragment()).addToBackStack(null).commit();

    }
}
