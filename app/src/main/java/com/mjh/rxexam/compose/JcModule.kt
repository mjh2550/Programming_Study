package com.mjh.rxexam.compose

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(ActivityRetainedComponent::class)
@Module
object JcModule {

    @Named("testFun")
    @ActivityRetainedScoped
    @Provides
    fun testFun() = "testInject"
}