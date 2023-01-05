package io.mkolodziejczyk92.carparkingservice.domain.services;

import io.mkolodziejczyk92.carparkingservice.domain.CarPark;
import io.mkolodziejczyk92.carparkingservice.domain.CarParkId;
import io.mkolodziejczyk92.carparkingservice.domain.Mapper;
import io.mkolodziejczyk92.carparkingservice.domain.exceptions.CarParkNotFoundException;
import io.mkolodziejczyk92.carparkingservice.domain.repositories.CarParkRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CarParkService {

    CarParkRepository carParkRepository;
    Mapper mapper;


    public CarPark createCarPark(String carParkParameters) {
        CarPark carPark = mapper.carParkMapper(carParkParameters);
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
