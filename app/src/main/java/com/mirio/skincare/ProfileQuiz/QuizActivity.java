package com.mirio.skincare.ProfileQuiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.mirio.skincare.R;

public class QuizActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Spinner arraySpinner1 = findViewById(R.id.answerSpinner1);
        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.spinner1));
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arraySpinner1.setAdapter(myAdapter1);

        Spinner arraySpinner2 = findViewById(R.id.answerSpinner2);
        myAdapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.spinner2));
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arraySpinner2.setAdapter(myAdapter1);
        //Git test ok

        Spinner arraySpinner3 = findViewById(R.id.answerSpinner3);
        myAdapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.spinner3));
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arraySpinner3.setAdapter(myAdapter1);

    }

    public void goToProfile(View view) {
        onBackPressed();
    }}
