package io.mkolodziejczyk92.carparkingservice.domain.services;

import io.mkolodziejczyk92.carparkingservice.domain.ParkingPlace;
import io.mkolodziejczyk92.carparkingservice.domain.ParkingPlaceId;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingPlaceService {

   public List<ParkingPlace> getParkingPlacesByParkingSize(Integer parkingSize) {
        List<ParkingPlace> parkingPlaces = new ArrayList<>();
        for (int i = 0; i < parkingSize; i++) {
            parkingPlaces.add(new ParkingPlace(ParkingPlaceId.random(),true));
        }
        return  parkingPlaces;
    }
}
