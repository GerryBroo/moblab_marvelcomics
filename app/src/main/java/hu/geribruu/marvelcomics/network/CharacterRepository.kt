package hu.geribruu.marvelcomics.network

import android.util.Log
import androidx.lifecycle.MutableLiveData
import hu.geribruu.marvelcomics.model.toMarvelCharacter
import hu.geribruu.marvelcomics.network.model.CharacterDataWrapper
import hu.geribruu.marvelcomics.network.model.CharacterNet
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val service : CharacterApi) {

    fun loadAllCharacter() : MutableLiveData<CharacterDataWrapper> {
        val result : MutableLiveData<CharacterDataWrapper> = MutableLiveData()
        service.loadCharacters(100,0).enqueue(object : Callback<CharacterDataWrapper> {
            override fun onResponse(
                    call: Call<CharacterDataWrapper>,
                    response: Response<CharacterDataWrapper>
            ) {
                result.value = response.body()!!
            }

            override fun onFailure(call: Call<CharacterDataWrapper>, t: Throwable) {
                Log.d("RETROFIT", "FAIL ${t.message}")
            }
        })
        return result
    }

    fun loadCharacter(characterId: String): MutableLiveData<CharacterNet> {
        val result : MutableLiveData<CharacterNet> = MutableLiveData()
        service.loadCharacter(characterId).enqueue(object : Callback<CharacterDataWrapper> {
            override fun onResponse(call: Call<CharacterDataWrapper>, response: Response<CharacterDataWrapper>) {
                result.value = response.body()!!.data.results.first()
            }

            override fun onFailure(call: Call<CharacterDataWrapper>, t: Throwable) {
                Log.d("RETROFIT", "FAIL")
            }
        })
        return result
    }
}