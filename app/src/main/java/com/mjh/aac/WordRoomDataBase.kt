package com.mjh.aac

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

public abstract class WordRoomDataBase : RoomDatabase() {

    abstract fun wordDao() : WordDao

    companion object{
        //volatile을 지정하면 값을 메인 메모리에만 적재한다. Thread-Safe 하게 하기 위한 방법.
        @Volatile
        private var INSTANCE : WordRoomDataBase? = null

        //수명주기가 짧은 context를 지양해야함
        fun getDatabase(context : Context, scope : CoroutineScope): WordRoomDataBase{

            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordRoomDataBase::class.java,
                    "word_database"
                )
                    .addCallback(WordDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

    private class WordDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.wordDao())
                }
            }
        }

        suspend fun populateDatabase(wordDao: WordDao) {
            // Delete all content here.
            wordDao.deleteAll()

            // Add sample words.
            var word = Word("Hello")
            wordDao.insert(word)
            word = Word("World!")
            wordDao.insert(word)

            // TODO: Add your own words!
        }
    }
}