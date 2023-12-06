package com.prueba_tecnica.monitoreo.service;

import com.prueba_tecnica.monitoreo.dtos.MaxDescriptionDTO;
import com.prueba_tecnica.monitoreo.modelo.User;
import com.prueba_tecnica.monitoreo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    private final DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .appendPattern("yyyyMMdd")
            .parseDefaulting(java.time.temporal.ChronoField.HOUR_OF_DAY, 0)
            .parseDefaulting(java.time.temporal.ChronoField.MINUTE_OF_HOUR, 0)
            .parseDefaulting(java.time.temporal.ChronoField.SECOND_OF_MINUTE, 0)
            .parseDefaulting(java.time.temporal.ChronoField.MILLI_OF_SECOND, 0)
            .toFormatter();

    public List<User> listUsers(){ return repository.findAll();}

    public User UserForEmail(String email){return repository.findOneByEmail(email).get();}

    public List<User> UserForMaxDescription(MaxDescriptionDTO maxDescriptionDTO) {
        try {
            LocalDateTime start = LocalDateTime.parse(maxDescriptionDTO.getStart(), formatter);
            LocalDateTime end = LocalDateTime.parse(maxDescriptionDTO.getEnd(), formatter);
            return repository.findByMaxDescription(maxDescriptionDTO.getDescription(), maxDescriptionDTO.getIdCountry(), start, end);
        } catch (Exception e) {
            System.err.println("Error al parsear la cadena a LocalDateTime: " + e.getMessage());
        }
        return null;

    }

}
