package hu.geribruu.marvelcomics.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import hu.geribruu.marvelcomics.data.CharacterDao
import hu.geribruu.marvelcomics.data.CharacterRoomDatabase
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): CharacterRoomDatabase {
        return Room.databaseBuilder(
            appContext,
            CharacterRoomDatabase::class.java,
            "characters.db"
        ).build()
    }

    @Provides
    fun provideCharacterDao(database: CharacterRoomDatabase): CharacterDao {
        return database.characterDao()
    }
}