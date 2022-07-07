package com.example.realestatemanagerp9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.realestatemanagerp9.adapter.LogementAdapter;
import com.example.realestatemanagerp9.database.dao.RealEstateManagerDatabase;

import java.util.ArrayList;
import java.util.List;

import static com.example.realestatemanagerp9.Utils.isNetworkConnected;

public class MainActivity extends AppCompatActivity {

    private TextView textViewMain;
    private TextView textViewQuantity;
    private RecyclerView recyclerView;
    private LogementAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter= new LogementAdapter();

        this.configureTextViewMain();
        this.configureTextViewQuantity();
        recyclerView=findViewById(R.id.recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);
        loadTaskList();


        Utils network = new Utils();
        network.isInternetAvailable(getApplicationContext());
        // Check network connection
        if (isNetworkConnected) {
            // Internet Connected
        } else {
            // Not Connected
        }
    }

    private void loadTaskList() {
        RealEstateManagerDatabase db = RealEstateManagerDatabase.getDbInstance(getApplicationContext());
        List<DummyLogement> logements = db.AppartementDao().getAllLogements();
        adapter.updateLogements(logements);
    }

        private void configureTextViewMain () {
            this.textViewMain.setTextSize(15);
            this.textViewMain.setText("Le premier bien immobilier enregistré vaut ");
        }

        private void configureTextViewQuantity () {
            int quantity = Utils.convertDollarToEuro(100);
            this.textViewQuantity.setTextSize(20);
            this.textViewQuantity.setText(Integer.toString(quantity));
        }

}







