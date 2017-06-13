package com.medziku.plantwatering.station;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.medziku.plantwatering.MainActivity_;
import com.medziku.plantwatering.R;
import com.medziku.plantwatering.mocks.PlantStationMocks;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.plant_stations_fragment)
public class PlantStationsFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    @ViewById(R.id.toolbar)
    protected Toolbar toolbar;

    @ViewById(R.id.listView)
    protected RecyclerView listView;

    @Click(R.id.fab_discover_bt)
    void fabDiscoverBtClicked() {
        mListener.showNewPlantStation();
    }

    @Click(R.id.fab)
    void fabNewPlantStationClicked() {
        mListener.showNewPlantStation();
    }

    public PlantStationsFragment() {
        // Required empty public constructor
    }

    public static PlantStationsFragment newInstance() {
        return new PlantStationsFragment_();
    }

    @AfterViews
    public void setUpToolbar() {
        ((MainActivity_) getActivity()).setActionBar(toolbar);
    }

    @AfterViews
    public void setUpListView() {
        PlantStationsAdapter adapter = new PlantStationsAdapter(
                PlantStationMocks.mockPlantStations(),
                mListener);
        listView.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, true));
        listView.setAdapter(adapter);
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
        void showBtManagement();
        void showNewPlantStation();
        void showPlantStationDetails(PlantStation station);
    }

}