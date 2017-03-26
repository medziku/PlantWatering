package com.medziku.plantwatering.station;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.medziku.plantwatering.MainActivity_;
import com.medziku.plantwatering.R;
import com.medziku.plantwatering.bluetooth.BluetoothDevicePickFragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.plant_stations_fragment)
public class PlantStationsFragment extends Fragment {

    @ViewById(R.id.toolbar)
    protected Toolbar toolbar;

    @ViewById(R.id.listView)
    protected RecyclerView listView;

    /*@Click(R.id.fab)
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
    }*/

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
        PlantStationsAdapter adapter = new PlantStationsAdapter();
        listView.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, true));
        listView.setAdapter(adapter);
    }

}