package com.mjh.rxexam.hilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DiModule {

    @Singleton
    @Provides
    fun providesStrFun():String{
        return "providesStrFun"
    }

    @Singleton
    @Provides
    fun providesClass() = Data()


/*
    @ActivityScoped
    @Provides
    fun providesClassWithParam() = Data2()*/

    @Singleton
    @Provides
    fun providesRepository() = HiltRepository()

}