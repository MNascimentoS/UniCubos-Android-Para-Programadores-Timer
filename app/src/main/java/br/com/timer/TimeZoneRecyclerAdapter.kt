package br.com.timer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_time_zone.view.*

class TimeZoneRecyclerAdapter(private val timeZoneList: ArrayList<TimeZoneModel>) : RecyclerView.Adapter<TimeZoneRecyclerAdapter.TimeZoneViewHolder>() {

    override fun getItemCount(): Int = timeZoneList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeZoneViewHolder {
        return TimeZoneViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_time_zone, parent, false))
    }

    override fun onBindViewHolder(holder: TimeZoneViewHolder, position: Int) {
        with(holder.itemView) {
            countryTXT?.text = timeZoneList[position].name
            timezoneTXT?.text = ("${timeZoneList[position].timezone}${timeZoneList[position].time}")
        }
    }

    fun addMoreItems(list: ArrayList<TimeZoneModel>) {
        timeZoneList.addAll(list)
        notifyDataSetChanged()
    }

    inner class TimeZoneViewHolder(view: View) : RecyclerView.ViewHolder(view)
}