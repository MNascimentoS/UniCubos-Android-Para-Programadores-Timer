package br.com.timer.scenes.view


import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.timer.R
import br.com.timer.scenes.Timezone
import br.com.timer.scenes.model.TimeZoneModel
import br.com.timer.scenes.presenter.TimezonePresenter
import kotlinx.android.synthetic.main.fragment_timezone.*
import java.text.SimpleDateFormat

/**
 * A simple [Fragment] subclass.
 */
class TimezoneFragment : Fragment(), Timezone.View {

    private lateinit var adapter: TimeZoneRecyclerAdapter
    private val presenter: TimezonePresenter by lazy {
        TimezonePresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_timezone, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = TimeZoneRecyclerAdapter(arrayListOf()) {
            presenter.handleGetTimezone(it)
        }

        recyclerView?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView?.adapter = adapter

        presenter.handleGetTimezones()
    }

    override fun displayTimezones(timezoneList: List<TimeZoneModel>) {
        adapter.addMoreItems(timezoneList)
    }

    @SuppressLint("SimpleDateFormat")
    override fun displayTimezone(timezone: TimeZoneModel) {
        val action = TimezoneFragmentDirections.actionTimezoneToTimeZoneDetailsActivity(timezone)
        findNavController().navigate(action)
    }

    override fun displayFailure(error: Int) {
        Toast.makeText(context, getString(error), Toast.LENGTH_LONG).show()
    }

}
