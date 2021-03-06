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
public class BatteryLevelSensorImplTest {
    private static final String TEST_STRING = "This is a string";
    private static final float[] TEST_FLOAT_ARRAY = new float[]{
            1234.5678f,
            2345.6789f,
            3456.7890f,
    };

    @Test
    public void parcelableWriteRead() {
        //given
        BatteryLevelSensorImpl testee = new BatteryLevelSensorImpl(TEST_STRING, TEST_FLOAT_ARRAY);
        Parcel parcel = Parcel.obtain();
        testee.writeToParcel(parcel, testee.describeContents());
        parcel.setDataPosition(0);

        //when
        BatteryLevelSensorImpl createdFromParcel = BatteryLevelSensorImpl.Companion.getCREATOR().createFromParcel(parcel);

        //then
        assertThat(createdFromParcel.getName(), is(TEST_STRING));
        assertThat(createdFromParcel.getCellCount(), is(TEST_FLOAT_ARRAY.length));
        assertThat(createdFromParcel.getBatteryLevels(), is(TEST_FLOAT_ARRAY));
    }
}