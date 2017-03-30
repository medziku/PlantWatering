package com.medziku.plantwatering;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.medziku.plantwatering.station.PlantStationDetailsFragment;
import com.medziku.plantwatering.station.PlantStationsFragment;
import com.medziku.plantwatering.station.PlantStation;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.menu_scrolling)
public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener,
        PlantStationDetailsFragment.OnFragmentInteractionListener,
        PlantStationsFragment.OnFragmentInteractionListener {

    @ViewById
    protected NavigationView navigationView;

    @ViewById(value = R.id.drawer_layout)
    protected DrawerLayout mDrawerLayout;

    private ActionBarDrawerToggle mDrawerToggle;

    @AfterViews
    protected void setUpNavigationView() {
        navigationView.setItemIconTintList(null);
        onNavigationItemSelected(navigationView.getMenu().getItem(0));
        navigationView.getMenu().getItem(0).setChecked(true);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void setActionBar(Toolbar toolbar) {
        if (null != mDrawerLayout && null != mDrawerToggle) {
            mDrawerLayout.removeDrawerListener(mDrawerToggle);
        }

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,
                R.string.drawer_open, R.string.drawer_close) {
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }
        };
        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerToggle.syncState();
        setSupportActionBar(toolbar);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        ActionBar supportActionBar = getSupportActionBar();
        if (null != supportActionBar) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setHomeButtonEnabled(true);
        }
    }

    @OptionsItem({R.id.action_settings})
    protected boolean menuSearch() {
        Toast.makeText(this, "No Settings Activity yet!", Toast.LENGTH_LONG).show();
        return true;
    }

    @OptionsItem({android.R.id.home})
    protected boolean toggleDrawer() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        //TODO sprawdzenie jaki fragmrnt jest obecnie. Jezeli klikniety jest obecny, nicnie rob.
        switch (item.getItemId()) {
            case R.id.nav_plant_stations:
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.fragment_placeholder, PlantStationsFragment.newInstance()).
                        commit();
                break;

            case R.id.nav_weather:
            case R.id.nav_history:
            case R.id.nav_tools:
            case R.id.nav_share:
            case R.id.nav_send:
            default:
                Toast.makeText(this, R.string.not_yet_implemented, Toast.LENGTH_SHORT).show();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {

        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
        } else {
            getSupportFragmentManager().popBackStack();
        }

    }

    @Override
    public void showNewPlantStation() {
        Toast.makeText(this, R.string.not_yet_implemented, Toast.LENGTH_SHORT).show();
        /*FragmentTransaction ft = this.getActivity().getSupportFragmentManager().beginTransaction();
        Fragment prev = this.getActivity().getSupportFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);
        BluetoothDevicePickFragment newFragment = BluetoothDevicePickFragment.newInstance();
        newFragment.show(ft, "dialog");*/
    }

    @Override
    public void showPlantStationDetails(PlantStation station) {
        getSupportFragmentManager().beginTransaction().
                replace(R.id.fragment_placeholder, PlantStationDetailsFragment.newInstance(station)).
                addToBackStack(PlantStationDetailsFragment.BACKSTACK_NAME).
                commit();
    }

    @Override
    public void showBtManagement() {
        Toast.makeText(this, R.string.not_yet_implemented, Toast.LENGTH_SHORT).show();
    }
}