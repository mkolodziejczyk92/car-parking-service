package io.mkolodziejczyk92.carparkingservice.domain;

import lombok.Data;

@Data
public class CarParks {

    ParkingCoordinates parkingCoordinates;
    ParkingLocation parkingLocation;
    ParkingId parkingId;

}
