package com.example.spaceapp.room
import androidx.room.Dao
import androidx.room.Query

@Dao
interface FavoriteDAO {
    @Query("SELECT * FROM favorites")
    fun getAll(): List<FavoriteEntity>

}