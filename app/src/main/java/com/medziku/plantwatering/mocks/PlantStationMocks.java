package com.medziku.plantwatering.mocks;


import com.medziku.plantwatering.data.PlantStationImpl;
import com.medziku.plantwatering.data.parts.AmperageSensorImpl;
import com.medziku.plantwatering.data.parts.BatteryLevelSensorImpl;
import com.medziku.plantwatering.data.parts.HumiditySensorImpl;
import com.medziku.plantwatering.data.parts.PumpImpl;
import com.medziku.plantwatering.data.parts.RainSensorImpl;
import com.medziku.plantwatering.data.parts.SoilMoistureSensorImpl;
import com.medziku.plantwatering.data.parts.SunlightSensorImpl;
import com.medziku.plantwatering.data.parts.ThermometerImpl;
import com.medziku.plantwatering.data.parts.TimerImpl;
import com.medziku.plantwatering.data.parts.VoltageSensorImpl;
import com.medziku.plantwatering.data.parts.WaterLevelSensorImpl;
import com.medziku.plantwatering.station.PlantStation;
import com.medziku.plantwatering.station.parts.AmperageSensor;
import com.medziku.plantwatering.station.parts.BatteryLevelSensor;
import com.medziku.plantwatering.station.parts.HumiditySensor;
import com.medziku.plantwatering.station.parts.Pump;
import com.medziku.plantwatering.station.parts.RainSensor;
import com.medziku.plantwatering.station.parts.SoilMoistureSensor;
import com.medziku.plantwatering.station.parts.SunlightSensor;
import com.medziku.plantwatering.station.parts.Thermometer;
import com.medziku.plantwatering.station.parts.Timer;
import com.medziku.plantwatering.station.parts.VoltageSensor;
import com.medziku.plantwatering.station.parts.WaterLevelSensor;

import java.util.ArrayList;
import java.util.List;

public class PlantStationMocks {

    private static String[] mockStationNames =
            new String[]{"AAAA", "BBBB", "CCCC",
                    "DDDD", "EEEE", "FFFF", "GGGG",
                    "HHHH", "IIII", "JJJJ"};
    
    public static List<PlantStation> mockPlantStations() {
        List<PlantStation> mockList = new ArrayList<>();

        for (String s : mockStationNames) {
            PlantStation station = new PlantStationImpl(s, s, s, s);
            mockAllStationParts(station);
            mockList.add(station);
        }

        return mockList;
    }

    private static void mockAllStationParts(PlantStation station) {
        AmperageSensor amperageSensor = new AmperageSensorImpl("Amp", 33.31f);
        station.getPlantStationParts().add(amperageSensor);

        BatteryLevelSensor batteryLevelSensor = new BatteryLevelSensorImpl("Bat", new float[]{33f, 32f, 88.3f});
        station.getPlantStationParts().add(batteryLevelSensor);

        HumiditySensor humiditySensor = new HumiditySensorImpl("Hum", 1.22f);
        station.getPlantStationParts().add(humiditySensor);

        Pump pump = new PumpImpl("Pump", Pump.STATE_ON, 32.5f);
        station.getPlantStationParts().add(pump);

        RainSensor rainSensor = new RainSensorImpl("Rain", true);
        station.getPlantStationParts().add(rainSensor);

        SoilMoistureSensor soilMoistureSensor = new SoilMoistureSensorImpl("Soil", 735.33f);
        station.getPlantStationParts().add(soilMoistureSensor);

        SunlightSensor sunlightSensor = new SunlightSensorImpl("Sun", 22.4f);
        station.getPlantStationParts().add(sunlightSensor);

        Thermometer thermometer = new ThermometerImpl("Therm", 33.3f);
        station.getPlantStationParts().add(thermometer);

        Timer timer = new TimerImpl("Time", "NIEZNANY");
        station.getPlantStationParts().add(timer);

        VoltageSensor voltage = new VoltageSensorImpl("Volt", 54.3f);
        station.getPlantStationParts().add(voltage);

        WaterLevelSensor waterLevelSensor = new WaterLevelSensorImpl("Water", 33.3f);
        station.getPlantStationParts().add(waterLevelSensor);
    }

}
