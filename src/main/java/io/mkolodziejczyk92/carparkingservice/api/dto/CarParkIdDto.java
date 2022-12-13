package io.mkolodziejczyk92.carparkingservice.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarParkIdDto {

    @JsonProperty(value = "car_park_id")
    String id;

}
