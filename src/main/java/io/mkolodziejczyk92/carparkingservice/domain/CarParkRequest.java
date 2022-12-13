package io.mkolodziejczyk92.carparkingservice.domain;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class CarParkRequest {

    @NotBlank
    String carParkLatitude;
    @NotBlank
    String carParkLongitude;
    @NotBlank
    String carParkStreet;
    @NotBlank
    String carParkNumber;
    @NotBlank
    String carParkName;


}
