package io.mkolodziejczyk92.carparkingservice.domain;

import io.mkolodziejczyk92.carparkingservice.domain.services.ParkingPlaceService;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Mapper {

   private final ParkingPlaceService parkingPlaceService = new ParkingPlaceService();

    public CarPark carParkMapper(String carParkParameters) {
        JSONObject jsonObjectFromInput = new JSONObject(carParkParameters);
        CarParkCoordinates carParkCoordinates =
                new CarParkCoordinates(
                        jsonObjectFromInput.getString("latitude"),
                        jsonObjectFromInput.getString("longitude"));
        CarParkLocation carParkLocation =
                new CarParkLocation(
                        jsonObjectFromInput.getString("street"),
                        jsonObjectFromInput.getString("plotNumber"));
        Integer parkingSize = jsonObjectFromInput.getInt("parkingSize");

        List<ParkingPlace> parkingPlacesFromInput = parkingPlaceService.getParkingPlacesByParkingSize(parkingSize);

        return CarPark.builder()
                .carParkCoordinates(carParkCoordinates)
                .carParkLocation(carParkLocation)
                .parkingName(jsonObjectFromInput.getString("parkingName"))
                .carParkId(CarParkId.random())
                .parkingPlace(parkingPlacesFromInput)
                .build();
    }

}
