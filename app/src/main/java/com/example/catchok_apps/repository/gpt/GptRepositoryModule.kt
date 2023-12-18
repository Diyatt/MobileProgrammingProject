package com.example.catchok_apps.repository.gpt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.example.catchok_apps.network.gpt.GptApi
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object GptRepositoryModule {
    @Singleton
    @Provides
    fun provideGptRepository(api: GptApi):GptRepositoryImpl{
        return GptRepositoryImpl(api)
    }
}