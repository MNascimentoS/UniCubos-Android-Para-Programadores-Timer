package br.com.timer.scenes.presenter

import br.com.timer.R
import br.com.timer.scenes.Timezone
import br.com.timer.scenes.model.TimeZoneModel
import br.com.timer.services.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TimezonePresenter(private val view: Timezone.View) : Timezone.Presenter {
    override fun handleGetTimezone(timezone: String) {
        val call =
            ApiService().getService().handleGetTimezone(timezone)
        call.enqueue(object : Callback<TimeZoneModel> {
            override fun onFailure(call: Call<TimeZoneModel>, t: Throwable) {
                view.displayFailure(R.string.error_get_timezones)
            }
            override fun onResponse(call: Call<TimeZoneModel>, response: Response<TimeZoneModel>) {
                response.body()?.let {
                    view.displayTimezone(it)
                } ?: run {
                    view.displayFailure(R.string.error_get_timezones)
                }
            }
        })
    }

    override fun handleGetTimezones() {
        val call =
            ApiService().getService().handleGetTimezones()
        call.enqueue(object : Callback<List<String>> {
            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                view.displayFailure(R.string.error_get_timezones)
            }
            override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                val timezoneList = response.body()?.map {
                    TimeZoneModel(name = it)
                } ?: listOf()
                view.displayTimezones(timezoneList)
            }
        })
    }

}