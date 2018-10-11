package com.sashakhyzhun.androidroomexample

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData

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