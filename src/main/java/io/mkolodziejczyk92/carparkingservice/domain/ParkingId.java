package io.mkolodziejczyk92.carparkingservice.domain;

import java.util.UUID;

public record ParkingId(String rawValue) {

    public static ParkingId random(){
        return new ParkingId(UUID.randomUUID().toString());
    }
}
