package hu.geribruu.marvelcomics.data

import androidx.annotation.WorkerThread
import hu.geribruu.marvelcomics.data.model.CharacterDataModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavouriteCharacterRepository @Inject constructor(private val favouriteCharacterDao: FavouriteCharacterDao) : ICharacterRepository {

    override fun getAll(): Flow<List<CharacterDataModel>> {
        return favouriteCharacterDao.getAll()
    }

    @WorkerThread
    override suspend fun insert(characterDataModel: CharacterDataModel) {
        favouriteCharacterDao.insert(characterDataModel)
    }

    override suspend fun deleteCharacter(characterDataModel: CharacterDataModel) {
        favouriteCharacterDao.deleteCharacter(characterDataModel)
    }
}