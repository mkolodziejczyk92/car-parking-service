package io.mkolodziejczyk92.carparkingservice.api.dto;

import io.mkolodziejczyk92.carparkingservice.domain.CarPark;
import io.mkolodziejczyk92.carparkingservice.domain.CarParkId;
import io.mkolodziejczyk92.carparkingservice.domain.CarParkService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/carParks")
@AllArgsConstructor
public class UserController {

    private final CarParkService carParkService;

    @GetMapping
    public ResponseEntity<Page<CarPark>> pageResponseEntity(){
        return ResponseEntity.ok().body(carParkService.getAllCarParks());
    }

    @GetMapping(path = "/{carParkId}/location")
    public ResponseEntity<LocationDto> getLocation(@PathVariable String carParkId){
        CarPark location = carParkService.getLocation(new CarParkId(carParkId));
        LocationDto locationDto = LocationDto
                .builder()
                .street(location.getCarParkLocation().street())
                .longitude(location.getCarParkCoordinates().longitude())
                .latitude((location.getCarParkCoordinates().latitude()))
                .plotNumber(location.getCarParkLocation().plotNumber())
                .build();
        return ResponseEntity.ok().body(locationDto);
    }
}
