package com.viepovsky.barber;

import org.springframework.data.jpa.repository.JpaRepository;

interface BarberRepository extends JpaRepository<Barber, Integer> {
}
