package com.rizaki.ch4challengerizaki.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.rizaki.ch4challengerizaki.model.Notes

interface NoteHelper {
    /**
     * inisialisasi adapter
     * */
    fun init(): RecyclerView.Adapter<RecyclerView.ViewHolder>

    /**
     * add list to adapter
     * */
    fun differ(listItem: List<Notes>)

    /**
     * state onclick
     * */
    fun onClick(listener: (Int, Notes) -> Unit)
    fun onEditClick(listener: (Int, Notes) -> Unit)
    fun onDeleteClick(listener: (Int, Notes) -> Unit)
}