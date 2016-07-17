package com.medziku.plantwatering;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PlantStationsAdapter extends RecyclerView.Adapter<PlantStationsAdapter.ViewHolder> {

    private static String[] testArray =
            new String[]{"AAAA", "BBBB", "CCCC",
                    "DDDD", "EEEE", "FFFF", "GGGG",
                    "HHHH", "IIII", "JJJJ"};

    public PlantStationsAdapter() {
    }

    @Override
    public PlantStationsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.plant_stations_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(testArray[position]);

    }

    @Override
    public int getItemCount() {
        return testArray.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;

        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.textView);
        }
    }
}
