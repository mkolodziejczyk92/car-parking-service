package io.mkolodziejczyk92.carparkingservice.domain;

import java.util.UUID;

public record CarParkId(String rawValue) {

    public static CarParkId random(){
        return new CarParkId(UUID.randomUUID().toString());
    }
}
