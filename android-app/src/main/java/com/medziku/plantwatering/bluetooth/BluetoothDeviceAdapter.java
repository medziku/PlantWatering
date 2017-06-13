package com.medziku.plantwatering.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.medziku.plantwatering.R;

import java.util.ArrayList;

public class BluetoothDeviceAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<BluetoothDevice> mBoundedList;
    private ArrayList<BluetoothDevice> mAvailableList;

    private int mMyDeviceSeparatorPosition = 0;
    private int mBoundedDeviceSeparatorPosition = 0;
    private int mAvailableDeviceSeparatorPosition = 0;

    private String mMyDeviceSeparatorText, mBoundedDeviceSeparatorText,
            mAvailableDeviceSeparatorText;
    private String mDeviceName, mDeviceAddress;

    // View Type for Separators
    private static final int ITEM_VIEW_TYPE_SEPARATOR = 0;
    // View Type for Regular rows
    private static final int ITEM_VIEW_TYPE_REGULAR = 1;
    // Types of Views that need to be handled
    // -- Separators and Regular rows --
    private static final int ITEM_VIEW_TYPE_COUNT = 2;

    /**
     * Default log tag for this class.
     */
    private final String LOG_TAG = BluetoothDeviceAdapter.class.getSimpleName();

    public BluetoothDeviceAdapter(Context context, ArrayList<BluetoothDevice> boundedList,
                                  ArrayList<BluetoothDevice> availableList, String deviceName,
                                  String deviceAddress) {
        mContext = context;

        // Set array lists for bounded and available bluetooth devices
        mBoundedList = boundedList;
        mAvailableList = availableList;

        //Set section separator names
        mMyDeviceSeparatorText = context.getResources().
                getString(R.string.my_device);
        mBoundedDeviceSeparatorText = context.getResources().
                getString(R.string.bounded_devices);
        mAvailableDeviceSeparatorText = context.getResources().
                getString(R.string.available_devices);

        // Set this device bluetooth info
        mDeviceName = deviceName;
        mDeviceAddress = deviceAddress;
    }

    public BluetoothDeviceAdapter(Context context, String deviceName,
                                  String deviceAddress) {
        // Create with empty devices lists
        this(context, new ArrayList<BluetoothDevice>(),
                new ArrayList<BluetoothDevice>(), deviceName, deviceAddress);
    }

    @Override
    public int getCount() {

        // Calculate count. For each non empty device list add one for header.
        // Otherwise skip
        return 2 + (mBoundedList.size() == 0 ? 0 : (mBoundedList.size() + 1))
                + (mAvailableList.size() == 0 ? 0 : (mAvailableList.size() + 1));
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return ITEM_VIEW_TYPE_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == mMyDeviceSeparatorPosition
                || position == mBoundedDeviceSeparatorPosition
                || position == mAvailableDeviceSeparatorPosition) {
            // If separator
            return ITEM_VIEW_TYPE_SEPARATOR;
        } else {
            // Regular row
            return ITEM_VIEW_TYPE_REGULAR;
        }
    }

    @Override
    public boolean isEnabled(int position) {
        // Disabled if separator
        return position != mMyDeviceSeparatorPosition
                && position != mBoundedDeviceSeparatorPosition
                && position != mAvailableDeviceSeparatorPosition;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        int itemViewType = getItemViewType(position);

        if (convertView == null) {
            LayoutInflater inflater =(LayoutInflater) mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if (itemViewType == ITEM_VIEW_TYPE_SEPARATOR) {
                // If separator
                view = inflater.inflate(R.layout.device_section_header, null);
            } else {
                // Regular row
                view = inflater.inflate(R.layout.device_item, null);
            }
        } else {
            view = convertView;
        }

        if (itemViewType == ITEM_VIEW_TYPE_SEPARATOR) {
            // If separator

            TextView separatorView = (TextView) view.findViewById(R.id.separator);
            if(position == mMyDeviceSeparatorPosition){
                separatorView.setText(mMyDeviceSeparatorText);
            }
            else if(position == mBoundedDeviceSeparatorPosition
                    && mBoundedDeviceSeparatorPosition != 0){
                separatorView.setText(mBoundedDeviceSeparatorText);
            }
            else if(position == mAvailableDeviceSeparatorPosition
                    && mAvailableDeviceSeparatorPosition != 0){
                separatorView.setText(mAvailableDeviceSeparatorText);
            }
        } else {
            // If regular row

            TextView deviceNameView = (TextView) view.findViewById(R.id.device_name);
            TextView deviceAddressView = (TextView) view.findViewById(R.id.device_address);

            // Set device name and address values
            if(position == 1){
                deviceNameView.setText(mDeviceName);
                deviceAddressView.setText(mDeviceAddress);
            }
            else {
                BluetoothDevice device;
                int positionInList = position - 3;
                if(positionInList < mBoundedList.size())
                    device = mBoundedList.get(positionInList);
                else{
                    positionInList -= mBoundedList.size() +1;
                    device = mAvailableList.get(positionInList);
                }

                deviceNameView.setText(device.getName());
                deviceAddressView.setText(device.getAddress());
            }
        }

        return view;
    }

    /**
     * Add new device to bounded devices list.
     * @param device new bluetooth device.
     */
    public void addBoundedDevice(BluetoothDevice device) {
        mBoundedList.add(device);
        updateSeparatorPositions();
        this.notifyDataSetChanged();
    }

    /**
     * Add new device to available devices list.
     * @param device new bluetooth device.
     */
    public void addAvailableDevice(BluetoothDevice device) {
        mAvailableList.add(device);
        this.notifyDataSetChanged();
    }

    /**
     * Recalculate separator positions
     */
    private void updateSeparatorPositions() {
        mBoundedDeviceSeparatorPosition = mBoundedList.size() == 0 ? 0 : 2;
        mAvailableDeviceSeparatorPosition = mAvailableList.size() == 0 ? 0 : mBoundedList.size()
                + mBoundedDeviceSeparatorPosition;
    }
}
