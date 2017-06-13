package com.medziku.plantwatering.bluetooth;

import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.medziku.plantwatering.R;

import java.util.Set;

public class BluetoothDevicePickFragment extends DialogFragment {
    private static final String TAG = BluetoothDevicePickFragment.class.getName();

    private BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();

            if (action.equals(BluetoothAdapter.ACTION_STATE_CHANGED)) {
                final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR);
//                updateUiOnBTStateChanged(state);
            } else if (BluetoothAdapter.ACTION_DISCOVERY_STARTED.equals(action)) {
                Log.d(TAG, "Discovery Started");
            } else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
                Log.d(TAG, "Discovery Finished");
            } else if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                // Bluetooth device found
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                Toast.makeText(getActivity().getApplicationContext(),
                        "Found device " + device.getName(), Toast.LENGTH_SHORT)
                        .show();
            }
        }
    };

    public static BluetoothDevicePickFragment newInstance() {
        BluetoothDevicePickFragment frag = new BluetoothDevicePickFragment();
        return frag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final BluetoothDeviceAdapter mBluetoothArrayAdapter = new BluetoothDeviceAdapter(this.getActivity(),
                mBluetoothAdapter.getName(),
                mBluetoothAdapter.getAddress());

        ListView modeList = new ListView(this.getActivity());
        modeList.setAdapter(mBluetoothArrayAdapter);

        return new AlertDialog.Builder(getActivity())
                .setIcon(R.drawable.caution)
                .setView(modeList)
                .create();
    }

    @Override
    public void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
        filter.addAction(BluetoothDevice.ACTION_FOUND);
        filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
        filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        getActivity().registerReceiver(mReceiver, filter);

        Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
        BluetoothDeviceAdapter mBluetoothArrayAdapter = new BluetoothDeviceAdapter(getActivity(),
                mBluetoothAdapter.getName(),
                mBluetoothAdapter.getAddress());
        // If there are paired devices
        if (pairedDevices.size() > 0) {//TODO move to dialog display function
            // Loop through paired devices
            for (BluetoothDevice device : pairedDevices) {
                // Add the name and address to an array adapter to show in a ListView
                mBluetoothArrayAdapter.addBoundedDevice(device);
            }
        }
    }


}
