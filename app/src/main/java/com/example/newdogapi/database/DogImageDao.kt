package com.example.newdogapi.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface DogImageDao {

    @Query("SELECT * FROM DogImages" )
    fun getAllDogImages() : Flow<List<DogImageEntity>>

    @Query("SELECT * FROM DogImages ORDER BY id DESC LIMIT -1" )
    fun getRecentlyAddDog() : DogImageEntity

    @Query("DELETE FROM DogImages where id=(select max(id)-1 from DogImages)")
    suspend fun deleteDog()

    @Insert
    suspend fun addDogImage(dogImageEntity: DogImageEntity)

}