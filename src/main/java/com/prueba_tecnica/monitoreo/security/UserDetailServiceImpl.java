package com.prueba_tecnica.monitoreo.security;

import com.prueba_tecnica.monitoreo.modelo.User;
import com.prueba_tecnica.monitoreo.repository.RoleRepository;
import com.prueba_tecnica.monitoreo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow((() -> new UsernameNotFoundException("El usuario con id" + id + "no existe")));
        return new UserDetailsImpl(user, roleRepository);
    }

}
