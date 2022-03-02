package com.coolblue.assignment.di

import android.app.Application
import com.coolblue.assignment.CoolBlueAssignmentApplication
import com.coolblue.assignment.di.scopes.ObjectsForSaleScope
import com.coolblue.data.di.NetworkModule
import com.coolblue.data.di.RepositoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * @author Juan Sebastian Niño
 */
@Singleton
@ObjectsForSaleScope
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuildersModule::class,
        AppModule::class,
        NetworkModule::class,
        ViewModelFactoryModule::class,
        ViewModelModule::class,
        RepositoryModule::class]
)
interface ApplicationComponent : AndroidInjector<CoolBlueAssignmentApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }
}