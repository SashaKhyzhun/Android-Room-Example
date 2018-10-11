package com.sashakhyzhun.androidroomexample.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.sashakhyzhun.androidroomexample.R
import com.sashakhyzhun.androidroomexample.data.model.Word

class MainActivity : AppCompatActivity() {

    private lateinit var mWordViewModel: WordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mWordViewModel = ViewModelProviders.of(this).get(WordViewModel::class.java)

        val rv: RecyclerView = findViewById(R.id.recycler_view)
        val adapter = WordListAdapter(this)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)

        mWordViewModel.getAllWords().observe(this, Observer {

        })

    }


}
