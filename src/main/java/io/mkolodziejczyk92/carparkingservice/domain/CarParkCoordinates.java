package io.mkolodziejczyk92.carparkingservice.domain;

import lombok.Builder;

@Builder
public record CarParkCoordinates(String latitude, String longitude) {

}
