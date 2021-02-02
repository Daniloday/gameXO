package com.missclick.gamexo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.missclick.gamexo.R
import com.missclick.gamexo.data.Finish

class ResultsAdapter(var items: MutableList<Finish>, val callback: Any) : RecyclerView.Adapter<ResultsAdapter.MainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = MainHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_lesson_item, parent, false))
    override fun getItemCount() = items.size
    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(items[position])
    }
    fun removeAt(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }
    inner class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name = itemView.findViewById<TextView>(R.id.text_name_list_lesson_item)
        private val teacherName = itemView.findViewById<TextView>(R.id.text_teacher_name_list_lesson_item)
        private val type = itemView.findViewById<TextView>(R.id.text_type_list_lesson_item)
        fun bind(item: Finish) {
            name.text = item.winner.toString()
            teacherName.text = item.winner.toString()
            type.text = item.winner.toString()
            itemView.setOnClickListener {

            }
        }
    }

    interface Callback {
        fun onItemClicked(item: Finish)
    }
}