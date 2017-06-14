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
public class TimerImplTest {
    private static final String TEST_STRING = "This is a string";
    private static final String TEST_TIME_STRING = "12:33:21";

    @Test
    public void parcelableWriteRead() {
        //given
        TimerImpl testee = new TimerImpl(TEST_STRING, TEST_TIME_STRING);
        Parcel parcel = Parcel.obtain();
        testee.writeToParcel(parcel, testee.describeContents());
        parcel.setDataPosition(0);

        //when
        TimerImpl createdFromParcel = TimerImpl.Companion.getCREATOR().createFromParcel(parcel);

        //then
        assertThat(createdFromParcel.getName(), is(TEST_STRING));
        assertThat(createdFromParcel.getTime(), is(TEST_TIME_STRING));
    }
}