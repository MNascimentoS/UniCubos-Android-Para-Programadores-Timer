package br.com.timer

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_stopwatch.*

class StopwatchFragment : Fragment() {

    private var count = 0
    private var isOn = false
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_stopwatch, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
        initListeners()
    }

    private fun initUi() {
        valueTXT?.text = count.toString()
    }

    private fun initListeners() {
        executeBTN?.setOnClickListener {
            isOn = !isOn
            if (isOn) {
                updateTime()
                executeBTN?.text = getString(R.string.label_finish)
            } else {
                count = 0
                valueTXT?.text = count.toString()
                handler.removeCallbacks(runnable)
                executeBTN?.text = getString(R.string.label_init)
            }
        }
    }

    private fun updateTime() {
        handler = Handler()
        runnable = Runnable {
            count++
            valueTXT?.text = count.toString()
            updateTime()
        }
        handler.postDelayed(runnable, 1000)
    }

}