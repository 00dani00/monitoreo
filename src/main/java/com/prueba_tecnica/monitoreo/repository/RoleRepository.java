package com.prueba_tecnica.monitoreo.repository;

import com.prueba_tecnica.monitoreo.modelo.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

}
