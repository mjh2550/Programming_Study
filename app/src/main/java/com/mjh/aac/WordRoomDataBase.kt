package com.mjh.aac

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

public abstract class WordRoomDataBase : RoomDatabase() {

    abstract fun wordDao() : WordDao

    companion object{
        //volatile을 지정하면 값을 메인 메모리에만 적재한다. Thread-Safe 하게 하기 위한 방법.
        @Volatile
        private var INSTANCE : WordRoomDataBase? = null

        fun getDatabase(context : Context): WordRoomDataBase{

            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordRoomDataBase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}