package com.coolblue.assignment.di

import android.app.Application
import android.content.Context
import androidx.navigation.NavController
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Juan Sebastian Niño
 */
@Module
class AppModule {

    @Provides
    fun provideContext(app: Application): Context = app


    @Singleton
    @Provides
    fun provideNavigatorController(context: Context): NavController {
        return NavController(context)
    }
}