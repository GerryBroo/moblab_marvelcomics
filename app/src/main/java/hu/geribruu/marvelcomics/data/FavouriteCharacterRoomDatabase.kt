package hu.geribruu.marvelcomics.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import hu.geribruu.marvelcomics.data.model.CharacterDataModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [CharacterDataModel::class], version = 1, exportSchema = false)
abstract class FavouriteCharacterRoomDatabase : RoomDatabase() {
    abstract fun favouriteCharacterDao() : FavouriteCharacterDao

    private class CharacterDatabaseCallback (
            private val scope : CoroutineScope) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            INSTANCE?.let { database ->
                scope.launch {
                    val characterDao = database.favouriteCharacterDao()
                    characterDao.deleteAll()
                }
            }
        }
    }

    companion object{
        @Volatile
        private var INSTANCE : FavouriteCharacterRoomDatabase? = null

        fun getDatabase(
                context : Context,
                scope : CoroutineScope
        ) : FavouriteCharacterRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        FavouriteCharacterRoomDatabase::class.java,
                        "characters"
                )
                        .addCallback(CharacterDatabaseCallback(scope))
                        .build()
                INSTANCE = instance
                instance
            }
        }
    }
}