package com.prueba_tecnica.monitoreo.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MaxDescriptionDTO {
    private String description;
    private String idCountry;
    private String start;
    private String end;

}

