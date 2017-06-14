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
public class RainSensorImplTest {
    private static final String TEST_STRING = "This is a string";
    private static final boolean TEST_BOOLEAN = false;

    @Test
    public void parcelableWriteRead() {
        //given
        RainSensorImpl testee = new RainSensorImpl(TEST_STRING, TEST_BOOLEAN);
        Parcel parcel = Parcel.obtain();
        testee.writeToParcel(parcel, testee.describeContents());
        parcel.setDataPosition(0);

        //when
        RainSensorImpl createdFromParcel = RainSensorImpl.Companion.getCREATOR().createFromParcel(parcel);

        //then
        assertThat(createdFromParcel.getName(), is(TEST_STRING));
        assertThat(createdFromParcel.isRaining(), is(TEST_BOOLEAN));
    }
}