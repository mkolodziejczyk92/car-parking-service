package io.mkolodziejczyk92.carparkingservice.domain.repositories;

import io.mkolodziejczyk92.carparkingservice.domain.CarPark;
import io.mkolodziejczyk92.carparkingservice.domain.CarParkId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarParkRepository extends MongoRepository<CarPark, CarParkId> {

    Optional<CarPark> findFirstByCarParkIdEquals(CarParkId carParkId);

    void deleteByCarParkIdEquals(CarParkId carParkId);

}
