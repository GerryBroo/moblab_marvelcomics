package hu.geribruu.marvelcomics.network

import hu.geribruu.marvelcomics.network.model.CharacterDataWrapper
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApi {
    @GET("/v1/public/characters")
    fun getCharacters(@Query("limit") limit : Int, @Query("offset") offset: Int) : Call<CharacterDataWrapper>
}