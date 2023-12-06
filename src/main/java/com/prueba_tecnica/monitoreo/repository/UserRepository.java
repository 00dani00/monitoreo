package com.prueba_tecnica.monitoreo.repository;

import com.prueba_tecnica.monitoreo.modelo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findOneByEmail(String email);

    @Query(value= "SELECT u.name, u.email, u.image, COUNT(um.id) AS usageCount " +
            "FROM User u " +
            "JOIN UserMonitoring um ON u.id = um.user.id " +
            "JOIN Country c ON u.id = c.id " +
            "WHERE um.description = ?1 " +
            "  AND c.id = ?2" +
            "  AND um.createdAt BETWEEN ?3 AND ?4 " +
            "GROUP BY u.id, u.name, u.email " +
            "ORDER BY usageCount DESC",
            nativeQuery=true)
    List<User> findByMaxDescription(String description, String idCountry, LocalDateTime start, LocalDateTime end);

}
