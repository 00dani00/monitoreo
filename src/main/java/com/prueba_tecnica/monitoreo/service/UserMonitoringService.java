package com.prueba_tecnica.monitoreo.service;

import com.prueba_tecnica.monitoreo.dtos.SearchMonitoringDTO;
import com.prueba_tecnica.monitoreo.modelo.User;
import com.prueba_tecnica.monitoreo.modelo.UserMonitoring;
import com.prueba_tecnica.monitoreo.repository.UserMonitoringRepository;
import com.prueba_tecnica.monitoreo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;

@Service
public class UserMonitoringService {
    @Autowired
    private UserService service;
    @Autowired
    private UserMonitoringRepository repository;

    private final DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .appendPattern("yyyyMMdd")
            .parseDefaulting(java.time.temporal.ChronoField.HOUR_OF_DAY, 0)
            .parseDefaulting(java.time.temporal.ChronoField.MINUTE_OF_HOUR, 0)
            .parseDefaulting(java.time.temporal.ChronoField.SECOND_OF_MINUTE, 0)
            .parseDefaulting(java.time.temporal.ChronoField.MILLI_OF_SECOND, 0)
            .toFormatter();


    public List<UserMonitoring> UserMonitoringByUser(SearchMonitoringDTO searchMonitoringDTO, String bearerToken){
        User user = service.UserForEmail(searchMonitoringDTO.getEmail());

        System.out.println(bearerToken);

        if (bearerToken != null && bearerToken.startsWith("Bearer")) {
            String token = bearerToken.replace("Bearer ", "");

        }

        try {
            LocalDateTime start = LocalDateTime.parse(searchMonitoringDTO.getStart(), formatter);
            LocalDateTime end = LocalDateTime.parse(searchMonitoringDTO.getEnd(), formatter);
            return repository.findByCreatedAtBetweenAndUserId(start, end, user.getId());
        } catch (Exception e) {
            System.err.println("Error al parsear la cadena a LocalDateTime: " + e.getMessage());
        }
        return null;
    }

    public List<User> UserMonitoringByMax(SearchMonitoringDTO searchMonitoringDTO){
        try {
            LocalDateTime start = LocalDateTime.parse(searchMonitoringDTO.getStart(), formatter);
            LocalDateTime end = LocalDateTime.parse(searchMonitoringDTO.getEnd(), formatter);
            return repository.findTop3UsersWithMostRecords(start, end);
        } catch (Exception e) {
            System.err.println("Error al parsear la cadena a LocalDateTime: " + e.getMessage());
        }
        return null;
    }

}

