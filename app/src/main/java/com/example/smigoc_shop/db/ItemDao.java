package com.example.smigoc_shop.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Observable;

@Dao
public interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
   Long saveItem(Item item);

    @Query("Select * from Item")
    Observable<List<Item>> getItemList();

    @Query("Select * from Item where catId=:cid")
    Observable<List<Item>> getCategoryItemList(Integer cid);

}
