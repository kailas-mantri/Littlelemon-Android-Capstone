package com.example.littlelemon.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MenuDao {
    @Query("SELECT * FROM MenuItem")
    fun getAllMenuItems(): LiveData<List<MenuItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMenuItem(menuItem: MenuItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMenuItems(menuItems: List<MenuItem>)

    @Delete
    fun deleteMenuItem(menuItem: MenuItem)
}


