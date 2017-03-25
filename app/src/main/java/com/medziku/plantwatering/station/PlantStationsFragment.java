package com.medziku.plantwatering.station;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.medziku.plantwatering.R;
import com.medziku.plantwatering.bluetooth.BluetoothDevicePickFragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.plant_stations_fragment)
public class PlantStationsFragment extends Fragment {

    @ViewById(R.id.toolbar)
    Toolbar toolbar;

    @ViewById(R.id.listView)
    RecyclerView listView;

    @Click(R.id.fab)
    void fabClicked() {
        Toast.makeText(this.getActivity(), "DD", Toast.LENGTH_SHORT).show();
        FragmentTransaction ft = this.getActivity().getSupportFragmentManager().beginTransaction();
        Fragment prev = this.getActivity().getSupportFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);
        BluetoothDevicePickFragment newFragment = BluetoothDevicePickFragment.newInstance();
        newFragment.show(ft, "dialog");
    }

    public PlantStationsFragment() {
        // Required empty public constructor
    }

    public static PlantStationsFragment newInstance() {
        PlantStationsFragment_ fragment = new PlantStationsFragment_();
        return fragment;
    }

    @AfterViews
    public void setUpToolbar() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
    }

    @AfterViews
    public void setUpListView() {
        PlantStationsAdapter adapter = new PlantStationsAdapter();
        listView.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, true));
        listView.setAdapter(adapter);
    }

}