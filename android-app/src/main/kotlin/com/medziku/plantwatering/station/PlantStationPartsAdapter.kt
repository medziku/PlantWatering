package com.medziku.plantwatering.station

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.medziku.plantwatering.R
import com.medziku.plantwatering.station.parts.*

class PlantStationPartsAdapter(private val plantStationParts: List<PlantStationPart>) : RecyclerView.Adapter<PlantStationPartsAdapter.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_AMPERAGE_SENSOR: Int = 100
        private const val VIEW_TYPE_BATTERY_LEVEL_SENSOR: Int = 101
        private const val VIEW_TYPE_HUMIDITY_SENSOR: Int = 102
        private const val VIEW_TYPE_PUMP = 103
        private const val VIEW_TYPE_RAIN_SENSOR: Int = 104
        private const val VIEW_TYPE_SOIL_MOISTURE_SENSOR: Int = 105
        private const val VIEW_TYPE_SUNLIGHT_SENSOR: Int = 106
        private const val VIEW_TYPE_THERMOMETER = 107
        private const val VIEW_TYPE_TIMER: Int = 108
        private const val VIEW_TYPE_VOLTAGE_SENSOR: Int = 109
        private const val VIEW_TYPE_WATER_LEVEL_SENSOR: Int = 110
    }

    override fun getItemViewType(position: Int): Int {
        return when (plantStationParts[position]) {
            is AmperageSensor -> VIEW_TYPE_AMPERAGE_SENSOR
            is BatteryLevelSensor -> VIEW_TYPE_BATTERY_LEVEL_SENSOR
            is HumiditySensor -> VIEW_TYPE_HUMIDITY_SENSOR
            is Pump -> VIEW_TYPE_PUMP
            is RainSensor -> VIEW_TYPE_RAIN_SENSOR
            is SoilMoistureSensor -> VIEW_TYPE_SOIL_MOISTURE_SENSOR
            is SunlightSensor -> VIEW_TYPE_SUNLIGHT_SENSOR
            is Thermometer -> VIEW_TYPE_THERMOMETER
            is Timer -> VIEW_TYPE_TIMER
            is VoltageSensor -> VIEW_TYPE_VOLTAGE_SENSOR
            is WaterLevelSensor -> VIEW_TYPE_WATER_LEVEL_SENSOR
            else -> super.getItemViewType(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = when (viewType) {
            VIEW_TYPE_AMPERAGE_SENSOR,
            VIEW_TYPE_BATTERY_LEVEL_SENSOR,
            VIEW_TYPE_HUMIDITY_SENSOR,
            VIEW_TYPE_PUMP,
            VIEW_TYPE_RAIN_SENSOR,
            VIEW_TYPE_SOIL_MOISTURE_SENSOR,
            VIEW_TYPE_SUNLIGHT_SENSOR,
            VIEW_TYPE_THERMOMETER,
            VIEW_TYPE_TIMER,
            VIEW_TYPE_VOLTAGE_SENSOR,
            VIEW_TYPE_WATER_LEVEL_SENSOR -> LayoutInflater.from(parent?.context)
                    .inflate(R.layout.plant_stations_item, parent, false)
            else -> throw IllegalArgumentException()
        }
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.nameView?.text = plantStationParts[position].name
        holder?.mainView?.setOnClickListener { _ -> run { println("click") } }
    }

    override fun getItemCount(): Int {
        return plantStationParts.size
    }

    class ViewHolder internal constructor(internal val mainView: View) : RecyclerView.ViewHolder(mainView) {

        internal val nameView: TextView = mainView.findViewById(R.id.nameView) as TextView

    }

}