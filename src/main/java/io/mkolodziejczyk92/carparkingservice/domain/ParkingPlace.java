package io.mkolodziejczyk92.carparkingservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ParkingPlace {
    ParkingPlaceId parkingPlaceId;
    Boolean isAvailable;


}
