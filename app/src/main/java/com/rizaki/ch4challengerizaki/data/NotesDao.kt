package com.rizaki.ch4challengerizaki.data


import androidx.lifecycle.LiveData
import androidx.room.*
import com.rizaki.ch4challengerizaki.model.Notes

@Dao
interface NotesDao {
    @Query("SELECT * FROM tbl_notes ORDER BY id ASC")
    fun select(): LiveData<List<Notes>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Notes): Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(item: Notes): Int

    @Delete
    suspend fun delete(item: Notes): Int
}