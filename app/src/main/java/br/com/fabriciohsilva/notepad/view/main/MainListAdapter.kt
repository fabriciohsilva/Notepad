package br.com.fabriciohsilva.notepad.view.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.fabriciohsilva.notepad.R
import br.com.fabriciohsilva.notepad.model.Note
import kotlinx.android.synthetic.main.note_item.view.*

class MainListAdapter( val notes: List<Note>, val context: Context ): RecyclerView.Adapter<MainListAdapter.NoteViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NoteViewHolder {
        val itemView = LayoutInflater
                            .from(context)
                            .inflate(R.layout.note_item, p0, false)

        return NoteViewHolder(itemView)
    }//end override fun onCreateViewHolder

    override fun getItemCount(): Int {
        return notes.size
    }//end override fun getItemCount

    override fun onBindViewHolder(p0: NoteViewHolder, position: Int) {
        val note = notes[position]
        p0.bindView(note)
    }//end override fun onBindViewHolder

    class NoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindView(note: Note) = with(itemView) {
            tvTitle.text = note.title
            tvDescription.text = note.description
        }//end fun bindView

    }//end class NoteViewHolder

}//end class MainListAdapter