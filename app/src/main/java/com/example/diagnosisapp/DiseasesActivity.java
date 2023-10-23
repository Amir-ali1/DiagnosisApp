package com.example.diagnosisapp;
import static com.example.diagnosisapp.MainActivity.list2;
import static com.example.diagnosisapp.MainActivity.list3;
import static com.example.diagnosisapp.MainActivity.list4;
import static com.example.diagnosisapp.MainActivity.list5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DiseasesActivity extends AppCompatActivity {

    TextView titleTv,desTv,formulaTv;
    Button link;
    String linkdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diseases);

        titleTv = findViewById(R.id.titleTv);
        desTv = findViewById(R.id.desTv);
        formulaTv = findViewById(R.id.forumulaTv);
        link = findViewById(R.id.linkBtn);

        titleTv.setText(list2.get(adapterClass.index).toString());
        desTv.setText(list3.get(adapterClass.index).toString());
        formulaTv.setText(list4.get(adapterClass.index).toString());
        link.setText("Visit the Website");

        linkdata = list5.get(adapterClass.index).toString();

        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(linkdata));
                startActivity(i);
            }
        });

    }
}