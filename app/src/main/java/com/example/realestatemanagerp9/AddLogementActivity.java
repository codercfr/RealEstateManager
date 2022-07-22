package com.example.realestatemanagerp9;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.realestatemanagerp9.fragment.AddLogementFragment;

public class AddLogementActivity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_logement);

         Fragment fragment = new AddLogementFragment();
            FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.activity_add_logement,fragment);
            transaction.commit();


    }



}
