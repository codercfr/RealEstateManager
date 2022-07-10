package com.example.realestatemanagerp9.database.dao;


import android.content.ContentValues;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.realestatemanagerp9.DummyLogement;

import org.jetbrains.annotations.NotNull;


@Database(entities = {DummyLogement.class}, version = 1, exportSchema = false)
public abstract class RealEstateManagerDatabase extends RoomDatabase {


    // --- SINGLETON ---
    private static volatile RealEstateManagerDatabase INSTANCE;

    public abstract AppartementDao AppartementDao();

    public static synchronized  RealEstateManagerDatabase getDbInstance(Context context){

        if(INSTANCE== null ){
            INSTANCE= Room.databaseBuilder(context.getApplicationContext(),
                    RealEstateManagerDatabase.class, "DB_NAME")
                    .allowMainThreadQueries()
                    .addCallback(prepopulateDatabase())
                    .build();
        }
        return  INSTANCE;
    }

    private static Callback prepopulateDatabase(){
        return new Callback() {

            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
                ContentValues contentValues1 = new ContentValues();
                contentValues1.put("id", 1);
                contentValues1.put("type", "Flat");
                contentValues1.put("city", "Manhattan");
                contentValues1.put("price", 17870000);
                contentValues1.put("photos", "");
                contentValues1.put("description", "it's a flat in Manhattan");
                contentValues1.put("roomNumbers", 8);
                contentValues1.put("surace", 750);
                contentValues1.put("bathroomNumbers", 2);
                contentValues1.put("bedroomNumbers", 4);
                contentValues1.put("Location", "740 Park Avenue" +
                        "apt6/7A" +
                        "New York " +
                        "Ny 102102" +
                        "United States");
//
            }
        };
    }
}
