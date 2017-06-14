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
public class AmperageSensorImplTest {
    private static final String TEST_STRING = "This is a string";
    private static final float TEST_FLOAT = 1234.5678f;

    @Test
    public void parcelableWriteRead() {
        //given
        AmperageSensorImpl testee = new AmperageSensorImpl(TEST_STRING, TEST_FLOAT);
        Parcel parcel = Parcel.obtain();
        testee.writeToParcel(parcel, testee.describeContents());
        parcel.setDataPosition(0);

        //when
        AmperageSensorImpl createdFromParcel = AmperageSensorImpl.CREATOR.createFromParcel(parcel);

        //then
        assertThat(createdFromParcel.getName(), is(TEST_STRING));
        assertThat(createdFromParcel.getAmperage(), is(TEST_FLOAT));
    }
}