package hu.geribruu.marvelcomics.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import hu.geribruu.marvelcomics.data.model.CharacterDataModel

@Dao
interface CharacterDao {

    @Query("SELECT * FROM characters ORDER BY id DESC")
    fun getAll(): List<CharacterDataModel>

    @Insert
    fun insert(character : CharacterDataModel)
}