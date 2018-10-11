package com.sashakhyzhun.androidroomexample.ui.main

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.sashakhyzhun.androidroomexample.R
import com.sashakhyzhun.androidroomexample.data.model.Word

class WordListAdapter(private val context: Context) : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

    var mWords: List<Word>? = null


    override fun onCreateViewHolder(parent: ViewGroup, type: Int): WordViewHolder =
            WordViewHolder(LayoutInflater.from(context)
                    .inflate(R.layout.item_recycler_view, parent, false))

    override fun getItemCount(): Int = mWords?.size ?: 0

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        if (mWords != null) {
            holder.wordItemView.text = mWords!![position].word
        } else {
            holder.wordItemView.text = "No word"
        }
    }

    class WordViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val wordItemView: TextView = item.findViewById(R.id.tvWord)
    }

}