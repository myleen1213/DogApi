package com.example.newdogapi.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo

import androidx.room.Entity
import androidx.room.PrimaryKey

//crete entity / row that exists in table
@Entity(tableName = "DogImages")
data class DogImageEntity (
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "image_url")
    val imageUrl: String){
}




