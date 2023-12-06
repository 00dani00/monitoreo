package com.prueba_tecnica.monitoreo.controller;

import com.prueba_tecnica.monitoreo.modelo.Country;
import com.prueba_tecnica.monitoreo.modelo.User;
import com.prueba_tecnica.monitoreo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CountryController {
    @Autowired
    private CountryService service;

    @GetMapping("/countries")
    public List<Country> listCountries(){
        return service.listCountries();
    }
}
