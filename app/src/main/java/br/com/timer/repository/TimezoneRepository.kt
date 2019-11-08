package br.com.timer.repository

import br.com.timer.scenes.model.TimeZoneModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TimezoneRepository {

    @GET("api/timezone")
    fun handleGetTimezones() : Call<List<String>>

    @GET("api/timezone/{country}")
    fun handleGetTimezone(@Path("country") timezone: String) : Call<TimeZoneModel>

}