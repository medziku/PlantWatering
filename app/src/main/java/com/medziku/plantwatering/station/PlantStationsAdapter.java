package com.medziku.plantwatering.station;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.medziku.plantwatering.R;

import java.util.List;

public class PlantStationsAdapter extends RecyclerView.Adapter<PlantStationsAdapter.ViewHolder> {

    private final List<PlantStation> mPlantStations;
    private final PlantStationsFragment.OnFragmentInteractionListener mListener;

    public PlantStationsAdapter(List<PlantStation> plantStations, PlantStationsFragment.OnFragmentInteractionListener listener) {
        this.mPlantStations = plantStations;
        this.mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.plant_stations_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final int pos = position;
        holder.mNameView.setText(mPlantStations.get(position).getDeviceName());
        holder.mMainView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.showPlantStationDetails(mPlantStations.get(pos));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPlantStations.size();
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
