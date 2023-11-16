package com.viepovsky.barber;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface BarberRepository extends JpaRepository<Barber, Integer> {
}
