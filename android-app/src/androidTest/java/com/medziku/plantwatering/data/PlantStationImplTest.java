package com.medziku.plantwatering.data;

import android.os.Parcel;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import com.medziku.plantwatering.data.parts.AmperageSensorImpl;
import com.medziku.plantwatering.data.parts.PumpImpl;
import com.medziku.plantwatering.station.parts.AmperageSensor;
import com.medziku.plantwatering.station.parts.Pump;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class PlantStationImplTest {
    private static final String TEST_STRING_DEVICE_ID = "DeviceId";
    private static final String TEST_STRING_DEVICE_NAME = "DeviceName";
    private static final String TEST_STRING_BLUETOOTH_ADDRESS = "XX:YY:ZZ";
    private static final String TEST_STRING_OWNER_KEY = "abcd123";
//    private static final float TEST_FLOAT = 1234.5678f;

    @Test
    public void parcelableWriteRead() {
        //given
        PlantStationImpl testee = new PlantStationImpl(
                TEST_STRING_DEVICE_ID,
                TEST_STRING_DEVICE_NAME,
                TEST_STRING_BLUETOOTH_ADDRESS,
                TEST_STRING_OWNER_KEY);

        AmperageSensor amperageSensor = new AmperageSensorImpl("Amperage", 3.33f);
        Pump pump = new PumpImpl("Pump", 1, 33.2f);

        testee.addPlantStationPart(amperageSensor);
        testee.addPlantStationPart(pump);

        Parcel parcel = Parcel.obtain();
        testee.writeToParcel(parcel, testee.describeContents());
        parcel.setDataPosition(0);

        //when
        PlantStationImpl createdFromParcel = PlantStationImpl.Companion.getCREATOR().createFromParcel(parcel);

        //then
        assertThat(createdFromParcel.getDeviceId(), is(TEST_STRING_DEVICE_ID));
        assertThat(createdFromParcel.getDeviceName(), is(TEST_STRING_DEVICE_NAME));
        assertThat(createdFromParcel.getBluetoothAddress(), is(TEST_STRING_BLUETOOTH_ADDRESS));
        assertThat(createdFromParcel.getOwnerKey(), is(TEST_STRING_OWNER_KEY));

        assertThat(createdFromParcel.getPlantStationParts().size(), is(2));
    }
}