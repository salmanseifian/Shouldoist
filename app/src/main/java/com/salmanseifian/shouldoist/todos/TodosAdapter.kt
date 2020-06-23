package com.salmanseifian.shouldoist.todos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.salmanseifian.shouldoist.R
import com.salmanseifian.shouldoist.ToDo
import com.salmanseifian.shouldoist.toFormattedString

class TodosAdapter() : RecyclerView.Adapter<TodosAdapter.TodoHolder>() {

    private val todos = mutableListOf<ToDo>()
    private lateinit var _context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoHolder {
        _context = parent.context
        val view = LayoutInflater.from(_context).inflate(R.layout.item_todo, parent, false)
        return TodoHolder(view)
    }

    override fun getItemCount() = todos.size

    override fun onBindViewHolder(holder: TodoHolder, position: Int) {
        holder.bind(todos[position])
    }

    fun addTodos(newTodos: List<ToDo>) {
        todos.addAll(newTodos)
        notifyDataSetChanged()
    }

    class TodoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val txtTitle = itemView.findViewById<TextView>(R.id.txt_title)
        private val txtDate = itemView.findViewById<TextView>(R.id.txt_date)

        fun bind(toDo: ToDo) {

            txtTitle.text = toDo.title
            txtDate.text = toDo.dueDate?.toFormattedString()
        }
    }
}