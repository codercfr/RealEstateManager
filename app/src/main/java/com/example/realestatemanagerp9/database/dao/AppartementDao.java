package com.example.realestatemanagerp9.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.realestatemanagerp9.DummyLogement;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface AppartementDao {


    @Query("SELECT * FROM DummyLogement")
    List<DummyLogement> getAllLogements();

    @Insert
    void insertAllData(DummyLogement task);

    @Update(onConflict = REPLACE)
    void updateItem(DummyLogement item);

    @Delete
    void deleteLogement(DummyLogement itemId);
}
