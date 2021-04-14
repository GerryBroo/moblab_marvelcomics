package hu.geribruu.marvelcomics.network.model

import com.google.gson.annotations.SerializedName

data class CharacterNet(
    @SerializedName("id")
    var id: Long,
    @SerializedName("name")
    var name: String,
    @SerializedName("description")
    var description: String,
  /*  @SerializedName("thumbnail")
    var thumbnail: Image?,*/
   /* @SerializedName("comics")
    var comicsList: List<ComicList>*/
)