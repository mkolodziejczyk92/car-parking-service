package io.mkolodziejczyk92.carparkingservice.api;

import io.mkolodziejczyk92.carparkingservice.api.dto.CarParksIdDto;
import io.mkolodziejczyk92.carparkingservice.domain.ParkingId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {


    @PostMapping(value = "/parkings")
    public ResponseEntity<CarParksIdDto> addParking(){
        ParkingId parkingId = new ParkingId((UUID.randomUUID().toString()));

        CarParksIdDto carParksIdDto = new CarParksIdDto(parkingId.rawValue());
        return ResponseEntity.ok(carParksIdDto);
    }


}
