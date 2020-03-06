package com.medziku.plantwatering.station

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.medziku.plantwatering.R

class PlantStationsAdapter(private val plantStations: List<PlantStation>, private val listener: PlantStationsFragment.OnFragmentInteractionListener?) : RecyclerView.Adapter<PlantStationsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent?.context)
                .inflate(R.layout.plant_stations_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        if (null != holder) {
            holder.nameView.text = plantStations[position].deviceName
            holder.mainView.setOnClickListener { _ -> listener?.showPlantStationDetails(plantStations[position]) } //FIXME listener noe powinien być przy każdym bindzie podmieniany
        }
    }

    override fun getItemCount(): Int {
        return plantStations.size
    }

    class ViewHolder internal constructor(internal val mainView: View) : RecyclerView.ViewHolder(mainView) {
        internal val nameView: TextView = mainView.findViewById(R.id.nameView) as TextView
    }

}