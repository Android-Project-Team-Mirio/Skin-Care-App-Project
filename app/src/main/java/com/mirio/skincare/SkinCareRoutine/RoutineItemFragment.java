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
public class RoutineItemFragment extends Fragment implements View.OnClickListener {

    private View context;
    private MainActivity main;

    public RoutineItemFragment() {
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

        context = inflater.inflate(R.layout.fragment_routine_item, container, false);

        //sets event listener to edit floating button
        context.findViewById(R.id.editBtn).setOnClickListener(this);

        return context;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.editBtn) main.getFragManager().beginTransaction().replace(R.id.frag_container, new CustomRoutineFragment()).addToBackStack(null).commit();
    }
}
