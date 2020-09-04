package `in`.nitin.supersub.model

import com.google.gson.annotations.SerializedName

data class Exercise(
    @SerializedName("restTime")
    val restTime: Int,
    @SerializedName("sets")
    val sets: Int,
    @SerializedName("reps")
    val reps: Int,
    @SerializedName("difficulty")
    val difficulty: String,
    @SerializedName("calories")
    val calories: Int,
    @SerializedName("increments")
    val increments: Increments
)