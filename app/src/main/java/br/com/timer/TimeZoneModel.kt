package br.com.timer

data class TimeZoneModel(
    val name: String,
    val timezone: String,
    val time: Int = 0
)