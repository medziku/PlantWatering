package com.medziku.plantwatering.station

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import com.medziku.plantwatering.MainActivity_
import com.medziku.plantwatering.R
import org.androidannotations.annotations.AfterViews
import org.androidannotations.annotations.EFragment
import org.androidannotations.annotations.ViewById
import java.util.*

@EFragment(R.layout.plant_station_details_fragment)
open class PlantStationDetailsFragment : Fragment() {

    private var listener: OnFragmentInteractionListener? = null
    private var plantStation: PlantStation? = null

    @ViewById(R.id.toolbar)
    protected lateinit var toolbar: Toolbar

    @ViewById(R.id.partsRecyclerView)
    protected lateinit var recyclerPartsRecyclerView: RecyclerView

    companion object {
        const val ARG_PLANT_STATION = "ps"
        const val BACKSTACK_NAME = "psdf"

        fun newInstance(plantStation: PlantStation): PlantStationDetailsFragment {
            val fragment = PlantStationDetailsFragment_()
            if (plantStation is Parcelable) {
                val args = Bundle()
                args.putParcelable(ARG_PLANT_STATION, plantStation)
                fragment.arguments = args
            }
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            val parcelable: Parcelable? = arguments.getParcelable(ARG_PLANT_STATION)
            if (parcelable is PlantStation) {
                plantStation = parcelable
            }
        }
    }

    @AfterViews
    protected fun setUpToolbar() {
        (activity as MainActivity_).setActionBar(toolbar)
    }

    @AfterViews
    protected fun setUpStationPartRecyclerView() {
        val list: List<PlantStationPart> = if (plantStation?.plantStationParts is List<*>) {
            plantStation?.plantStationParts as List<PlantStationPart>
        } else {
            ArrayList<PlantStationPart>(plantStation?.plantStationParts)
        }
        val adapter = PlantStationPartsAdapter(list)
        recyclerPartsRecyclerView.adapter = adapter
        recyclerPartsRecyclerView.layoutManager = LinearLayoutManager(this.context)
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

    }

}