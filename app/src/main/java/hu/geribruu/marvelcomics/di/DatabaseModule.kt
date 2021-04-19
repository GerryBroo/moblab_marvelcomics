package hu.geribruu.marvelcomics.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import hu.geribruu.marvelcomics.data.FavouriteCharacterDao
import hu.geribruu.marvelcomics.data.FavouriteCharacterRoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    private val applicationScope = CoroutineScope(SupervisorJob())

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): FavouriteCharacterRoomDatabase {
       return FavouriteCharacterRoomDatabase.getDatabase(appContext, applicationScope)
    }

    @Provides
    fun provideCharacterDao(databaseFavourite: FavouriteCharacterRoomDatabase): FavouriteCharacterDao
        = databaseFavourite.favouriteCharacterDao()
}