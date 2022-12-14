package io.mkolodziejczyk92.carparkingservice.api;

import io.mkolodziejczyk92.carparkingservice.api.dto.CarParkIdDto;
import io.mkolodziejczyk92.carparkingservice.domain.CarPark;
import io.mkolodziejczyk92.carparkingservice.domain.CarParkId;
import io.mkolodziejczyk92.carparkingservice.domain.CarParkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping(value = "/car-park/{carParkId}")
    public ResponseEntity<CarPark> updateParkingValues(@PathVariable String carParkId,
                                                       @RequestParam String carParkName){
        CarParkId carParkIdIn = new CarParkId(carParkId);
        return ResponseEntity.ok().body(carParkService.updateCarPark(carParkIdIn, carParkName));
    }

    @DeleteMapping(value = "/car-park/{carParkId}")
    public ResponseEntity<CarPark> deleteCarParkValue(@PathVariable String carParkId){
        CarParkId carParkIdIn = new CarParkId(carParkId);
        carParkService.deleteCarPark(carParkIdIn);
        return ResponseEntity.noContent().build();
    }



}
