package com.prueba_tecnica.monitoreo.controller;

import com.prueba_tecnica.monitoreo.dtos.SearchMonitoringDTO;
import com.prueba_tecnica.monitoreo.modelo.User;
import com.prueba_tecnica.monitoreo.modelo.UserMonitoring;
import com.prueba_tecnica.monitoreo.service.UserMonitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserMonitoringController {
    @Autowired
    public UserMonitoringService service;

    @GetMapping("/userMonitoring")
    public List<UserMonitoring> listUserMonitoring(@RequestBody SearchMonitoringDTO searchMonitoringDTO, @RequestHeader("Authorization") String bearerToken){
        return service.UserMonitoringByUser(searchMonitoringDTO, bearerToken);
    }
    @GetMapping("/userMonitoring/max")
    public List<User> listUserMonitoringMax(@RequestBody SearchMonitoringDTO searchMonitoringDTO) {
        return service.UserMonitoringByMax(searchMonitoringDTO);
    }
}
