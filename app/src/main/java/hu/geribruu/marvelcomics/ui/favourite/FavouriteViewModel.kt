package hu.geribruu.marvelcomics.ui.favourite

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.geribruu.marvelcomics.data.FavouriteCharacterRepository
import hu.geribruu.marvelcomics.data.model.CharacterDataModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouriteViewModel @Inject constructor(private val repositoryFavourite: FavouriteCharacterRepository) : ViewModel() {

    val characters : LiveData<List<CharacterDataModel>> = repositoryFavourite.getAll().asLiveData()

    fun insert(characterDataModel: CharacterDataModel) = viewModelScope.launch {
        repositoryFavourite.insert(characterDataModel)
    }

    fun deleteCharacter(characterDataModel: CharacterDataModel) = viewModelScope.launch {
        repositoryFavourite.deleteCharacter(characterDataModel)
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text
}