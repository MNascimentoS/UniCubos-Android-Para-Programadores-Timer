package br.com.timer

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ActivityNavigator
import androidx.navigation.navArgs
import kotlinx.android.synthetic.main.activity_detail.*
import java.text.SimpleDateFormat

class TimeZoneDetailsActivity: AppCompatActivity() {

    val args: TimeZoneDetailsActivityArgs by navArgs()
    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val timezone = args.timezone
        titleTXT.text = timezone.name
        abbreviationTXT.text = timezone.abbreviation
        dateTXT.text = SimpleDateFormat("dd/MM/yy HH:mm").format(timezone.timezone)
    }

    override fun finish() {
        super.finish()
        ActivityNavigator.applyPopAnimationsToPendingTransition(this)
    }

}