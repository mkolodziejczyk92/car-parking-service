package io.mkolodziejczyk92.carparkingservice.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CarPark {

    CarParkCoordinates carParkCoordinates;
    CarParkLocation carParkLocation;
    CarParkId carParkId;
    String parkingName;
    List<ParkingPlace> parkingPlace;

}
