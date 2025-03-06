package com.example.mynoteroom.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1)
abstract class NoteRoomDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
    companion object {
        @Volatile
        private var INTANCE: NoteRoomDatabase? = null
        @JvmStatic
        fun getDatabase(context: Application): NoteRoomDatabase {
            if (INTANCE == null) {
                synchronized(NoteRoomDatabase::class.java) {
                    INTANCE = Room.databaseBuilder(context.applicationContext,
                        NoteRoomDatabase::class.java, "note_database")
                        .build()
                }
            }
            return INTANCE as NoteRoomDatabase
        }
    }

}