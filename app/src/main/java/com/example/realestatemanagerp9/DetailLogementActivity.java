package com.example.realestatemanagerp9;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailLogementActivity extends AppCompatActivity {


    private DummyLogement dummyLogement;
    private TextView description;
    private String logementDescription;
    private String logementType;
    private String logementCity;
    private String logementSurface;
    private String logementLocation;
    private int logementPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_logement);
        description=findViewById(R.id.description_logement);
        receiveData();
        description.setText(logementDescription);

    }

    private void receiveData() {
        Intent i = getIntent();
        //add all the getString or int i need
       logementDescription= i.getStringExtra("DESCRIPTION");
        logementType = i.getStringExtra("TYPE");
        logementCity = i.getStringExtra("CITY");
        //logementPrice = i.getIntExtra("PRICE");
        logementSurface = i.getStringExtra("SURFACE");
        logementLocation = i.getStringExtra("LOCATION");
    }
}
