package com.medziku.plantwatering;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Set;

public class ScrollingActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private static final String TAG = ScrollingActivity.class.getName();

    private BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

    private FloatingActionButton btButton;

    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();

            if (action.equals(BluetoothAdapter.ACTION_STATE_CHANGED)) {
                final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR);
                updateUiOnBTStateChanged(state);
            } else if (BluetoothAdapter.ACTION_DISCOVERY_STARTED.equals(action)) {
                Log.d(TAG, "Discovery Started");
            } else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
                Log.d(TAG, "Discovery Finished");
            } else if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                // Bluetooth device found
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                Toast.makeText(getApplicationContext(),
                        "Found device " + device.getName(), Toast.LENGTH_SHORT)
                        .show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final BluetoothDeviceAdapter mBluetoothArrayAdapter = new BluetoothDeviceAdapter(this,
                mBluetoothAdapter.getName(),
                mBluetoothAdapter.getAddress());

        ListView modeList = new ListView(this);
        modeList.setAdapter(mBluetoothArrayAdapter);
        final AlertDialog alertDialog = new AlertDialog.Builder(this).
                setView(modeList).create();


        btButton = (FloatingActionButton) findViewById(R.id.fab);
        btButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "BT clicked");
                Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
                /*BluetoothDeviceAdapter mBluetoothArrayAdapter = new BluetoothDeviceAdapter(ScrollingActivity.this,
                        mBluetoothAdapter.getName(),
                        mBluetoothAdapter.getAddress());*/
                // If there are paired devices
                if (pairedDevices.size() > 0) {//TODO move to dialog display function
                    // Loop through paired devices
                    for (BluetoothDevice device : pairedDevices) {
                        // Add the name and address to an array adapter to show in a ListView
                        mBluetoothArrayAdapter.addBoundedDevice(device);
                    }
                }
                alertDialog.show();
            }
        });

        IntentFilter filter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
        // Add Bluetooth discovery actions to listen to
        filter.addAction(BluetoothDevice.ACTION_FOUND);
        filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
        filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        registerReceiver(mReceiver, filter);


        SwitchCompat engine1Button = (SwitchCompat) findViewById(R.id.eng01);
        engine1Button.setTag(1);
        engine1Button.setOnCheckedChangeListener(this);
        SwitchCompat engine2Button = (SwitchCompat) findViewById(R.id.eng02);
        engine2Button.setTag(2);
        engine2Button.setOnCheckedChangeListener(this);
        SwitchCompat engine3Button = (SwitchCompat) findViewById(R.id.eng03);
        engine3Button.setTag(3);
        engine3Button.setOnCheckedChangeListener(this);
        SwitchCompat engine4Button = (SwitchCompat) findViewById(R.id.eng04);
        engine4Button.setTag(4);
        engine4Button.setOnCheckedChangeListener(this);
        SwitchCompat engine5Button = (SwitchCompat) findViewById(R.id.eng05);
        engine5Button.setTag(5);
        engine5Button.setOnCheckedChangeListener(this);
        SwitchCompat engine6Button = (SwitchCompat) findViewById(R.id.eng06);
        engine6Button.setTag(6);
        engine6Button.setOnCheckedChangeListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateUiOnBTStateChanged(mBluetoothAdapter.getState());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int engine = (Integer) buttonView.getTag();

    }

    private void updateUiOnBTStateChanged(int state) {
        switch (state) {
            case BluetoothAdapter.STATE_OFF:
                setBluetoothButtonImage(getResources().
                        getDrawable(R.drawable.ic_bluetooth_disabled_black_24dp));
                break;
            case BluetoothAdapter.STATE_TURNING_OFF:
                setBluetoothButtonImage(getResources().
                        getDrawable(R.drawable.ic_bluetooth_disabled_black_24dp));
                break;
            case BluetoothAdapter.STATE_ON:
                setBluetoothButtonImage(getResources().
                        getDrawable(R.drawable.ic_bluetooth_black_24dp));
                break;
            case BluetoothAdapter.STATE_TURNING_ON:
                setBluetoothButtonImage(getResources().
                        getDrawable(R.drawable.ic_bluetooth_searching_black_24dp));
                break;
        }
    }

    private void setBluetoothButtonImage(Drawable drawable) {
        btButton.setImageDrawable(drawable);
    }
}
