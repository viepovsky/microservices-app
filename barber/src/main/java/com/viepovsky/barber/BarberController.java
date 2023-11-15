package com.viepovsky.barber;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/barbers")
record BarberController(BarberService service) {
    @PostMapping
    public void registerBarber(@RequestBody BarberRegistrationRequest request) {
        log.info("New barber registration {}", request);
        service.registerBarber(request);
    }
}
