package com.rizaki.ch4challengerizaki.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rizaki.ch4challengerizaki.data.NotesDao
import com.rizaki.ch4challengerizaki.data.UsersDao
import com.rizaki.ch4challengerizaki.model.Notes
import com.rizaki.ch4challengerizaki.model.Users

@Database(entities = [
    Notes::class,
    Users::class
], version = 1, exportSchema = false)
abstract class RoomDB: RoomDatabase() {
    companion object {
        @Volatile
        private var INSTANCE: RoomDB? = null

        fun database(context: Context): RoomDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val db = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDB::class.java,
                    "db_app"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = db
                return db
            }
        }
    }

    abstract fun notesDao(): NotesDao
    abstract fun usersDao(): UsersDao
}