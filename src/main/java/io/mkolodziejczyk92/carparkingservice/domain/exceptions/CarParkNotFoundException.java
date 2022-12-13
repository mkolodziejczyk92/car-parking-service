package io.mkolodziejczyk92.carparkingservice.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Car park not found")
public class CarParkNotFoundException extends RuntimeException{

}
