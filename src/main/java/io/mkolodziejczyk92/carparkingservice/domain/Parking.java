package io.mkolodziejczyk92.carparkingservice.domain;

import lombok.Data;

@Data
public class Parking {

    ParkingCoordinates parkingCoordinates;
    ParkingLocation parkingLocation;
    ParkingId parkingId;
    String parkingName;

}
