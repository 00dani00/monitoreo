package com.prueba_tecnica.monitoreo.repository;

import com.prueba_tecnica.monitoreo.modelo.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
}
