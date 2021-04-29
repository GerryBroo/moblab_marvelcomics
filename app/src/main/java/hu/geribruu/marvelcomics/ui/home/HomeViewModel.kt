package hu.geribruu.marvelcomics.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.geribruu.marvelcomics.network.CharacterRepository
import hu.geribruu.marvelcomics.network.model.CharacterDataWrapper
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: CharacterRepository): ViewModel() {

    var characters : LiveData<CharacterDataWrapper> = repository.loadAllCharacter()
        get() = field
}