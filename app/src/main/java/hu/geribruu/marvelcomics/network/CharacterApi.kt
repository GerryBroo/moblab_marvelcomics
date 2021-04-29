package hu.geribruu.marvelcomics.network

import hu.geribruu.marvelcomics.network.model.CharacterDataWrapper
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApi {
    @GET("/v1/public/characters")
    fun loadCharacters(@Query("limit") limit : Int, @Query("offset") offset: Int) : Call<CharacterDataWrapper>

    @GET("/v1/public/characters/{characterId}")
    fun loadCharacter(@Path("characterId") id: String): Call<CharacterDataWrapper>
}