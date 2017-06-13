package com.medziku.plantwatering.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.medziku.plantwatering.station.PlantStation;
import com.medziku.plantwatering.station.PlantStationPart;

import java.util.ArrayList;
import java.util.Collection;

public class PlantStationImpl implements PlantStation, Parcelable {

    private String mDeviceId;
    private String mDeviceName;
    private String mBluetoothAddress;
    private String mOwnerKey; // ma jakoś wskazywać (nie bezpośrednio) na id właściciela
    //może to być jakieś invitationId czy cuś, ale narazie nieistotne
    private Collection<PlantStationPart> mPlantStationPartCollection = new ArrayList<>();

    public PlantStationImpl(String deviceId, String deviceName, String bluetoothAddress, String ownerKey) {
        this.mDeviceId = deviceId;
        this.mDeviceName = deviceName;
        this.mBluetoothAddress = bluetoothAddress;
        this.mOwnerKey = ownerKey;
    }

    private PlantStationImpl(Parcel in) {
        mDeviceId = in.readString();
        mDeviceName = in.readString();
        mBluetoothAddress = in.readString();
        mOwnerKey = in.readString();
//        in.readParcelableArray()
//        mInfo = in.readParcelable(MySubParcelable.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mDeviceId);
        parcel.writeString(mDeviceName);
        parcel.writeString(mBluetoothAddress);
        parcel.writeString(mOwnerKey);
    }

    public static final Parcelable.Creator<PlantStationImpl> CREATOR
            = new Parcelable.Creator<PlantStationImpl>() {

        @Override
        public PlantStationImpl createFromParcel(Parcel in) {
            return new PlantStationImpl(in);
        }

        @Override
        public PlantStationImpl[] newArray(int size) {
            return new PlantStationImpl[size];
        }
    };

    @Override
    public String getDeviceId() {
        return mDeviceId;
    }

    public void setDeviceId(String deviceId) {
        this.mDeviceId = deviceId;
    }

    @Override
    public String getDeviceName() {
        return mDeviceName;
    }

    public void setDeviceName(String deviceName) {
        this.mDeviceName = deviceName;
    }

    @Override
    public String getBluetoothAddress() {
        return mBluetoothAddress;
    }

    public void setBluetoothAddress(String bluetoothAddress) {
        this.mBluetoothAddress = bluetoothAddress;
    }

    @Override
    public String getOwnerKey() {
        return mOwnerKey;
    }

    public void setOwnerKey(String ownerKey) {
        this.mOwnerKey = ownerKey;
    }

    @Override
    public Collection<PlantStationPart> getPlantStationParts() {
        return mPlantStationPartCollection;
    }

    public void addPlantStationPart(PlantStationPart part) {
        mPlantStationPartCollection.add(part);
    }

    public void removePlantStationPart(PlantStationPart part) {
        mPlantStationPartCollection.remove(part);
    }

    public boolean containsPlantStationPart(PlantStationPart part) {
        return mPlantStationPartCollection.contains(part);
    }
}
