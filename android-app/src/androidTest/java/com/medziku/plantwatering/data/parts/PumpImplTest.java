package com.medziku.plantwatering.data.parts;

import android.os.Parcel;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class PumpImplTest {
    private static final String TEST_STRING = "This is a string";
    private static final int TEST_INT = 12345678;
    private static final float TEST_FLOAT = 1234.5678f;

    @Test
    public void parcelableWriteRead() {
        //given
        PumpImpl testee = new PumpImpl(TEST_STRING, TEST_INT, TEST_FLOAT);
        Parcel parcel = Parcel.obtain();
        testee.writeToParcel(parcel, testee.describeContents());
        parcel.setDataPosition(0);

        //when
        PumpImpl createdFromParcel = PumpImpl.CREATOR.createFromParcel(parcel);

        //then
        assertThat(createdFromParcel.getName(), is(TEST_STRING));
        assertThat(createdFromParcel.getState(), is(TEST_INT));
        assertThat(createdFromParcel.getSpeed(), is(TEST_FLOAT));
    }
}