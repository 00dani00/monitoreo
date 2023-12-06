package com.prueba_tecnica.monitoreo.security;

import com.prueba_tecnica.monitoreo.modelo.Role;
import com.prueba_tecnica.monitoreo.modelo.User;
import com.prueba_tecnica.monitoreo.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private final User user;

    private final RoleRepository roleRepository;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> roles = new ArrayList<>();
        Role role = new Role();
        if(roleRepository.findById(user.getRole().getId()).isPresent()){
            String roleName = roleRepository.findById(user.getRole().getId()).get().getName();
            roles.add(new SimpleGrantedAuthority(roleName));
        }
        return roles;
    }


    @Override
    public String getUsername() {
        return user.getId();
    }

    @Override
    public String getPassword() {
        return null;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
