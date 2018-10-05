package com.sashakhyzhun.androidroomexample

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.persistence.room.RoomDatabase
import android.os.AsyncTask

/**
 * @author SashaKhyzhun
 * Created on 10/5/18.
 */
class WordRepository constructor(app: Application) {

    private var wordDao: WordDao
    private var allWords: LiveData<List<Word>>

    init {
        val db = WordRoomDatabase.getDatabase(app)
        wordDao = db?.wordDao()!!
        allWords = wordDao.getAllWords()
    }


    fun getAllWords(): LiveData<List<Word>> = allWords


    fun insert(word: Word) {
        InsertAsyncTask(wordDao).execute(word)
    }



    private class InsertAsyncTask(val wordDao: WordDao): AsyncTask<Word, Void, Void>() {

        override fun doInBackground(vararg word: Word?): Void? {
            wordDao.insert(word[0]!!)
            return null
        }
    }

}
