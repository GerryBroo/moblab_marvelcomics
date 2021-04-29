package hu.geribruu.marvelcomics.ui.character

import android.util.Log
import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.geribruu.marvelcomics.data.FavouriteCharacterRepository
import hu.geribruu.marvelcomics.data.model.CharacterDataModel
import hu.geribruu.marvelcomics.network.CharacterRepository
import hu.geribruu.marvelcomics.network.model.CharacterNet
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
        private val savedStateHandle: SavedStateHandle,
        private val repositoryRetrofit: CharacterRepository,
        private val repositoryFavourite: FavouriteCharacterRepository
        ): ViewModel(), LifecycleObserver {

    companion object {
        const val CHARACTER_ID = "CHARACTER_ID"
    }

    val showTextDataNotifier: LiveData<CharacterNet> = loadCharacter()
        get() {
            field.value?.let { Log.d("ASD", it.description) }
            return field
        }

    private fun loadCharacter() : MutableLiveData<CharacterNet> {
        val characterId = savedStateHandle.get<String>(CHARACTER_ID)
        return repositoryRetrofit.loadCharacter(characterId.toString())
    }

    fun insertToDatabase(characterNet: CharacterNet) = viewModelScope.launch {
        val character = CharacterDataModel(
                0,
                characterNet.id.toString(),
                characterNet.name,
                characterNet.description)
        repositoryFavourite.insert(character)
    }
}