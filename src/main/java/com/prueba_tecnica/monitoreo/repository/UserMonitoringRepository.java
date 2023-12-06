package com.prueba_tecnica.monitoreo.repository;

import com.prueba_tecnica.monitoreo.modelo.User;
import com.prueba_tecnica.monitoreo.modelo.UserMonitoring;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UserMonitoringRepository extends JpaRepository<UserMonitoring, String> {
    List<UserMonitoring> findByCreatedAtBetweenAndUserId(LocalDateTime start, LocalDateTime end, String userId);
    @Query("SELECT u, COUNT(um.id) AS usageCount " +
            "FROM User u " +
            "JOIN UserMonitoring um ON u.id = um.user.id " +
            "WHERE um.createdAt BETWEEN :start AND :end " +
            "GROUP BY u.id, u.name, u.email " +
            "ORDER BY usageCount DESC ")
    List<User> findTop3UsersWithMostRecords(LocalDateTime start, LocalDateTime end);



}
