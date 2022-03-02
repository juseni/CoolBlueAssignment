package com.coolblue.assignment.di

import com.coolblue.assignment.ui.activities.MainActivity
import com.coolblue.assignment.ui.activities.ObjectForSaleDetailActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeObjectForSaleDetailActivity(): ObjectForSaleDetailActivity
}