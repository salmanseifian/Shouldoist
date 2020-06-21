package com.salmanseifian.shouldoist.di

import androidx.room.Room
import com.salmanseifian.shouldoist.TodoRepository
import com.salmanseifian.shouldoist.TodoRepositoryImpl
import com.salmanseifian.shouldoist.add.AddTodoViewModel
import com.salmanseifian.shouldoist.db.AppDatabase
import com.salmanseifian.shouldoist.db.TodoDao
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel {
        AddTodoViewModel(get())
    }
}

val repositoryModule = module {
    single<TodoRepository> {
        TodoRepositoryImpl(
            get()
        )
    }
}

val dbModule = module {
    single {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, "AppDatabase")
            .build()
    }

    single<TodoDao> {
        get<AppDatabase>().todoDao
    }
}