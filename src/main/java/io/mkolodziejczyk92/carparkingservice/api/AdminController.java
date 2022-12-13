package io.mkolodziejczyk92.carparkingservice.api;

import io.mkolodziejczyk92.carparkingservice.api.dto.CarParkIdDto;
import io.mkolodziejczyk92.carparkingservice.domain.CarParkId;
import io.mkolodziejczyk92.carparkingservice.domain.CarParkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    private final CarParkService carParkService;

    public AdminController(CarParkService carParkService) {
        this.carParkService = carParkService;
    }

    @PostMapping(value = "/car-park")
    public ResponseEntity<CarParkIdDto> addCarPark(){
        CarParkId carParkId = new CarParkId((UUID.randomUUID().toString()));
        return ResponseEntity.created(URI.create("/car-park/"
                + carParkId.rawValue())).body(new CarParkIdDto(carParkId.rawValue()));
    }






}
