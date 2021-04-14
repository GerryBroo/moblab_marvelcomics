package hu.geribruu.marvelcomics.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.geribruu.marvelcomics.network.CharacterApi
import hu.geribruu.marvelcomics.network.CharacterRepository
import hu.geribruu.marvelcomics.network.model.CharacterDataWrapper
import hu.geribruu.marvelcomics.network.model.CharacterNet
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val service: CharacterApi): ViewModel() {

    val characters : Array<CharacterNet> = getAllCharacters()

    fun getAllCharacters() : Array<CharacterNet> {
        var result : Array<CharacterNet> = emptyArray()
        service.getCharacters(10,0).enqueue(object : Callback<CharacterDataWrapper> {
            override fun onResponse(
                    call: Call<CharacterDataWrapper>,
                    response: Response<CharacterDataWrapper>
            ) {
                result = response.body()!!.data.results
                for(r in result) {
                    Log.d("RETROFIT", r.name)
                }
            }

            override fun onFailure(call: Call<CharacterDataWrapper>, t: Throwable) {
                Log.d("RETROFIT", "FAIL")
            }
        })
        return result
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}