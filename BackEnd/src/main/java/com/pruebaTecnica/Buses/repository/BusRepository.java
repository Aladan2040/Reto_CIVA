package com.pruebaTecnica.Buses.repository;

import com.pruebaTecnica.Buses.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus, Long> {
}
