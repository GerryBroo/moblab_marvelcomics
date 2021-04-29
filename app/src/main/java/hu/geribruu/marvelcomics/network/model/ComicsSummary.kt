package hu.geribruu.marvelcomics.network.model

import com.google.gson.annotations.SerializedName

data class ComicsSummary(
    @SerializedName("name")
    var name: String,
)