package com.example.realestatemanagerp9;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.realestatemanagerp9.adapter.LogementAdapter;
import com.example.realestatemanagerp9.database.dao.RealEstateManagerDatabase;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

import static com.example.realestatemanagerp9.Utils.isNetworkConnected;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private TextView textViewMain;
    private TextView textViewQuantity;
    private RecyclerView recyclerView;
    private LogementAdapter adapter;
    private DrawerLayout drawer;
    private NavigationView navigationView;

    @RequiresApi(api = Build.VERSION_CODES.M)
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

        //NetWork check

        //will have to cheeck if the dblist is empty or not.


        loadTaskList();
        configureNavigationView();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        isNetworkAvailable(getApplication());

        /*Utils network = new Utils();
        network.isInternetAvailable(getApplicationContext());
        // Check network connection
        if (isNetworkConnected) {
            // Internet Connected
        } else {
            // Not Connected
        }*/
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




    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.lunch_add_logement) {
            startActivity(new Intent(MainActivity.this,AddLogementActivity.class));
        }
        this.drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void configureNavigationView(){
        this.navigationView = (NavigationView) findViewById(R.id.activity_main_nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private Boolean isNetworkAvailable(Application application) {
        ConnectivityManager connectivityManager = (ConnectivityManager) application.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Network nw = connectivityManager.getActiveNetwork();
            if (nw == null) return false;
            NetworkCapabilities actNw = connectivityManager.getNetworkCapabilities(nw);
            return actNw != null && (actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) || actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) || actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) || actNw.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH));
        } else {
            NetworkInfo nwInfo = connectivityManager.getActiveNetworkInfo();
            return nwInfo != null && nwInfo.isConnected();
        }
    }



}







