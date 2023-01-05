package io.mkolodziejczyk92.carparkingservice.domain;

import java.util.UUID;

public record ParkingPlaceId(String rawValue) {

    public static ParkingPlaceId random() {
        return new ParkingPlaceId(UUID.randomUUID().toString());
    }

}
