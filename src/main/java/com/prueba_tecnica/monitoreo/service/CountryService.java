package com.prueba_tecnica.monitoreo.service;

import com.prueba_tecnica.monitoreo.modelo.Country;
import com.prueba_tecnica.monitoreo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CountryService {

    @Autowired
    private CountryRepository repository;

    public List<Country> listCountries(){ return repository.findAll();}
}
