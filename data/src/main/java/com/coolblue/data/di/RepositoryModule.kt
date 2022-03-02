package com.coolblue.data.di

import com.coolblue.data.platform.NetworkHandler
import com.coolblue.data.repositories.CoolBlueRepositoryImpl
import com.coolblue.data.source.CoolBlueApi
import com.coolblue.domain.repositories.CoolBlueRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideGson(): Gson =
        GsonBuilder().create()

    @Provides
    fun provideCoolBlueRepository(
        apiService: CoolBlueApi,
        gson: Gson,
        networkChecker: NetworkHandler
    ) : CoolBlueRepository =
        CoolBlueRepositoryImpl(
            gson,
            apiService,
            networkChecker
        )
}