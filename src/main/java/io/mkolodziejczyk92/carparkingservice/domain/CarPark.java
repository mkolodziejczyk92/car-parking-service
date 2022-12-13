package io.mkolodziejczyk92.carparkingservice.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarPark {

    CarParkCoordinates carParkCoordinates;
    CarParkLocation carParkLocation;
    CarParkId carParkId;
    String parkingName;

}
