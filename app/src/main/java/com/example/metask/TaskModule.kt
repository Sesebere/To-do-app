package com.example.metask

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object TaskModule {
    @Provides
    fun provideContext(@ApplicationContext context: Context): Context {
        return context
    }
    @Provides
    fun provideDatabase(context: Context) = DatabaseProvider.getDatabase(context)
    @Provides
    fun provideTaskDao(database: TaskDatabase) = database.taskDao()
    @Provides
    fun provideRepository(taskDao:TaskDao) = RepositoryImpl(taskDao)
    @Provides
    fun provideViewModel(repository: RepositoryImpl) = TaskViewModel(repository)
}