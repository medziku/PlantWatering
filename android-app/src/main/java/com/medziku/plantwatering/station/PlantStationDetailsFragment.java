package com.medziku.plantwatering.station;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.medziku.plantwatering.MainActivity_;
import com.medziku.plantwatering.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EFragment(R.layout.plant_station_details_fragment)
public class PlantStationDetailsFragment extends Fragment {

    public static final String BACKSTACK_NAME = "psdf";

    private static final String ARG_PLANT_STATION = "ps";

    @ViewById(R.id.toolbar)
    protected Toolbar toolbar;

    @ViewById(R.id.partsRecyclerView)
    protected RecyclerView recyclerPartsRecyclerView;

    private OnFragmentInteractionListener mListener;
    private PlantStation mPlantStation;

    public PlantStationDetailsFragment() {
        // Required empty public constructor
    }

    public static PlantStationDetailsFragment newInstance(PlantStation station) {
        PlantStationDetailsFragment_ fragment = new PlantStationDetailsFragment_();
        if (station instanceof Parcelable) {
            Bundle args = new Bundle();
            args.putParcelable(ARG_PLANT_STATION, (Parcelable) station);
            fragment.setArguments(args);
        }
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Parcelable parcelable = getArguments().getParcelable(ARG_PLANT_STATION);
            if (parcelable instanceof PlantStation) {
                mPlantStation = (PlantStation) parcelable;
            }
        }
    }

    @AfterViews
    protected void setUpToolbar() {
        ((MainActivity_) getActivity()).setActionBar(toolbar);
    }

    @AfterViews
    protected void setUpStationPartRecyclerView() {
        List<PlantStationPart> list;
        if (mPlantStation.getPlantStationParts() instanceof List) {
            list = (List) mPlantStation.getPlantStationParts();
        } else {
            list = new ArrayList<>(mPlantStation.getPlantStationParts());
        }
        PlantStationPartsAdapter adapter = new PlantStationPartsAdapter(list);
        recyclerPartsRecyclerView.setAdapter(adapter);
        recyclerPartsRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        mListener = null;
        super.onDetach();
    }

    public interface OnFragmentInteractionListener {
    }
}
