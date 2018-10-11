//package com.sashakhyzhun.androidroomexample.data.db
//
//import android.arch.persistence.room.Database
//import android.arch.persistence.room.Room
//import android.arch.persistence.room.RoomDatabase
//import android.content.Context
//import com.sashakhyzhun.androidroomexample.data.model.Word
//
///**
// * @author SashaKhyzhun
// * Created on 10/3/18.
// */
//
//@Database(entities = arrayOf(Word::class), version = 1)
//abstract class WordRoomDatabase : RoomDatabase() {
//
//    abstract fun wordDao(): WordDao
//
//    companion object {
//
//        @Volatile
//        private var INSTANCE: WordRoomDatabase? = null
//
//        internal fun getDatabase(context: Context): WordRoomDatabase? {
//            if (INSTANCE == null) {
//                synchronized(WordRoomDatabase::class.java) {
//                    INSTANCE = Room.databaseBuilder(context.applicationContext,
//                            WordRoomDatabase::class.java,
//                            "word_database")
//                            .build()
//                }
//            }
//            return INSTANCE
//        }
//
//        val sRoomDatabaseCallback: RoomDatabase.Callback()
//
//
//    }
//
//
//}
