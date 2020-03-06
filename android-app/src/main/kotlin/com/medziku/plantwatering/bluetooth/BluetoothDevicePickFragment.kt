package com.medziku.plantwatering.bluetooth

import android.app.Dialog
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import android.util.Log
import android.widget.ListView
import android.widget.Toast
import com.medziku.plantwatering.R

class BluetoothDevicePickFragment : DialogFragment() {

    companion object {
        private val TAG: String = BluetoothDevicePickFragment::class.java.name

        fun newInstance(): BluetoothDevicePickFragment {
            return BluetoothDevicePickFragment()
        }
    }

    private val bluetoothAdapter: BluetoothAdapter = BluetoothAdapter.getDefaultAdapter()

    private val broadcastReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            when (intent.action) {
                BluetoothAdapter.ACTION_STATE_CHANGED -> {
                    val state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR)
                    Log.d(TAG, "BT state changed to $state")
                    //updateUiOnBTStateChanged(state)
                }
                BluetoothAdapter.ACTION_DISCOVERY_STARTED -> {
                    Log.d(TAG, "Discovery Started")
                }
                BluetoothAdapter.ACTION_DISCOVERY_FINISHED -> {
                    Log.d(TAG, "Discovery Finished")
                }
                BluetoothDevice.ACTION_FOUND -> { // Bluetooth device found
                    val device: BluetoothDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE)
                    Toast.makeText(activity.applicationContext,
                            "Found device " + device.name, Toast.LENGTH_SHORT)
                            .show()
                }
            }
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val bluetoothDeviceAdapter = BluetoothDeviceAdapter(activity, deviceName = bluetoothAdapter.name, deviceAddress = bluetoothAdapter.address)
        val listViewCompat = ListView(activity)
        listViewCompat.adapter = bluetoothDeviceAdapter
        return AlertDialog.Builder(activity)
                .setIcon(R.drawable.caution)
                .setView(listViewCompat)
                .create()
    }

    override fun onStart() {
        super.onStart()
        val filter = IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED)
        filter.addAction(BluetoothDevice.ACTION_FOUND)
        filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED)
        filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED)
        activity.registerReceiver(broadcastReceiver, filter)

        val pairedDevices: Set<BluetoothDevice> = bluetoothAdapter.bondedDevices
        val mBluetoothArrayAdapter = BluetoothDeviceAdapter(activity,
                deviceName = bluetoothAdapter.name,
                deviceAddress = bluetoothAdapter.address)
        // If there are paired devices
        if (pairedDevices.isNotEmpty()) { //TODO move to dialog display function
            // Loop through paired devices
            for (device in pairedDevices) { // Add the name and address to an array adapter to show in a ListView
                mBluetoothArrayAdapter.addBoundedDevice(device)
            }
        }
    }

}