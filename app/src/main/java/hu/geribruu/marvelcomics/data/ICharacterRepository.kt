package hu.geribruu.marvelcomics.data

import hu.geribruu.marvelcomics.data.model.CharacterDataModel
import kotlinx.coroutines.flow.Flow

interface ICharacterRepository {

    fun getAll() : Flow<List<CharacterDataModel>>
    suspend fun insert(characterDataModel: CharacterDataModel)
    suspend fun deleteCharacter(characterDataModel: CharacterDataModel)
}