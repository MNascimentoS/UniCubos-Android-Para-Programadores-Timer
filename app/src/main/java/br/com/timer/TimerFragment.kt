package br.com.timer

import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_timer.*

class TimerFragment : Fragment() {

    private var count = 0
    private var isOn = false
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_timer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        executeBTN?.setOnClickListener {
            if (!isValid()) return@setOnClickListener

            isOn = !isOn
            if (isOn) {
                count = ((hourEDT?.text?.toString()?.toInt() ?: 0 * 3600000)
                    + (minuteEDT?.text?.toString()?.toInt() ?: 0 * 60000)
                    + (secondEDT?.text?.toString()?.toInt() ?: 0 * 1000))
                constraintLayout?.visibility = View.GONE
                valueTXT?.visibility = View.VISIBLE
                executeBTN?.text = getString(R.string.label_finish)
                updateTime()
            } else {
                count = 0
                constraintLayout?.visibility = View.VISIBLE
                valueTXT?.visibility = View.GONE
                handler.removeCallbacks(runnable)
                executeBTN?.text = getString(R.string.label_init)
            }
        }
        hourEDT?.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (!text.isNullOrBlank() && text.toString().toInt() > MAX_HOURS) {
                    hourEDT?.setText(MAX_HOURS.toString())
                    hourEDT?.setSelection(hourEDT.text.toString().count())
                }
            }
        })
        minuteEDT?.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (!text.isNullOrBlank() && text.toString().toInt() > MAX_MINUTES) {
                    minuteEDT?.setText(MAX_MINUTES.toString())
                    minuteEDT?.setSelection(minuteEDT.text.toString().count())
                }
            }
        })
        secondEDT?.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (!text.isNullOrBlank() && text.toString().toInt() > MAX_SECONDS) {
                    secondEDT?.setText(MAX_SECONDS.toString())
                    secondEDT?.setSelection(secondEDT.text.toString().count())
                }
            }
        })
    }

    private fun isValid() : Boolean {
        return (!hourEDT?.text.isNullOrBlank() &&
                !minuteEDT?.text.isNullOrBlank() &&
                !secondEDT?.text.isNullOrBlank())
    }

    private fun updateTime() {
        handler = Handler()
        runnable = Runnable {
            count--
            if (count >= 0) {
                valueTXT?.text = count.toString()
                updateTime()
            }
        }
        handler.postDelayed(runnable, 1000)
    }


    companion object {
        const val MAX_HOURS = 23
        const val MAX_MINUTES = 59
        const val MAX_SECONDS = 59
    }

}