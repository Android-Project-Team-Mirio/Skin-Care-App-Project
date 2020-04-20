package com.mirio.skincare.Log;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mirio.skincare.R;

import java.util.ArrayList;

public class LogFragment extends Fragment {
    private ArrayList<LogItem> mLogList;

    private RecyclerView mRecyclerView;
    private LogAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private FloatingActionButton addBtn;
    private Button photoBtn;

    private View context;

    public LogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = inflater.inflate(R.layout.fragment_log, container, false);
        createLogList();
        buildRecyclerView();

        addBtn = context.findViewById(R.id.button2);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertItem();

            }
        });

        return context;
    }

    public void insertItem(){
        mLogList.add(new LogItem(R.drawable.ic_star_black, "New Log"));
        mAdapter.notifyItemInserted(mLogList.size());
    }


    public void createLogList(){
        mLogList = new ArrayList<>();
        mLogList.add(new LogItem(R.drawable.ic_favorite, "face"));
        mLogList.add(new LogItem(R.drawable.ic_filter, "eyes"));

    }

    public void buildRecyclerView(){
        mRecyclerView = context.findViewById(R.id.rv);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(context.getContext());
        mAdapter = new LogAdapter(mLogList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemCLickListener(new LogAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                Toast.makeText(context.getContext(), "testing 1 2 3", Toast.LENGTH_SHORT).show();
                System.out.println("hellohellohelloo");

            }
        });
    }


}
