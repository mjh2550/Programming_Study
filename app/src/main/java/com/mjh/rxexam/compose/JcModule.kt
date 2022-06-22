package com.mjh.rxexam.compose

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object JcModule {

    @Singleton
    @Provides
    fun testFun() = "testInject"
}