package com.example.spaceapp.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(FavoriteEntity::class), version = 1, exportSchema = true)
abstract class SpaceDatabase : RoomDatabase() {
    abstract fun favDao(): FavoriteDAO

}