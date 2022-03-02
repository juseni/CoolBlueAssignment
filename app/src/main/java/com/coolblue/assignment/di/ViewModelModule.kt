package com.coolblue.assignment.di

import androidx.lifecycle.ViewModel
import com.coolblue.assignment.viewmodels.ObjectsForSaleDetailViewModel
import com.coolblue.assignment.viewmodels.ObjectsForSaleViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @author Juan Sebastian Niño
 */
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ObjectsForSaleDetailViewModel::class)
    abstract fun bindObjectsForSaleDetailViewModel(
        objectsForSaleDetailViewModel: ObjectsForSaleDetailViewModel
    ): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ObjectsForSaleViewModel::class)
    abstract fun bindObjectsForSaleViewModel(
        objectsForSaleViewModel: ObjectsForSaleViewModel
    ): ViewModel
}