package io.mkolodziejczyk92.carparkingservice.domain;

import io.mkolodziejczyk92.carparkingservice.domain.exceptions.CarParkNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CarParkService {

    CarParkRepository carParkRepository;

    public CarPark createCarPark(CarParkCoordinates carParkCoordinates,
                                 CarParkLocation carParkLocation,
                                 String parkingName) {
        CarPark carPark = CarPark.builder()
                .carParkCoordinates(carParkCoordinates)
                .carParkLocation(carParkLocation)
                .parkingName(parkingName)
                .carParkId(CarParkId.random())
                .build();
        return carParkRepository.save(carPark);
    }

    public Page<CarPark> getAllCarParks() {
        return carParkRepository.findAll(PageRequest.of(0, 100));
    }

    public CarPark updateCarPark(CarParkId carParkId, String parkingName) {
        Optional<CarPark> parking = carParkRepository.findFirstByCarParkIdEquals(carParkId);
        if (parking.isPresent()) {
            CarPark unpackedCarPark = parking.get();
            unpackedCarPark.setParkingName(parkingName);
            return carParkRepository.insert(unpackedCarPark);
        } else {
            throw new CarParkNotFoundException();
        }
    }

    public void deleteCarPark(CarParkId carParkId) {
        carParkRepository.deleteByCarParkIdEquals(carParkId);
    }

    public CarPark getLocation(CarParkId carParkId) {
        return carParkRepository.findFirstByCarParkIdEquals(carParkId).orElseThrow(CarParkNotFoundException::new);
    }
}
