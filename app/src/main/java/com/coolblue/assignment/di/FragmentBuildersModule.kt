package com.coolblue.assignment.di

import com.coolblue.assignment.ui.fragments.ObjectsForSaleFragment
import com.coolblue.assignment.ui.fragments.SearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author Juan Sebastian Niño
 */
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun provideObjectForSalesFragment(): ObjectsForSaleFragment

    @ContributesAndroidInjector
    abstract fun provideSearchFragment(): SearchFragment
}