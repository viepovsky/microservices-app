package com.viepovsky.barber;

import org.springframework.stereotype.Service;

@Service
record BarberService(BarberRepository repository) {
    void registerBarber(BarberRegistrationRequest request) {
        Barber barber = Barber.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .company(request.company())
                .email(request.email())
                .build();

        repository.save(barber);
    }
}
