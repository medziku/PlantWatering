package com.medziku.plantwatering.data.parts;

import android.os.Parcel;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class WaterLevelSensorImplTest {
    private static final String TEST_STRING = "This is a string";
    private static final float TEST_FLOAT = 1234.5678f;

    @Test
    public void parcelableWriteRead() {
        //given
        WaterLevelSensorImpl testee = new WaterLevelSensorImpl(TEST_STRING, TEST_FLOAT);
        Parcel parcel = Parcel.obtain();
        testee.writeToParcel(parcel, testee.describeContents());
        parcel.setDataPosition(0);

        //when
        WaterLevelSensorImpl createdFromParcel = WaterLevelSensorImpl.Companion.getCREATOR().createFromParcel(parcel);

        //then
        assertThat(createdFromParcel.getName(), is(TEST_STRING));
        assertThat(createdFromParcel.getWaterLevel(), is(TEST_FLOAT));
    }
}