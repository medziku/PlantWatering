package com.medziku.plantwatering.station

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import com.medziku.plantwatering.MainActivity_
import com.medziku.plantwatering.R
import com.medziku.plantwatering.mocks.PlantStationMocks
import org.androidannotations.annotations.AfterViews
import org.androidannotations.annotations.Click
import org.androidannotations.annotations.EFragment
import org.androidannotations.annotations.ViewById

@EFragment(R.layout.plant_stations_fragment)
open class PlantStationsFragment : Fragment() {

    private var listener: OnFragmentInteractionListener? = null

    @ViewById(R.id.toolbar)
    protected lateinit var toolbar: Toolbar

    @ViewById(R.id.listView)
    protected lateinit var listView: RecyclerView

    @Click(R.id.fab_add_new)
    protected fun fabDiscoverBtClicked() {
        listener?.showNewPlantStation()
    }

    @Click(R.id.fab_discover_bt)
    protected fun fabNewPlantStationClicked() {
        listener?.showBtManagement()
    }

    companion object {
        fun newInstance(): PlantStationsFragment {
            return PlantStationsFragment_()
        }
    }

    @AfterViews
    protected fun setUpToolbar() {
        (activity as MainActivity_).setActionBar(toolbar)
    }

    @AfterViews
    protected fun setUpListView() {
        val adapter = PlantStationsAdapter(PlantStationMocks.mockPlantStations(), listener)
        listView.setAdapter(adapter)
        listView.layoutManager = LinearLayoutManager(this.activity, LinearLayoutManager.VERTICAL, true)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        listener = null
        super.onDetach()
    }

    interface OnFragmentInteractionListener {
        fun showBtManagement()
        fun showNewPlantStation()
        fun showPlantStationDetails(plantStation: PlantStation)
    }

}