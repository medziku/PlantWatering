package com.medziku.plantwatering.station;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.medziku.plantwatering.R;
import com.medziku.plantwatering.station.parts.AmperageSensor;
import com.medziku.plantwatering.station.parts.BatteryLevelSensor;
import com.medziku.plantwatering.station.parts.HumiditySensor;
import com.medziku.plantwatering.station.parts.Pump;
import com.medziku.plantwatering.station.parts.RainSensor;
import com.medziku.plantwatering.station.parts.SoilMoistureSensor;
import com.medziku.plantwatering.station.parts.SunlightSensor;
import com.medziku.plantwatering.station.parts.Thermometer;
import com.medziku.plantwatering.station.parts.Timer;
import com.medziku.plantwatering.station.parts.VoltageSensor;
import com.medziku.plantwatering.station.parts.WaterLevelSensor;

import java.util.List;

public class PlantStationPartsAdapter extends RecyclerView.Adapter<PlantStationPartsAdapter.ViewHolder> {

    private static final int VIEW_TYPE_AMPERAGE_SENSOR = 100;
    private static final int VIEW_TYPE_BATTERY_LEVEL_SENSOR = 101;
    private static final int VIEW_TYPE_HUMIDITY_SENSOR = 102;
    private static final int VIEW_TYPE_PUMP = 103;
    private static final int VIEW_TYPE_RAIN_SENSOR = 104;
    private static final int VIEW_TYPE_SOIL_MOISTURE_SENSOR = 105;
    private static final int VIEW_TYPE_SUNLIGHT_SENSOR = 106;
    private static final int VIEW_TYPE_THERMOMETER = 107;
    private static final int VIEW_TYPE_TIMER = 108;
    private static final int VIEW_TYPE_VOLTAGE_SENSOR = 109;
    private static final int VIEW_TYPE_WATER_LEVEL_SENSOR = 110;

    private final List<PlantStationPart> mPlantStationParts;

    public PlantStationPartsAdapter(List<PlantStationPart> plantStationParts) {
        this.mPlantStationParts = plantStationParts;
    }

    @Override
    public int getItemViewType(int position) {
        PlantStationPart part = mPlantStationParts.get(position);
        if (part instanceof AmperageSensor) {
            return VIEW_TYPE_AMPERAGE_SENSOR;
        } else if (part instanceof BatteryLevelSensor) {
            return VIEW_TYPE_BATTERY_LEVEL_SENSOR;
        } else if (part instanceof HumiditySensor) {
            return VIEW_TYPE_HUMIDITY_SENSOR;
        } else if (part instanceof Pump) {
            return VIEW_TYPE_PUMP;
        } else if (part instanceof RainSensor) {
            return VIEW_TYPE_RAIN_SENSOR;
        } else if (part instanceof SoilMoistureSensor) {
            return VIEW_TYPE_SOIL_MOISTURE_SENSOR;
        } else if (part instanceof SunlightSensor) {
            return VIEW_TYPE_SUNLIGHT_SENSOR;
        } else if (part instanceof Thermometer) {
            return VIEW_TYPE_THERMOMETER;
        } else if (part instanceof Timer) {
            return VIEW_TYPE_TIMER;
        } else if (part instanceof VoltageSensor) {
            return VIEW_TYPE_VOLTAGE_SENSOR;
        } else if (part instanceof WaterLevelSensor) {
            return VIEW_TYPE_WATER_LEVEL_SENSOR;
        } else {
            return super.getItemViewType(position);
        }
    }

    @Override
    public PlantStationPartsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        switch (viewType) {
            case VIEW_TYPE_AMPERAGE_SENSOR:
            case VIEW_TYPE_BATTERY_LEVEL_SENSOR:
            case VIEW_TYPE_HUMIDITY_SENSOR:
            case VIEW_TYPE_PUMP:
            case VIEW_TYPE_RAIN_SENSOR:
            case VIEW_TYPE_SOIL_MOISTURE_SENSOR:
            case VIEW_TYPE_SUNLIGHT_SENSOR:
            case VIEW_TYPE_THERMOMETER:
            case VIEW_TYPE_TIMER:
            case VIEW_TYPE_VOLTAGE_SENSOR:
            case VIEW_TYPE_WATER_LEVEL_SENSOR:

                v = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.plant_stations_item, parent, false);
                break;
            default:
                throw new IllegalArgumentException();
        }
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final int pos = position;
        holder.mNameView.setText(mPlantStationParts.get(position).getName());
        holder.mMainView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPlantStationParts.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        private View mMainView;
        private TextView mNameView;

        private ViewHolder(View v) {
            super(v);
            mMainView = v;
            mNameView = (TextView) v.findViewById(R.id.nameView);
        }
    }
}
