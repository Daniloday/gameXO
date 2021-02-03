package com.missclick.gamexo.di.module

import android.content.Context
import androidx.room.Room
import com.missclick.gamexo.datasource.local.LocalDataSource
import com.missclick.gamexo.datasource.local.ResultsDatabase
import com.missclick.gamexo.repository.IRepository
import com.missclick.gamexo.repository.Repository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun provideIRepository(local : LocalDataSource) : IRepository{
        return Repository(local)
    }

    @Provides
    fun provideLocalDataSource(appContext: Context) : LocalDataSource{
        val database = Room.databaseBuilder(appContext, ResultsDatabase::class.java, "database")
            .fallbackToDestructiveMigration()
            .build()
        return LocalDataSource(database = database)
    }

}