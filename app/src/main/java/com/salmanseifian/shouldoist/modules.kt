package com.salmanseifian.shouldoist

import androidx.room.Room
import com.salmanseifian.shouldoist.db.AppDatabase
import com.salmanseifian.shouldoist.db.TodoDao
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    single<TodoRepository> { TodoRepositoryImpl(get()) }
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