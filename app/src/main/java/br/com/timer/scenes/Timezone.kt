package br.com.timer.scenes

import br.com.timer.scenes.model.TimeZoneModel

interface Timezone {

    interface View {
        fun displayTimezones(timezoneList: List<TimeZoneModel>)
        fun displayTimezone(timezone: TimeZoneModel)
        fun displayFailure(error: Int)
    }

    interface Presenter {
        fun handleGetTimezones()
        fun handleGetTimezone(timezone: String)
    }

}