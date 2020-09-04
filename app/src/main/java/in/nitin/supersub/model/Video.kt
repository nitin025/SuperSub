package `in`.nitin.supersub.model

import com.google.gson.annotations.SerializedName

data class Video(
    @SerializedName("_id")
    val id: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("thumbnail")
    val thumbnail: String
)