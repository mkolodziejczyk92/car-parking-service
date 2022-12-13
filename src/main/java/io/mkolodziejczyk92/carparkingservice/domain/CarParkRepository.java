package io.mkolodziejczyk92.carparkingservice.domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarParkRepository extends MongoRepository<CarPark, CarParkId> {

    Optional<CarPark> findFirstByCarParkIdEquals(CarParkId carParkId);

    void deleteByCarParkIdEquals(CarParkId carParkId);

}
