package com.sashakhyzhun.androidroomexample.ui.new_word

import android.os.Bundle
import android.app.Activity
import android.content.Intent
import android.widget.Button

import com.sashakhyzhun.androidroomexample.R
import android.widget.EditText



class NewWordActivity : Activity() {

    val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"

    private lateinit var mEditWordView: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)

        mEditWordView = findViewById(R.id.edit_word)

        val button: Button = findViewById(R.id.button_save)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (mEditWordView.text.isEmpty()) {
                setResult(RESULT_CANCELED, replyIntent)
            } else {
                val word = mEditWordView.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, word)
                setResult(RESULT_OK, replyIntent)
            }
        }
    }

}
