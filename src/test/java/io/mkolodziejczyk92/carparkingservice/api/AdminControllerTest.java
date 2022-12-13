package io.mkolodziejczyk92.carparkingservice.api;

import io.mkolodziejczyk92.carparkingservice.api.dto.CarParkIdDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AdminControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void whenAdminAddCarParkApplicationShouldReturnCarParkId() {
        //given
        String postCarParkUrl = "/admin/parkings";


        //when
        ResponseEntity<CarParkIdDto> carParksIdDtoResponseEntity =
                restTemplate.postForEntity(postCarParkUrl, null, CarParkIdDto.class);

        //then
        assertThat(carParksIdDtoResponseEntity.getStatusCode().equals(HttpStatus.CREATED)).isTrue();
        assertThat(carParksIdDtoResponseEntity.getBody()).isNotNull();
        assertThat(carParksIdDtoResponseEntity.getHeaders().get(HttpHeaders.LOCATION)).isNotNull();
        assertThat(carParksIdDtoResponseEntity.getHeaders().getLocation().toString().startsWith("/parkings"));

    }

}


