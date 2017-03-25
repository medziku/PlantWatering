package com.medziku.plantwatering.data;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class PlantStation implements PlantDevice {

    private String deviceId;
    private String bluetoothAddress;
    private String ownerKey; // ma jakoś wskazywać (nie bezpośrednio) na id właściciela
    //może to być jakieś invitationId czy cuś, ale narazie nieistotne

    private String name;



}
