package hu.geribruu.marvelcomics.data

import androidx.room.Database
import androidx.room.RoomDatabase
import hu.geribruu.marvelcomics.data.model.CharacterDataModel

@Database(entities = [CharacterDataModel::class], version = 1, exportSchema = false)
abstract class CharacterRoomDatabase : RoomDatabase() {
    abstract fun characterDao() : CharacterDao
}