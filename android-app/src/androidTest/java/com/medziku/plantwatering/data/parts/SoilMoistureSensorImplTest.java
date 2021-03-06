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
public class SoilMoistureSensorImplTest {
    private static final String TEST_STRING = "This is a string";
    private static final float TEST_FLOAT = 1234.5678f;

    @Test
    public void parcelableWriteRead() {
        //given
        SoilMoistureSensorImpl testee = new SoilMoistureSensorImpl(TEST_STRING, TEST_FLOAT);
        Parcel parcel = Parcel.obtain();
        testee.writeToParcel(parcel, testee.describeContents());
        parcel.setDataPosition(0);

        //when
        SoilMoistureSensorImpl createdFromParcel = SoilMoistureSensorImpl.Companion.getCREATOR().createFromParcel(parcel);

        //then
        assertThat(createdFromParcel.getName(), is(TEST_STRING));
        assertThat(createdFromParcel.getSoilMoistureLevel(), is(TEST_FLOAT));
    }

}