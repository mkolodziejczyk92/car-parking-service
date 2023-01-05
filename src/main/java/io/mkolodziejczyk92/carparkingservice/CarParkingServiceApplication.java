package io.mkolodziejczyk92.carparkingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CarParkingServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(CarParkingServiceApplication.class, args);
    }


}
