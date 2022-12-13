package io.mkolodziejczyk92.carparkingservice.domain;

import lombok.Builder;

@Builder
public record CarParkLocation(String street, String plotNumber) {

}
