package br.com.unicubos.timercubos

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MainPagerAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragmentList = arrayListOf<Fragment>()
    private val titleList = arrayListOf<String>()

    init {
        titleList.add("Timer")
        titleList.add("Stopwatch")
        fragmentList.add(TimerFragment())
        fragmentList.add(StopWatchFragment())
    }

    override fun getCount(): Int = fragmentList.size

    override fun getItem(position: Int): Fragment = fragmentList[position]

    override fun getPageTitle(position: Int): CharSequence? = titleList[position]

}