package com.mirio.skincare.SkinCareRoutine;

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
public class CustomRoutineFragment extends Fragment implements View.OnClickListener{

    private View context;
    private MainActivity main;

    public CustomRoutineFragment() {
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
        context = inflater.inflate(R.layout.fragment_custom_routine, container, false);

        context.findViewById(R.id.exitButton).setOnClickListener(this);
        //context.findViewById(R.id.saveButton).setOnClickListener(this);

        return context;
    }

    public void onClick(View v) {
        if(v.getId() == R.id.exitButton) main.onBackPressed();
    //addToBackStack() -> adds the transaction to FragmentManager's stack so it can call it back when back button is pressed
        else if(v.getId() == R.id.saveButton) main.getFragManager().beginTransaction().replace(R.id.frag_container, new SavedRoutinesFragment()).addToBackStack(null).commit();
    }
}
