package com.example.realestatemanagerp9.database.dao;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.ContentValues;
import android.content.Context;
import android.support.annotation.NonNull;

import org.jetbrains.annotations.NotNull;


@Database(entities = {AppartementDao.class}, version = 1, exportSchema = false)
public abstract class RealEstateManagerDatabase extends RoomDatabase{


    // --- SINGLETON ---
    private static volatile RealEstateManagerDatabase INSTANCE;

    public abstract AppartementDao AppartementDao();

    public static synchronized  RealEstateManagerDatabase getDbInstance(Context context){

        if(INSTANCE== null ){
            INSTANCE= Room.databaseBuilder(context.getApplicationContext(),
                    RealEstateManagerDatabase.class, "DB_NAME")
                    .allowMainThreadQueries()
                    //.addCallback(prepopulateDatabase())
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
                contentValues1.put("id", 1L);
                contentValues1.put("type", "Flat");
                contentValues1.put("city", "Manhattan");
                contentValues1.put("price", "$17,870,000");
                contentValues1.put("photos", "");
                contentValues1.put("description", "it's a flat in Manhattan");
                contentValues1.put("roomNumbers", "8");
                contentValues1.put("surace", "750sq m");
                contentValues1.put("bathroomNumbers", "2");
                contentValues1.put("bedroomNumbers", "4");
                contentValues1.put("Location", "740 Park Avenue" +
                        "apt6/7A" +
                        "New York " +
                        "Ny 102102" +
                        "United States");



                ContentValues contentValues2= new ContentValues();
                contentValues2.put("id",2L);
                contentValues2.put("name","Projet Lucidia");
                contentValues2.put("color",0xFFEADAD1);

                ContentValues contentValues3= new ContentValues();
                contentValues3.put("id",3L);
                contentValues3.put("name","Projet Circus");
                contentValues3.put("color",0xFFA3CED2);

//
            }
        };
    }

    @NonNull
    @NotNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @NotNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }
}
