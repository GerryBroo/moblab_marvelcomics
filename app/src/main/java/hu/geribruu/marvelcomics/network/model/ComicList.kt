package hu.geribruu.marvelcomics.network.model

import com.google.gson.annotations.SerializedName

data class ComicList(
    @SerializedName("items")
    var items: List<ComicsSummary>
)