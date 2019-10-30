package br.com.unicubos.timercubos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = MainPagerAdapter(supportFragmentManager)
        tablayout.setupWithViewPager(viewpager)
        viewpager.adapter = adapter
    }
}
