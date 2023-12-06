package com.prueba_tecnica.monitoreo.controller;

import com.prueba_tecnica.monitoreo.dtos.MaxDescriptionDTO;
import com.prueba_tecnica.monitoreo.modelo.User;
import com.prueba_tecnica.monitoreo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/users")
    public List<User> listUsers(){
        return service.listUsers();
    }

    @GetMapping("/user")
    public ResponseEntity<User> user(String email){
        try {
            User user = service.UserForEmail(email);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/users/MaxDescription")
    public List<User> listUsersForMaxDescription(@RequestBody MaxDescriptionDTO maxDescriptionDTO){
        return service.UserForMaxDescription(maxDescriptionDTO);}
}
