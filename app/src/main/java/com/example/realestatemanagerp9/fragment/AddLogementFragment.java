package com.example.realestatemanagerp9.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.realestatemanagerp9.DummyLogement;
import com.example.realestatemanagerp9.MainActivity;
import com.example.realestatemanagerp9.R;
import com.example.realestatemanagerp9.database.dao.RealEstateManagerDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class AddLogementFragment  extends Fragment {

    private EditText logementType;
    private EditText logementCity;
    private EditText logementPrice;
    private EditText logementDescription;
    private EditText logementRoomNumber;
    private EditText logementSurface;
    private EditText logementBathRoomNumber;
    private EditText logementBedRoomNumber;
    private EditText logementLocation;
    private Button addLogement;


    @SuppressLint("VisibleForTests")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_add_logement, container, false);
        logementType=rootView.findViewById(R.id.txt_logement_type);
        logementCity=rootView.findViewById(R.id.txt_logement_city);
        logementPrice=rootView.findViewById(R.id.txt_logement_price);
        logementDescription=rootView.findViewById(R.id.txt_logement_description);
        logementRoomNumber=rootView.findViewById(R.id.txt_logement_roomnubers);
        logementSurface=rootView.findViewById(R.id.txt_logement_surface);
        logementBathRoomNumber=rootView.findViewById(R.id.txt_logement_bathroomNumbers);
        logementBedRoomNumber=rootView.findViewById(R.id.txt_logement_bedroomNumbers);
        logementLocation=rootView.findViewById(R.id.txt_logement_location);
        addLogement=rootView.findViewById(R.id.btn_add_logement);
        return rootView;

    }

    @Override
    public void onViewCreated( View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getAllText();
    }

    private void getAllText(){
        RealEstateManagerDatabase db = RealEstateManagerDatabase.getDbInstance(getActivity());
        DummyLogement logement = new DummyLogement();

        addLogement.setOnClickListener(view -> {
            logement.setType(String.valueOf(logementType.getText()));
            logement.setCity(String.valueOf(logementCity.getText()));
            logement.setPrice(logementRoomNumber.getInputType());
            logement.setDescription(logementDescription.getText().toString());
            logement.setSurace(logementSurface.getInputType());
            logement.setRoomNumbers(logementRoomNumber.getInputType());
            logement.setBathroomNumbers(logementBathRoomNumber.getInputType());
            logement.setBedroomNumbers(logementBedRoomNumber.getInputType());
            logement.setLocation(logementLocation.getText().toString());
            db.AppartementDao().insertAllData(logement);
            db.AppartementDao().updateItem(logement);
            startActivity(new Intent(getActivity(), MainActivity.class));
        });

    }



}
