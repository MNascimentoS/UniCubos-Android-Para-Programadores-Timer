package br.com.timer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        NavigationUI.setupWithNavController(mainNav, navHostFragment.findNavController())
//
//        toolbar.title = getString(R.string.app_name)
//        tabLayout.setupWithViewPager(viewPager)
//        viewPager.adapter = TimerPageAdapter(supportFragmentManager)
    }
}
