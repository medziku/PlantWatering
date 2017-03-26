package com.medziku.plantwatering.station;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;

import com.medziku.plantwatering.MainActivity_;
import com.medziku.plantwatering.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.plant_station_details_fragment)
public class PlantStationDetailsFragment extends Fragment {

    @ViewById(R.id.toolbar)
    protected Toolbar toolbar;

    private OnFragmentInteractionListener mListener;

    public PlantStationDetailsFragment() {
        // Required empty public constructor
    }

    public static PlantStationDetailsFragment newInstance() {
        return new PlantStationDetailsFragment_();
    }

    @AfterViews
    protected void setUpToolbar() {
        ((MainActivity_) getActivity()).setActionBar(toolbar);
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
