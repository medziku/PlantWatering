package com.medziku.plantwatering.station;

import java.util.Collection;

public interface PlantStation {

    String getDeviceId();

    String getDeviceName();

    String getBluetoothAddress();

    String getOwnerKey();

    Collection<PlantStationPart> getPlantStationParts();

}
