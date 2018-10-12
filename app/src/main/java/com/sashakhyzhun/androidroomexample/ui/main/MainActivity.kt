package com.sashakhyzhun.androidroomexample.ui.main

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.sashakhyzhun.androidroomexample.R
import com.sashakhyzhun.androidroomexample.data.model.Word
import com.sashakhyzhun.androidroomexample.ui.new_word.NewWordActivity


class MainActivity : AppCompatActivity() {

    companion object {
        const val NEW_WORD_ACTIVITY_REQUEST_CODE = 1
    }

    private lateinit var mWordViewModel: WordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mWordViewModel = ViewModelProviders.of(this).get(WordViewModel::class.java)

        val rv: RecyclerView = findViewById(R.id.recycler_view)
        val adapter = WordListAdapter(this)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)

        mWordViewModel.getAllWords().observe(this, Observer { words ->
            adapter.setWords(words)
        })

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener {
            startActivityForResult(
                    Intent(this, NewWordActivity::class.java),
                    NEW_WORD_ACTIVITY_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val word = Word(data?.getStringExtra(NewWordActivity.EXTRA_REPLY)!!)
            mWordViewModel.insert(word)
        } else {
            Toast.makeText(this, R.string.empty_not_saved, Toast.LENGTH_SHORT).show()
        }
    }


}
