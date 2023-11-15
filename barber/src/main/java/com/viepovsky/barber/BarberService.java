package com.viepovsky.barber;

import org.springframework.stereotype.Service;

@Service
record BarberService() {
    void registerBarber(BarberRegistrationRequest request) {
        Barber barber = Barber.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .company(request.company())
                .email(request.email())
                .build();
        //todo: check email if valid and not taken, store barber in db
    }
}
