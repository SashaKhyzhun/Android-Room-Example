package com.sashakhyzhun.androidroomexample.ui.main

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.sashakhyzhun.androidroomexample.data.model.Word
import com.sashakhyzhun.androidroomexample.data.repository.WordRepository

class WordViewModel(app: Application) : AndroidViewModel(app) {

    private var mRepository: WordRepository = WordRepository(app)
    private var mAllWords: LiveData<List<Word>>

    init {
        mAllWords = mRepository.getAllWords()
    }

    fun getAllWords(): LiveData<List<Word>> = mAllWords

    fun insert(word: Word) {
        mRepository.insert(word)
    }

}