package com.sashakhyzhun.androidroomexample.data.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.sashakhyzhun.androidroomexample.data.model.Word

/**
 * @author SashaKhyzhun
 * Created on 10/3/18.
 */

@Dao
interface WordDao {

    /**
     * default SQL behavior is ABORT
     */
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(word: Word)

    @Query("DELETE FROM word_table")
    fun deleteAll()

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAllWords(): LiveData<List<Word>>



}