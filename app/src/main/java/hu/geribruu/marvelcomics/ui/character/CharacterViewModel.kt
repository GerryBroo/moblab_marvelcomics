package hu.geribruu.marvelcomics.ui.character

import android.util.Log
import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.geribruu.marvelcomics.network.CharacterRepository
import hu.geribruu.marvelcomics.network.model.CharacterNet
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
        private val savedStateHandle: SavedStateHandle,
        private val repository: CharacterRepository
        ): ViewModel(), LifecycleObserver {

    companion object {
        const val CHARACTER_ID = "CHARACTER_ID"
    }

    private fun loadCharacter() : MutableLiveData<CharacterNet> {
        val characterId = savedStateHandle.get<String>(CHARACTER_ID)
        return repository.loadCharacter(characterId.toString())
    }

    val showTextDataNotifier: LiveData<CharacterNet> = loadCharacter()
        get() {
            field.value?.let { Log.d("ASD", it.description) }
            return field
        }
}