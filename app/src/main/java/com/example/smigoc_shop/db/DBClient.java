package com.example.smigoc_shop.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(version = 1, entities = {Category.class, Item.class} )
public abstract class DBClient extends RoomDatabase{
    public abstract CategoryDao categoryDao();
    public abstract ItemDao itemDao();
}
