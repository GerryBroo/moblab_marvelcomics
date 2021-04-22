package hu.geribruu.marvelcomics.network

import android.util.Log
import androidx.lifecycle.MutableLiveData
import hu.geribruu.marvelcomics.network.model.CharacterDataWrapper
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val service : CharacterApi) {

    fun getAllCharacter() : MutableLiveData<CharacterDataWrapper> {
        var result : MutableLiveData<CharacterDataWrapper> = MutableLiveData()
        service.getCharacters(100,0).enqueue(object : Callback<CharacterDataWrapper> {
            override fun onResponse(
                    call: Call<CharacterDataWrapper>,
                    response: Response<CharacterDataWrapper>
            ) {
                result.value = response.body()!!
                Log.d("Retro", "repo result onresponse ${result.value!!.data.results.size}")

            }

            override fun onFailure(call: Call<CharacterDataWrapper>, t: Throwable) {
                Log.d("RETROFIT", "FAIL")
            }
        })
        return result
    }
}