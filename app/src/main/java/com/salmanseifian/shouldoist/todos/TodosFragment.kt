package com.salmanseifian.shouldoist.todos

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.salmanseifian.shouldoist.R
import com.salmanseifian.shouldoist.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_todos.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class TodosFragment : BaseFragment() {

    private val todosViewModel: TodosViewModel by viewModel()


    override fun layoutRes(): Int {
        return R.layout.fragment_todos
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fab_add_todo.setOnClickListener {
            findNavController().navigate(R.id.action_todosFragment_to_addTodoFragment)
        }

        todosViewModel.getTodos()
    }
}