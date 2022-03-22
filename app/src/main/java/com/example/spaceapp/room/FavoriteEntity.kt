package com.example.spaceapp.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "favorites")
data class FavoriteEntity(
        @PrimaryKey var id: String,
        @ColumnInfo(name = "images") val images: String?,
        @ColumnInfo(name = "slug") val slug: String?
)