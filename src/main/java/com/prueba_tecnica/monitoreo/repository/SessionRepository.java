package com.prueba_tecnica.monitoreo.repository;

import com.prueba_tecnica.monitoreo.modelo.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface SessionRepository extends JpaRepository<Session, String> {
    @Query("SELECT s FROM Session s where s.sessionToken = ?1")
    Optional<Session> findBySessionToken(String sessionToken);
}
