package edu.vanier.skincareprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Quiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Spinner arrayspinner1 = (Spinner) findViewById(R.id.answerSpinner1);
        ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(Quiz.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.spinner1));
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayspinner1.setAdapter(myAdapter1);

        Spinner arrayspinner2 = (Spinner) findViewById(R.id.answerSpinner2);
        myAdapter1 = new ArrayAdapter<String>(Quiz.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.spinner2));
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayspinner2.setAdapter(myAdapter1);
        //Git test ok

        Spinner arrayspinner3 = (Spinner) findViewById(R.id.answerSpinner3);
        myAdapter1 = new ArrayAdapter<String>(Quiz.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.spinner3));
        myAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayspinner3.setAdapter(myAdapter1);

    }

    public void goToProfile(View view) {
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
    }
}
