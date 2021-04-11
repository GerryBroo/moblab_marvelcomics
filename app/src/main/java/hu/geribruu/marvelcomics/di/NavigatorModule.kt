package hu.geribruu.marvelcomics.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import hu.geribruu.marvelcomics.navigator.AppNavigator
import hu.geribruu.marvelcomics.navigator.AppNavigatorImpl

@InstallIn(ActivityComponent::class)
@Module
abstract class NavigatorModule {

    @Binds
    abstract fun bindNavigator(impl: AppNavigatorImpl): AppNavigator
}