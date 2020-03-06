package com.medziku.plantwatering

import android.bluetooth.BluetoothAdapter
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.medziku.plantwatering.bluetooth.BluetoothDevicePickFragment
import com.medziku.plantwatering.station.PlantStation
import com.medziku.plantwatering.station.PlantStationDetailsFragment
import com.medziku.plantwatering.station.PlantStationsFragment
import org.androidannotations.annotations.*

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.menu_scrolling)
open class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,
        PlantStationDetailsFragment.OnFragmentInteractionListener,
        PlantStationsFragment.OnFragmentInteractionListener {

    @ViewById
    protected lateinit var navigationView: NavigationView

    @ViewById(value = R.id.drawer_layout)
    protected lateinit var mDrawerLayout: DrawerLayout

    private var mDrawerToggle: ActionBarDrawerToggle? = null

    @AfterViews
    protected fun setUpNavigationView() {
        navigationView.itemIconTintList = null
        val item: MenuItem? = navigationView.menu?.getItem(0)
        if (null != item) {
            onNavigationItemSelected(item)
            item.isChecked = true
        }
        navigationView.setNavigationItemSelectedListener(this)
    }

    fun setActionBar(toolbar: Toolbar) {
        if (null != mDrawerToggle) {
            mDrawerLayout.removeDrawerListener(mDrawerToggle ?: return)
        }

        mDrawerToggle = object : ActionBarDrawerToggle(this, mDrawerLayout, toolbar,
                R.string.drawer_open, R.string.drawer_close) {
            override fun onDrawerClosed(view: View) {
                super.onDrawerClosed(view)
                invalidateOptionsMenu()
            }

            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
                invalidateOptionsMenu()
            }
        }
        mDrawerToggle?.isDrawerIndicatorEnabled = true
        mDrawerToggle?.syncState()
        setSupportActionBar(toolbar)
        mDrawerToggle.let {
            mDrawerLayout.addDrawerListener(it as DrawerLayout.DrawerListener)
        }
        val supportActionBar: android.support.v7.app.ActionBar? = getSupportActionBar()
        if (null != supportActionBar) {
            supportActionBar.setDisplayHomeAsUpEnabled(true)
            supportActionBar.setHomeButtonEnabled(true)
        }
    }

    @OptionsItem(R.id.action_settings)
    protected fun menuSearch(): Boolean {
        Toast.makeText(this, "No Settings Activity yet!", Toast.LENGTH_LONG).show()
        return true
    }

    @OptionsItem(android.R.id.home)
    protected fun toggleDrawer(): Boolean {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START)
        } else {
            mDrawerLayout.openDrawer(GravityCompat.START)
        }
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_plant_stations -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_placeholder, PlantStationsFragment.newInstance())
                        .commit()
            }
            else -> Toast.makeText(this, R.string.not_yet_implemented, Toast.LENGTH_SHORT).show()
        }
        val drawer: DrawerLayout = findViewById(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        val count = supportFragmentManager.backStackEntryCount
        if (0 == count) {
            super.onBackPressed()
        } else {
            supportFragmentManager.popBackStack()
        }
    }

    override fun showBtManagement() {
        if (null == BluetoothAdapter.getDefaultAdapter()) {
            Toast.makeText(this, "Bluetooth not supported on this device", Toast.LENGTH_LONG).show()
        } else {
            val ft: FragmentTransaction = this.supportFragmentManager.beginTransaction()
            val prev: Fragment? = this.supportFragmentManager.findFragmentByTag("dialog")
            if (prev != null) {
                ft.remove(prev)
            }
            ft.addToBackStack(null)
            val newFragment: BluetoothDevicePickFragment = BluetoothDevicePickFragment.newInstance()
            newFragment.show(ft, "dialog")
        }
    }

    override fun showNewPlantStation() {
        Toast.makeText(this, R.string.not_yet_implemented, Toast.LENGTH_SHORT).show()
    }

    override fun showPlantStationDetails(plantStation: PlantStation) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_placeholder, PlantStationDetailsFragment.newInstance(plantStation)).addToBackStack(PlantStationDetailsFragment.BACKSTACK_NAME).commit()
    }
}