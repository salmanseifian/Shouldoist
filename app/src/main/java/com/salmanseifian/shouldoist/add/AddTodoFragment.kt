package com.salmanseifian.shouldoist.add

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import com.jakewharton.rxbinding2.widget.textChanges
import com.salmanseifian.shouldoist.R
import com.salmanseifian.shouldoist.base.BaseFragment
import io.reactivex.rxkotlin.addTo
import kotlinx.android.synthetic.main.fragment_add_todo.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class AddTodoFragment : BaseFragment() {

    private val addTodoViewModel: AddTodoViewModel by viewModel()

    override fun layoutRes(): Int {
        return R.layout.fragment_add_todo
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val calendar = Calendar.getInstance()
        val year = calendar[Calendar.YEAR]
        val month = calendar[Calendar.MONTH]
        val day = calendar[Calendar.DAY_OF_MONTH]

        edt_date.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
                it.context,
                DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                    val date = "$year/$month/$dayOfMonth"
                    edt_date.setText(date)
                    addTodoViewModel.addDate(date)
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }

        edt_time.setOnClickListener {

            val calendar = Calendar.getInstance()
            val hour = calendar[Calendar.HOUR_OF_DAY]
            val minute = calendar[Calendar.MINUTE]
            val timePickerDialog = TimePickerDialog(
                it.context,
                TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
                    edt_time.setText("$hourOfDay : $minute")
                },
                hour,
                minute,
                false
            )
            timePickerDialog.show()
        }

        fav_add.setOnClickListener {
            addTodoViewModel.addTodo()
        }

        edt_title.textChanges()
            .filter { it.length > 2 }
            .map { it.toString() }
            .subscribe(addTodoViewModel::addTitle)
            .addTo(compositeDisposable)

        edt_description.textChanges()
            .filter { it.length > 2 }
            .map { it.toString() }
            .subscribe(addTodoViewModel::addDescription)
            .addTo(compositeDisposable)

        edt_time.textChanges()
            .filter { it.length > 6 }
            .map { it.toString() }
            .subscribe(addTodoViewModel::addDate)
            .addTo(compositeDisposable)
    }

}