package com.example.realestatemanagerp9.database.dao;



import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.realestatemanagerp9.DummyLogement;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;


@Dao
public interface AppartementDao {


    @Query("SELECT * FROM DummyLogement")
    List<DummyLogement> getAllLogements();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllData(DummyLogement task);

    @Update(onConflict = REPLACE)
    void updateItem(DummyLogement item);

    @Delete
    void deleteLogement(DummyLogement itemId);
}
