package com.medziku.plantwatering.bluetooth

import android.bluetooth.BluetoothDevice
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.medziku.plantwatering.R

class BluetoothDeviceAdapter(private val context: Context,
                             private val boundedList: ArrayList<BluetoothDevice> = ArrayList(),
                             private val availableList: ArrayList<BluetoothDevice> = ArrayList(),
                             private val deviceName: String,
                             private val deviceAddress: String) : BaseAdapter() {

    private val deviceSeparatorPosition = 0
    private var boundedDeviceSeparatorPosition = 0
    private var availableDeviceSeparatorPosition = 0

    private val deviceSeparatorText: String = context.resources.getString(R.string.my_device)
    private val boundedDeviceSeparatorText: String = context.resources.getString(R.string.bounded_devices)
    private val availableDeviceSeparatorText: String = context.resources.getString(R.string.available_devices)

    companion object {
        // View Type for Separators
        private const val ITEM_VIEW_TYPE_SEPARATOR = 0
        // View Type for Regular rows
        private const val ITEM_VIEW_TYPE_REGULAR = 1
        // Types of Views that need to be handled
        // -- Separators and Regular rows --
        private const val ITEM_VIEW_TYPE_COUNT = 2
    }

    override fun getCount(): Int {
        return 2 + (if (boundedList.size == 0) 0 else boundedList.size + 1) + (if (availableList.size == 0) 0 else availableList.size + 1)
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getViewTypeCount(): Int {
        return ITEM_VIEW_TYPE_COUNT
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == deviceSeparatorPosition
                || position == boundedDeviceSeparatorPosition
                || position == availableDeviceSeparatorPosition) {
            ITEM_VIEW_TYPE_SEPARATOR
        } else {
            ITEM_VIEW_TYPE_REGULAR
        }
    }

    override fun isEnabled(position: Int): Boolean {
        return position != deviceSeparatorPosition
                && position != boundedDeviceSeparatorPosition
                && position != availableDeviceSeparatorPosition
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val view: View
        val itemViewType = getItemViewType(position)
        view = if (convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            if (itemViewType == ITEM_VIEW_TYPE_SEPARATOR) { // If separator
                inflater.inflate(R.layout.device_section_header, null)
            } else { // Regular row
                inflater.inflate(R.layout.device_item, null)
            }
        } else {
            convertView
        }
        if (itemViewType == ITEM_VIEW_TYPE_SEPARATOR) { // If separator
            val separatorView = view.findViewById(R.id.separator) as TextView
            if (position == deviceSeparatorPosition) {
                separatorView.text = deviceSeparatorText
            } else if (position == boundedDeviceSeparatorPosition
                    && boundedDeviceSeparatorPosition != 0) {
                separatorView.text = boundedDeviceSeparatorText
            } else if (position == availableDeviceSeparatorPosition
                    && availableDeviceSeparatorPosition != 0) {
                separatorView.text = availableDeviceSeparatorText
            }
        } else { // If regular row
            val deviceNameView = view.findViewById(R.id.device_name) as TextView
            val deviceAddressView = view.findViewById(R.id.device_address) as TextView
            // Set device name and address values
            if (position == 1) {
                deviceNameView.text = deviceName
                deviceAddressView.text = deviceAddress
            } else {
                val device: BluetoothDevice
                var positionInList = position - 3
                if (positionInList < boundedList.size) device = boundedList[positionInList] else {
                    positionInList -= boundedList.size + 1
                    device = availableList[positionInList]
                }
                deviceNameView.text = device.name
                deviceAddressView.text = device.address
            }
        }
        return view
    }

    fun addBoundedDevice(device: BluetoothDevice) {
        boundedList.add(device)
        updateSeparatorPositions()
        this.notifyDataSetChanged()
    }

    fun addAvailableDevice(device: BluetoothDevice) {
        availableList.add(device)
        this.notifyDataSetChanged()
    }

    private fun updateSeparatorPositions() {
        boundedDeviceSeparatorPosition = if (boundedList.size == 0) 0 else 2
        availableDeviceSeparatorPosition = if (availableList.size == 0) 0 else boundedList.size + boundedDeviceSeparatorPosition
    }

}