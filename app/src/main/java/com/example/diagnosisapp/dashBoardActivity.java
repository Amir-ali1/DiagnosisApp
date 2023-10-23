package com.example.diagnosisapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class dashBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
    }

    public void btn_symptom(View view) {
       Intent i = new Intent(getApplicationContext(),MainActivity.class);
       startActivity(i);
    }

    public void btn_self(View view) {
        Intent i = new Intent(getApplicationContext(),contactUsActivity.class);
        startActivity(i);

    }

    public void btn_about(View view) {
        Intent i = new Intent(getApplicationContext(),abousUsActivity.class);
        startActivity(i);

    }

    public void btn_modifyList(View view) {
        Intent i = new Intent(getApplicationContext(),MainActivity2.class);
        startActivity(i);

    }
}