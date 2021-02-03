package com.missclick.gamexo.di

import com.missclick.gamexo.di.module.AppModule
import com.missclick.gamexo.di.module.RepositoryModule
import com.missclick.gamexo.ui.finish.FinishViewModel


import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class, RepositoryModule::class])
@Singleton
interface AppComponent{
    fun inject(finishViewModel: FinishViewModel)
}