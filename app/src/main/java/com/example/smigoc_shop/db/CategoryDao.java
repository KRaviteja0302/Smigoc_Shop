package com.example.smigoc_shop.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Observable;

@Dao
public interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long saveCategory(Category category);

    @Query("Select * from Category where parentId=0")
    Observable<List<Category>> getCategoryList();

    @Query("Select * from Category")
    Observable<List<Category>> getLiveCategoryList();
}
