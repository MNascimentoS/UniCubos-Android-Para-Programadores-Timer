package br.com.timer

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class TimerPageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragmentTitleList = arrayListOf<String>()
    private val fragmentList = arrayListOf<Fragment>()

    init {
        fragmentTitleList.add("Time Zone")
        fragmentTitleList.add("Timer")
        fragmentTitleList.add("Stopwatch")
        fragmentList.add(TimezoneFragment())
        fragmentList.add(TimerFragment())
        fragmentList.add(StopwatchFragment())
    }

    override fun getItem(position: Int): Fragment = fragmentList[position]

    override fun getPageTitle(position: Int): CharSequence? = fragmentTitleList[position]

    override fun getCount(): Int = fragmentList.size

}