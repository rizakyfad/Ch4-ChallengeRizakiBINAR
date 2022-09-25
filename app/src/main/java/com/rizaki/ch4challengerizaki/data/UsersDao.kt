package com.rizaki.ch4challengerizaki.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rizaki.ch4challengerizaki.model.Users

@Dao
interface UsersDao {
    @Query("SELECT * FROM tbl_users WHERE email=:email AND password=:password")
    suspend fun selectByEmailAndPassword(email: String?, password: String?): Users?

    @Query("SELECT * FROM tbl_users WHERE username=:username OR email=:email")
    suspend fun selectByUsernameOrEmail(username: String?, email: String?): Users?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: Users): Long
}