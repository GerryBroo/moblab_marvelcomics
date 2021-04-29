package hu.geribruu.marvelcomics.ui.character

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.geribruu.marvelcomics.network.CharacterRepository
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
        private val savedStateHandle: SavedStateHandle,
        private val repository: CharacterRepository
        ): ViewModel(), LifecycleObserver {

    companion object {
        const val CHARACTER_ID = "CHARACTER_ID"
    }

    private val showTextLiveData = savedStateHandle.getLiveData<String>(CHARACTER_ID)
    val showTextDataNotifier: LiveData<String>
        get() = showTextLiveData
}