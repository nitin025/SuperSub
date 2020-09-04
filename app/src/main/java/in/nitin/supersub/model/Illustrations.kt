package `in`.nitin.supersub.model

import com.google.gson.annotations.SerializedName

data class Illustrations(
    @SerializedName("caption")
    val caption: String,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("description")
    val description: String
)