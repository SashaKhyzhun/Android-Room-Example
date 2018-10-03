package com.sashakhyzhun.androidroomexample

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

/**
 * @author SashaKhyzhun
 * Created on 10/3/18.
 */

@Entity(tableName = "word_table")
data class Word
    constructor(
            @PrimaryKey
            @NonNull
            @ColumnInfo(name = "word")
            var word: String
    )