package com.prueba_tecnica.monitoreo.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SearchMonitoringDTO {
    private String email;
    private String start;
    private String end;
}
