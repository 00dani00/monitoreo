package com.prueba_tecnica.monitoreo.security;

import com.prueba_tecnica.monitoreo.modelo.Role;
import com.prueba_tecnica.monitoreo.modelo.Session;
import com.prueba_tecnica.monitoreo.modelo.User;
import com.prueba_tecnica.monitoreo.repository.RoleRepository;
import com.prueba_tecnica.monitoreo.repository.SessionRepository;
import com.prueba_tecnica.monitoreo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class TokenUtils {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    public UsernamePasswordAuthenticationToken getAuthentication(String token) {
        List<GrantedAuthority> roles = new ArrayList<>();
        Optional<Session> session = sessionRepository.findBySessionToken(token);
        if (session.isPresent()) {
            Optional<User> user = userRepository.findById(session.get().getUser().getId());
            if (user.isPresent()) {
                Optional<Role> rol =  roleRepository.findById(user.get().getRole().getId());
                if (rol.isPresent()){
                    String roleName = rol.get().getName();
                    roles.add(new SimpleGrantedAuthority(roleName));
                    return new UsernamePasswordAuthenticationToken(user, null, roles);
                }
            }
        }
        return new UsernamePasswordAuthenticationToken(null, null, Collections.emptyList());
    }
}
