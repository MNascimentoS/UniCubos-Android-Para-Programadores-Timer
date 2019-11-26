package br.com.timer.scenes.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

data class TimeZoneModel(
    @SerializedName("timezone")
    val name: String,
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("utc_datetime")
    val timezone: Date = Date(),
    val time: Int = 0
) : Serializable