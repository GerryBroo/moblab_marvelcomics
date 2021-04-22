package hu.geribruu.marvelcomics.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.geribruu.marvelcomics.network.CharacterRepository
import hu.geribruu.marvelcomics.network.model.CharacterDataWrapper
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: CharacterRepository): ViewModel() {

  /*  private var character : MutableLiveData<List<MarvelCharacter>>? = null

    fun getAll() : LiveData<List<MarvelCharacter>>? {
        if(character == null) {
            loadAll()
        }
        return character
    }

    private fun loadAll() {
        val result = repository.getAllCharacter()
        val c = ArrayList<MarvelCharacter>()
        result.value!!.data.results.mapTo(c, { it.toMarvelCharacter()})
        character?.value = c
    }*/

    var characters : LiveData<CharacterDataWrapper> = repository.getAllCharacter()
        get() = field

  /*  private var characters1 = MutableLiveData<List<MarvelCharacter>>().apply {
        var r = repository.getAllCharacter()

        Log.d("RETRO", "r ${r.value!!.data.results.size}")

        var c = ArrayList<MarvelCharacter>()
        r.value!!.data.results.mapTo(c, { it.toMarvelCharacter()})
        Log.d("RETRO", "c ${c.size}")
        value = c
    }
    val liveData : LiveData<List<MarvelCharacter>> = characters1*/

  /*  fun getAll() : MutableLiveData<List<MarvelCharacter>> {
        var r = repository.getAllCharacter().value!!.data.results
        var c = ArrayList<MarvelCharacter>()
        r.mapTo(c, { it.toMarvelCharacter()})
        return c as MutableLiveData<List<MarvelCharacter>>
    }*/


    /* private val _characters = MutableLiveData<List<MarvelCharacter>>().apply {
         value = repository.marvelCharacters
     }
     val characters = _characters*/
/*
    var characters : MutableLiveData<List<MarvelCharacter>>? = null
    fun getAllCharacters() : LiveData<List<MarvelCharacter>> {
        characters = repository.getAllCharacter()
        Log.d("Retro", "VM ${characters!!.value?.size}")
        return characters as MutableLiveData<List<MarvelCharacter>>
    }*/




   //val characters : Array<CharacterNet> = getAllCharacters()

  /*  private fun getAllCharacters() : Array<CharacterNet> {
        var result : Array<CharacterNet> = emptyArray()
        service.getCharacters(10,0).enqueue(object : Callback<CharacterDataWrapper> {
            override fun onResponse(
                    call: Call<CharacterDataWrapper>,
                    response: Response<CharacterDataWrapper>
            ) {
               result = response.body()!!.data.results

                Log.d("RETROFIT", "getall ${result.size}")
            }

            override fun onFailure(call: Call<CharacterDataWrapper>, t: Throwable) {
                Log.d("RETROFIT", "FAIL")
            }
        })
        return result
    }

    private val _characters = MutableLiveData<List<MarvelCharacter>>().apply {

        var charactersNet : Array<CharacterNet> = emptyArray()
        service.getCharacters(10,0).enqueue(object : Callback<CharacterDataWrapper> {
            override fun onResponse(
                    call: Call<CharacterDataWrapper>,
                    response: Response<CharacterDataWrapper>
            ) {
                charactersNet = response.body()!!.data.results

                Log.d("RETROFIT", "getall ${charactersNet.size}")
            }

            override fun onFailure(call: Call<CharacterDataWrapper>, t: Throwable) {
                Log.d("RETROFIT", "FAIL")
            }
        })

        //val charactersNet : Array<CharacterNet> = getAllCharacters()
        val resultsList: MutableList<MarvelCharacter> = mutableListOf()

        charactersNet.mapTo(resultsList, { it.toMarvelCharacter() })

        Log.d("RETROFIT", "result ${resultsList.size}")

        for(r in resultsList) {
                Log.d("RETROFIT", "cast " + r.name)
            }
        value = resultsList
    }
    val characters : LiveData<List<MarvelCharacter>> = _characters*/

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}