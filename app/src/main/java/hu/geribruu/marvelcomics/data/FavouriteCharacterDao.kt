package hu.geribruu.marvelcomics.data

import androidx.lifecycle.LiveData
import androidx.room.*
import hu.geribruu.marvelcomics.data.model.CharacterDataModel
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouriteCharacterDao {

    @Query("SELECT * FROM characters ORDER BY id DESC")
    fun getAll(): Flow<List<CharacterDataModel>>

    @Query("SELECT * FROM characters WHERE id=:id")
    fun getCharacter(id: Long) : CharacterDataModel

    @Insert
    suspend fun insert(character : CharacterDataModel)

    @Query("DELETE FROM characters")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteCharacter(character: CharacterDataModel)

    @Update
    suspend fun updateCharacter(character: CharacterDataModel)
}