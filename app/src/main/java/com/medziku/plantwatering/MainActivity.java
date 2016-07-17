package com.medziku.plantwatering;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener,
        PlantStationDetailsFragment.OnFragmentInteractionListener {
    private static final String TAG = MainActivity.class.getName();

    private FloatingActionButton btButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btButton = (FloatingActionButton) findViewById(R.id.fab); //TODO zamienić bibliotekę na menu fab

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        onNavigationItemSelected(navigationView.getMenu().getItem(0));
        navigationView.getMenu().getItem(0).setChecked(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return item.getItemId() == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
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