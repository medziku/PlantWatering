package com.medziku.plantwatering;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.medziku.plantwatering.station.PlantStationDetailsFragment;
import com.medziku.plantwatering.station.PlantStationsFragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.menu_scrolling)
public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener,
        PlantStationDetailsFragment.OnFragmentInteractionListener {

    @ViewById
    FloatingActionButton fab;

    @ViewById
    NavigationView navigationView;

    @AfterViews
    protected void setUpNavigationView() {
        navigationView.setItemIconTintList(null);
        onNavigationItemSelected(navigationView.getMenu().getItem(0));
        navigationView.getMenu().getItem(0).setChecked(true);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @OptionsItem({R.id.action_settings})
    boolean menuSearch() {
        Toast.makeText(this, "No Settings Activity yet!", Toast.LENGTH_LONG).show();
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
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.fragment_placeholder, PlantStationDetailsFragment.newInstance()).
                        commit();
                break;

            case R.id.nav_history:
            case R.id.nav_tools:
            case R.id.nav_share:
            case R.id.nav_send:
            default:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}