package io.mkolodziejczyk92.carparkingservice.domain;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class CarParkingRequest {

    @NotBlank
    String parkingLatitude;
    @NotBlank
    String parkingLongitude;
    @NotBlank
    String parkingStreet;
    @NotBlank
    String parkingNumber;
    @NotBlank
    String parkingName;


}
