package `in`.nitin.supersub.model

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("_id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("subcategory")
    val subcategory: String,
    @SerializedName("illustrations")
    val illustrations: List<Illustrations>,
    @SerializedName("exercise")
    val exercise: Exercise,
    @SerializedName("video")
    val video: Video
)