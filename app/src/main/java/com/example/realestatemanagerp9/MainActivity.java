package com.example.realestatemanagerp9;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.realestatemanagerp9.adapter.LogementAdapter;
import com.example.realestatemanagerp9.database.dao.RealEstateManagerDatabase;
import com.example.realestatemanagerp9.fragment.AddLogementFragment;
import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static com.example.realestatemanagerp9.Utils.isNetworkConnected;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private TextView textViewMain;
    private TextView textViewQuantity;
    private RecyclerView recyclerView;
    private LogementAdapter adapter;
    private DrawerLayout drawer;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter= new LogementAdapter();
        drawer=findViewById(R.id.drawer_layout);
        recyclerView=findViewById(R.id.recyclerview);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);
        //will have to cheeck if the dblist is empty or not.
        loadTaskList();
        configureNavigationView();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


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
        DummyLogement logement = new DummyLogement();
        logement.id=1;
        logement.price=180000;
        logement.type="Flat";
        logement.city="Manathan";
        db.AppartementDao().insertAllData(logement);
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


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // 4 - Handle Navigation Item Click
        int id = item.getItemId();

        if (id == R.id.lunch_add_logement) {
            Fragment fragment = new AddLogementFragment();
            FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.main_view,fragment);
            transaction.commit();
        }
        this.drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void configureNavigationView(){
        this.navigationView = (NavigationView) findViewById(R.id.activity_main_nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


}







