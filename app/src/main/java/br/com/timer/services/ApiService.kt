package br.com.timer.services

import br.com.timer.repository.TimezoneRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ApiService {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://worldtimeapi.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getService() = retrofit.create(TimezoneRepository::class.java)

}